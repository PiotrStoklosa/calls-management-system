package com.nokia.uwr.service.callshandler;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmptyMeasurementsMapException extends RuntimeException {
    public EmptyMeasurementsMapException(String ueName) {
        super("Measurements map is empty for UE: " + ueName);
    }
}
