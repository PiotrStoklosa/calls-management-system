package com.nokia.uwr.connectionmanager;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ConnectionManagerImpl implements ConnectionManager {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionManagerImpl.class);
    private Map<BTS, List<UEMeasurement>> assignments;

    @Override
    public void assignUE(BTS bts, UEMeasurement ueMeasurement) {
        LOGGER.info("Assign UE: " + ueMeasurement.name() + " to BTS: " + bts.name());

        assignments.get(bts).add(ueMeasurement);

        LOGGER.info("Assigned UE successfully");
    }

    public void setAssignments(Map<BTS, List<UEMeasurement>> assignments) {
        LOGGER.info("Set assignments: " + assignments);

        this.assignments = assignments;

        LOGGER.info("Set assignments successfully");
    }

    public Map<BTS, List<UEMeasurement>> getAssignments() {
        return assignments;
    }
}
