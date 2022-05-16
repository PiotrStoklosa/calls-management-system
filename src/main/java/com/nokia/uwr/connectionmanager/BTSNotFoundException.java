package com.nokia.uwr.connectionmanager;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.service.callsysinitializer.EmptyBTSListException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BTSNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(BTSNotFoundException.class);

    public BTSNotFoundException(String btsName) {
        super("Not found BTS with given name: " + btsName);

        LOGGER.error("Thrown: " + this);
    }
}
