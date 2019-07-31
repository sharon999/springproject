package io.sharon.demo.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends DefaultException {

    public ResourceNotFoundException(String errorCode, Object... messageArguments) {
        super(errorCode, messageArguments);
    }
}
