package com.syskimy.scatalog.exceptions;

import com.syskimy.scatalog.exceptions.base.AbstractBaseException;
import com.syskimy.scatalog.exceptions.enums.InternalServerErrorExceptionTitleEnum;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends AbstractBaseException {
    public InternalServerErrorException(
            InternalServerErrorExceptionTitleEnum title,
            String message
    ) {
        super(title, HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
