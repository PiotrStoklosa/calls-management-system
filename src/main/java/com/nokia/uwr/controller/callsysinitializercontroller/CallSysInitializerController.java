package com.nokia.uwr.controller.callsysinitializercontroller;

import com.nokia.uwr.callsysinitializer.CallSysInitializer;
import com.nokia.uwr.model.BTS;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to initialize CallSys.
 *
 * @author MiSobecki
 */
@RestController
@RequestMapping("/api/initializer")
@RequiredArgsConstructor
public class CallSysInitializerController {

    private static final Logger LOGGER = LogManager.getLogger(CallSysInitializerController.class);
    private final CallSysInitializer callSysInitializer;

    /**
     * @param btsList list of BTS's to initialize assignments from.
     */
    @PostMapping
    public void initialize(@RequestBody List<BTS> btsList) throws EmptyBTSListException {
        LOGGER.info("Got request to initialize from btsList: " + btsList);

        if (btsList.isEmpty()) throw new EmptyBTSListException("BTS List is Empty");

        callSysInitializer.initializeAssignments(btsList);
    }

}
