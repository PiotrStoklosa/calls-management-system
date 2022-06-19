package com.nokia.uwr.assigntmentsalgorithm;

import com.nokia.uwr.model.Measurements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomAssignmentsAlgorithmImpl implements AssignmentsAlgorithm {

    private static final Logger LOGGER = LogManager.getLogger(RandomAssignmentsAlgorithmImpl.class);

    @Override
    public String findBTS(Measurements measurements) {
        LOGGER.info("Find random BTS to connect to from UE: " + measurements.name());

        Random random = new Random();
        List<String> allBts = new ArrayList<>(measurements.signals().keySet());
        String randomBts = allBts.get(random.nextInt(allBts.size()));

        LOGGER.info("Found random BTS to connect to from UE: " + randomBts);

        return randomBts;
    }


}
