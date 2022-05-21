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

    @Override
    public BTS getBTSByName(String name) {
        LOGGER.info("Search for BTS with given name: " + name);

        BTS foundBTS = assignments.entrySet().stream()
                .filter(x -> x.getKey().name().equals(name))
                .findFirst()
                .orElseThrow(() -> new BTSNotFoundException(name))
                .getKey();

        LOGGER.info("Found BTS");

        return foundBTS;
    }

    @Override
    public void endConnection(String ueName) {
        LOGGER.info("Ending connection for UE with given name: " + ueName);

        //assignments.forEach((bts, ueList) -> ueList.forEach(ue -> ueList.removeIf(i -> (i.name().equals(ueName)))));

        LOGGER.info("Ending connection successfully");
    }
}
