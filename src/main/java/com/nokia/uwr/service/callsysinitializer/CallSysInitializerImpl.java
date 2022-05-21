package com.nokia.uwr.service.callsysinitializer;

import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import com.nokia.uwr.service.callsysinitializer.assignmentsmap.AssignmentsMapFactory;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CallSysInitializerImpl implements CallSysInitializer {

    private static final Logger LOGGER = LogManager.getLogger(CallSysInitializerImpl.class);
    private final ConnectionManager connectionManager;
    private final AssignmentsMapFactory assignmentsMapFactory;

    @Override
    public ConnectionManager initializeAssignments(List<BTS> btsList) {
        LOGGER.info("Initialize assignments from btsList: " + btsList);

        if (btsList.isEmpty()) throw new EmptyBTSListException(btsList);

        Map<BTS, List<UEMeasurement>> assignments = assignmentsMapFactory.createAssignmentsMap(btsList);

        connectionManager.setAssignments(assignments);

        LOGGER.info("Initialized assignments successfully");

        return connectionManager;
    }
}
