package com.nokia.uwr.callsysinitializer;

import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CallSysInitializerImpl implements CallSysInitializer {

    private final ConnectionManager connectionManager;
    private static final Logger LOGGER = LogManager.getLogger(CallSysInitializerImpl.class);

    @Override
    public void initializeAssignments(List<BTS> btsList) {
        LOGGER.info("Create assignments map");

        Map<BTS, List<UEMeasurement>> assignments = btsList.stream()
                .map(bts -> Map.entry(bts, new ArrayList<UEMeasurement>()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        LOGGER.info("Created assignments map successfully");

        connectionManager.setAssignments(assignments);
    }
}
