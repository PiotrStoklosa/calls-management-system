package com.nokia.uwr.controller.callscontroller;

import com.nokia.uwr.model.Measurements;
import com.nokia.uwr.service.callshandler.CallsHandler;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for calls.
 *
 * @author MiSobecki
 * @author Barbara Moczulska
 */
@RestController
@RequestMapping("/api/calls")
@RequiredArgsConstructor
public class CallsController {

    private static final Logger LOGGER = LogManager.getLogger(CallsController.class);

    private final CallsHandler callsHandler;

    /**
     * Starts call for given UE.
     *
     * @param measurements measured signal powers from BTS's for given UE.
     * @author MiSobecki
     */
    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public void startCall(@RequestBody Measurements measurements) {
        LOGGER.info("Got request to start call with given measurements: " + measurements);

        callsHandler.startCall(measurements);

        LOGGER.info("Started call correctly");
    }

    /**
     * Stop call for given UE.
     *
     * @param measurements measured signal powers from BTS's for given UE.
     * @author Barbara Moczulska
     */
    @PostMapping("/stop")
    @ResponseStatus(HttpStatus.OK)
    public void stopCall(@RequestBody Measurements measurements) {
        LOGGER.info("Got request to stop call with given measurements: " + measurements);

        callsHandler.stopCall(measurements.name());

        LOGGER.info("Stopped call correctly");
    }

}
