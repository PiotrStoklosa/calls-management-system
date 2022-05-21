package com.nokia.uwr.service.callshandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be thrown when measurements map parameter is empty.
 *
 * @author MiSobecki
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmptyMeasurementsMapException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(EmptyMeasurementsMapException.class);

    public EmptyMeasurementsMapException(String ueName) {
        super("Measurements map is empty for UE: " + ueName);

        LOGGER.error("Thrown: " + this);
    }
}
