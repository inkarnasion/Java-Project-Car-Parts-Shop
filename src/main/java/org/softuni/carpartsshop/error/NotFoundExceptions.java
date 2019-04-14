package org.softuni.carpartsshop.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found!")
public class NotFoundExceptions extends RuntimeException {

    public NotFoundExceptions() {
    }

    public NotFoundExceptions(String message) {
        super(message);
    }
}
