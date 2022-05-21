package com.nokia.uwr.service.callshandler;

import com.nokia.uwr.assigntmentsalgorithm.AssignmentsAlgorithm;
import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;
import com.nokia.uwr.model.UEMeasurement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class CallsHandlerImplTest {

    private static CallsHandler callsHandler;
    @Mock
    private static ConnectionManager connectionManager;
    @Mock
    private static AssignmentsAlgorithm assignmentsAlgorithm;

    private static Measurements measurements;

    private static BTS bestBts;

    @BeforeAll
    static void setup() {
        callsHandler = spy(new CallsHandlerImpl(connectionManager, assignmentsAlgorithm));

        bestBts = new BTS("BTS5", 70);

        measurements = new Measurements(
                "UE1",
                Map.ofEntries(
                        Map.entry("BTS1", 25),
                        Map.entry("BTS2", 15),
                        Map.entry("BTS3", 8),
                        Map.entry("BTS4", 6),
                        Map.entry(bestBts.name(), 29)
                ));
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
        given(assignmentsAlgorithm.findBTS(measurements)).willReturn(bestBts.name());
        given(connectionManager.getBTSByName(bestBts.name())).willReturn(bestBts);

        // when
        callsHandler.startCall(measurements);

        //then
        verify(assignmentsAlgorithm).findBTS(measurements);
        verify(connectionManager).getBTSByName(bestBts.name());
        verify(connectionManager).assignUE(bestBts, ueMeasurement);
    }

}