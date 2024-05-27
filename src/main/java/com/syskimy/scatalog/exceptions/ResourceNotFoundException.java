package com.syskimy.scatalog.exceptions;

import com.syskimy.scatalog.exceptions.base.AbstractBaseException;
import com.syskimy.scatalog.exceptions.enums.BaseExceptionEnum;
import com.syskimy.scatalog.exceptions.enums.ResourceNotFoundTitleEnum;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends AbstractBaseException {
    public ResourceNotFoundException(ResourceNotFoundTitleEnum title,
                                     String message) {
        super(title, HttpStatus.NOT_FOUND, message);
    }
}
