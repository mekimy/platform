package com.syskimy.scatalog.controllers.exception.impl;

import com.syskimy.scatalog.controllers.exception.CatalogExceptionController;
import com.syskimy.scatalog.exceptions.InternalServerErrorException;
import com.syskimy.scatalog.exceptions.ResourceNotFoundException;
import com.syskimy.scatalog.exceptions.base.AbstractBaseException;
import com.syskimy.scatalog.exceptions.enums.MethodArgumentsExceptionTitleEnum;
import com.syskimy.scatalog.resources.errors.ErrorDetailResource;
import com.syskimy.scatalog.resources.errors.ValidationErrorResource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CatalogExceptionControllerImpl implements CatalogExceptionController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetailResource> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorDetailResource errorDetailResource = new ErrorDetailResource();

        errorDetailResource.setTimestamp(Instant.now().toEpochMilli());
        errorDetailResource.setTitle(MethodArgumentsExceptionTitleEnum.METHOD_ARGUMENT_NOT_VALID.name());
        errorDetailResource.setTitle(MethodArgumentsExceptionTitleEnum.METHOD_ARGUMENT_NOT_VALID.getCode());
        errorDetailResource.setDeveloperMessage(ex.getClass().getName());
        errorDetailResource.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetailResource.setDetail("INPUT VALIDATION FAILED");

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fe: fieldErrors) {
            List<ValidationErrorResource> validationErrorResourceList = errorDetailResource
                    .getErrors()
                    .computeIfAbsent(fe.getField(), k -> new ArrayList<>());

            ValidationErrorResource validationErrorResource = new ValidationErrorResource();
            validationErrorResource.setCode(fe.getCode());
            validationErrorResource.setMessage(fe.getDefaultMessage());
            validationErrorResourceList.add(validationErrorResource);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetailResource);
    }

    @Override
    @ExceptionHandler({
            InternalServerErrorException.class,
            ResourceNotFoundException.class,
    })
    public ResponseEntity<ErrorDetailResource> handleGenericExceptions(AbstractBaseException e, HttpServletRequest request) {
        ErrorDetailResource errorDetailResource = new ErrorDetailResource();

        errorDetailResource.setTimestamp(Instant.now().toEpochMilli());
        errorDetailResource.setTitle(e.getTitle().toString());
        errorDetailResource.setCode(e.getTitle().getCode());
        errorDetailResource.setDeveloperMessage(e.getClass().getName());
        errorDetailResource.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetailResource.setDetail(e.getMessage());

        return ResponseEntity.status(e.getStatus()).body(errorDetailResource);
    }
}
