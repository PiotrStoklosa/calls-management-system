package com.nokia.uwr.service.callsysinitializer;

import com.nokia.uwr.model.BTS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Exception to be thrown when BTS list parameter is empty.
 *
 * @author MiSobecki
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmptyBTSListException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(EmptyBTSListException.class);

    public EmptyBTSListException(List<BTS> btsList) {
        super("BTS List is Empty: " + btsList);

        LOGGER.error("Thrown: " + this);
    }
}
