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
 */
@RestController
@RequestMapping("/api/calls")
@RequiredArgsConstructor
public class CallsController {

    private static final Logger LOGGER = LogManager.getLogger(CallsController.class);

    private final CallsHandler callsHandler;

    /**
     * @param measurements measured signal powers from BTS's for given UE.
     */
    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public void startCall(@RequestBody Measurements measurements) {
        LOGGER.info("Got request to start call with given measurements: " + measurements);

        callsHandler.startCall(measurements);

        LOGGER.info("Started call correctly");
    }

}
