package com.nokia.uwr.controller.callsysterminatecontroller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger LOGGER = LogManager.getLogger(CallSysTerminateController.class);

    /**
     * Terminate CallSys
     */
    @PostMapping
    public void terminate() {
        LOGGER.info("Terminated simulation");
    }
}
