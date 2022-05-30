package com.nokia.uwr.assigntmentsalgorithm;

import com.nokia.uwr.model.Measurements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Primary
public class BestSignalPowerAssignmentsAlgorithm implements AssignmentsAlgorithm {

    private static final Logger LOGGER = LogManager.getLogger(BestSignalPowerAssignmentsAlgorithm.class);

    @Override
    public String findBTS(Measurements measurements) {
        LOGGER.info("Find BTS with best signal power to connect to from UE: " + measurements.name());

        String bestBTS = Collections.max(measurements.signals().entrySet(), Map.Entry.comparingByValue()).getKey();

        LOGGER.info("Found best BTS:" + bestBTS);

        return bestBTS;
    }

}
