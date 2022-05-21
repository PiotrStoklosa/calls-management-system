package com.nokia.uwr.connectionmanager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be thrown when there is no BTS in assignments map with given name.
 *
 * @author MiSobecki
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BTSNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(BTSNotFoundException.class);

    public BTSNotFoundException(String btsName) {
        super("Not found BTS with given name: " + btsName);

        LOGGER.error("Thrown: " + this);
    }
}
