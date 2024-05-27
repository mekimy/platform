package com.syskimy.scatalog.exceptions.base;

import com.syskimy.scatalog.exceptions.enums.BaseExceptionEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AbstractBaseException extends RuntimeException {
    private final HttpStatus status;
    private final BaseExceptionEnum title;

    public AbstractBaseException(
            BaseExceptionEnum title,
            HttpStatus status,
            String message
    ) {
        super(message);
        this.title = title;
        this.status = status;
    }
}
