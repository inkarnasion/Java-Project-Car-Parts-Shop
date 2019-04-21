package org.softuni.carpartsshop.error;

import org.softuni.carpartsshop.config.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = Constant.ERROR_NOT_FOUND_EXCEPTION)
public class NotFoundExceptions extends RuntimeException {

    public NotFoundExceptions() {
    }

    public NotFoundExceptions(String message) {
        super(message);
    }
}
