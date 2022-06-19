package com.nokia.uwr.controller.callsysterminatecontroller;

import com.nokia.uwr.influx.QueryCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to terminate CallSys.
 *
 * @author Barbara Moczulska
 */
@RestController
@RequestMapping("/api/terminator")
public class CallSysTerminateController {

    QueryCreator queryCreator;

    @Autowired
    public CallSysTerminateController(QueryCreator queryCreator) {
        this.queryCreator = queryCreator;
    }

    private static final Logger LOGGER = LogManager.getLogger(CallSysTerminateController.class);

    /**
     * Terminate CallSys
     */
    @PostMapping
    public void terminate() {
        queryCreator.close();
        LOGGER.info("Terminated simulation");
    }
}
