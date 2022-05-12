package com.nokia.uwr.service.callshandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmptyMeasurementsMapException extends RuntimeException {
    public EmptyMeasurementsMapException(String ueName) {
        super("Measurements map is empty for UE: " + ueName);
    }
}
