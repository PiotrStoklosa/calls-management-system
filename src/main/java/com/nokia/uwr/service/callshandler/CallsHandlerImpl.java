package com.nokia.uwr.service.callshandler;

import com.nokia.uwr.assigntmentsalgorithm.AssignmentsAlgorithm;
import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;
import com.nokia.uwr.model.UEMeasurement;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CallsHandlerImpl implements CallsHandler {

    private static final Logger LOGGER = LogManager.getLogger(CallsHandlerImpl.class);

    private final ConnectionManager connectionManager;
    private final AssignmentsAlgorithm assignmentsAlgorithm;

    @Override
    public void startCall(Measurements measurements) throws EmptyMeasurementsMapException {
        LOGGER.info("Start call for UE: " + measurements.name());

        if (measurements.signals().isEmpty())
            throw new EmptyMeasurementsMapException(measurements.name());

        BTS connectToBts = assignmentsAlgorithm.findBTS(measurements);

        UEMeasurement ueMeasurement = new UEMeasurement(connectToBts, measurements);
        connectionManager.assignUE(connectToBts, ueMeasurement);

        LOGGER.info("Started call for UE successfully");
    }
}
