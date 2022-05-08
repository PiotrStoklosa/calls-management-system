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

    private static final Logger LOGGER = LogManager.getLogger(CallSysInitializerImpl.class);
    private final ConnectionManager connectionManager;

    @Override
    public void initializeAssignments(List<BTS> btsList) throws EmptyBTSListException {
        LOGGER.info("Create assignments map from btsList: " + btsList);

        if (btsList.isEmpty()) throw new EmptyBTSListException(btsList);

        Map<BTS, List<UEMeasurement>> assignments = btsList.stream()
                .map(bts -> Map.entry(bts, new ArrayList<UEMeasurement>()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        LOGGER.info("Created assignments map successfully");

        connectionManager.setAssignments(assignments);
    }
}
