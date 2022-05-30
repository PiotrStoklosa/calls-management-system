package com.nokia.uwr.connectionmanager;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConnectionManagerImplTest {

    private static ConnectionManager connectionManager;
    private static BTS expectedBTS;

    @BeforeAll
    static void setup() {
        connectionManager = new ConnectionManagerImpl();

        expectedBTS = new BTS("BTS1", 50);
    }

    @BeforeEach
    void setupBeforeEach() {
        Map<BTS, List<UEMeasurement>> assignments = new HashMap<>(
                Map.ofEntries(
                        Map.entry(
                                expectedBTS,
                                new ArrayList<>(List.of(new UEMeasurement("UE1", 20))))
                ));

        connectionManager.setAssignments(assignments);
    }

    @Test
    public void shouldRemoveUEConnection() {
        // given
        String ueName = "UE1";

        Map<BTS, List<UEMeasurement>> assignmentsResult = new HashMap<>(
                Map.ofEntries(
                        Map.entry(
                                new BTS("BTS1", 50),
                                new ArrayList<>())
                ));

        // when
        connectionManager.endConnection(ueName);

        // then
        assertEquals(connectionManager.getAssignments(), assignmentsResult);

    }

    @Test
    public void shouldReturnBTSObjectWithGivenName() {
        // given
        String btsName = "BTS1";

        // when
        BTS result = connectionManager.getBTSByName(btsName);

        // then
        assertEquals(result, expectedBTS);
    }

    @Test
    public void shouldThrowBTSNotFoundExceptionWhileGivenNonExistingBTSName() {
        // given
        String btsName = "BTS2";

        // when && then
        assertThrows(BTSNotFoundException.class, () -> connectionManager.getBTSByName(btsName));
    }

    @Test
    public void shouldAssignUE() {
        // given
        UEMeasurement newUeMeasurement = new UEMeasurement("UE10", 70);

        // when
        connectionManager.assignUE(expectedBTS, newUeMeasurement);

        Map<BTS, List<UEMeasurement>> expectedAssignments = new HashMap<>(
                Map.ofEntries(
                        Map.entry(
                                expectedBTS,
                                new ArrayList<>(List.of(
                                        new UEMeasurement("UE1", 20),
                                        newUeMeasurement)))
                ));

        // then
        assertEquals(connectionManager.getAssignments(), expectedAssignments);
    }

    @Test
    public void shouldReassignUE() {
        // given
        UEMeasurement newUeMeasurement = new UEMeasurement("UE1", 70);

        // when
        connectionManager.reassignUE(expectedBTS, newUeMeasurement);

        Map<BTS, List<UEMeasurement>> expectedAssignments = new HashMap<>(
                Map.ofEntries(
                        Map.entry(
                                expectedBTS,
                                new ArrayList<>(List.of(newUeMeasurement)))
                ));

        // then
        assertEquals(expectedAssignments, connectionManager.getAssignments());
    }

}