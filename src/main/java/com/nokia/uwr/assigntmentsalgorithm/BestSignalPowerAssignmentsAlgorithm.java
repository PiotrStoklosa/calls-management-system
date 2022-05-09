package com.nokia.uwr.assigntmentsalgorithm;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class BestSignalPowerAssignmentsAlgorithm implements AssignmentsAlgorithm {

    private static final Logger LOGGER = LogManager.getLogger(BestSignalPowerAssignmentsAlgorithm.class);

    @Override
    public BTS findBTS(Measurements measurements) {
        LOGGER.info("Find BTS with best signal power to connect to from UE: " + measurements.name());

        return Collections.max(measurements.signals().entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}
