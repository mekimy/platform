package com.syskimy.scatalog.controllers.exception;

import com.syskimy.scatalog.exceptions.base.AbstractBaseException;
import com.syskimy.scatalog.resources.errors.ErrorDetailResource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface CatalogExceptionController {
    ResponseEntity<ErrorDetailResource> handleGenericExceptions(
            AbstractBaseException e, HttpServletRequest request);
}
