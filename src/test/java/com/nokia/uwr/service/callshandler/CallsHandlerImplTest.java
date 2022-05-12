package com.nokia.uwr.service.callshandler;

import com.nokia.uwr.assigntmentsalgorithm.AssignmentsAlgorithm;
import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;
import com.nokia.uwr.model.UEMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class CallsHandlerImplTest {

    private CallsHandler callsHandler;
    private ConnectionManager connectionManager;
    private AssignmentsAlgorithm assignmentsAlgorithm;

    private Measurements measurements;

    private BTS bestBts;

    @BeforeEach
    public void setup() {
        connectionManager = mock(ConnectionManager.class);
        assignmentsAlgorithm = mock(AssignmentsAlgorithm.class);

        callsHandler = spy(new CallsHandlerImpl(connectionManager, assignmentsAlgorithm));

        bestBts = new BTS("BTS5", 30);

        measurements = new Measurements(
                "UE1",
                new HashMap<>(
                        Map.ofEntries(
                                Map.entry(new BTS("BTS1", 50), 25),
                                Map.entry(new BTS("BTS2", 60), 15),
                                Map.entry(new BTS("BTS3", 10), 8),
                                Map.entry(new BTS("BTS4", 20), 6),
                                Map.entry(bestBts, 29)
                        )));
    }

    @Test
    public void shouldThrowEmptyMeasurementsMapExceptionWhileGivenEmptyMapAsParameter() {
        // given
        Measurements emptyMeasurements = new Measurements("UE1", new HashMap<>());

        // when && then
        assertThrows(EmptyMeasurementsMapException.class, () -> callsHandler.startCall(emptyMeasurements));
    }

    @Test
    public void shouldFindBestBtsToConnectToAndAssignUEToIt() {
        // given
        UEMeasurement ueMeasurement = new UEMeasurement("UE1", 29);
        given(assignmentsAlgorithm.findBTS(measurements)).willReturn(bestBts);

        // when
        callsHandler.startCall(measurements);

        //then
        verify(assignmentsAlgorithm).findBTS(measurements);
        verify(connectionManager).assignUE(bestBts, ueMeasurement);
    }

}