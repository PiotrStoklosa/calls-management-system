package com.nokia.uwr.connectionmanager;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConnectionManagerImplTest {

    private ConnectionManager connectionManager;
    private BTS expectedBTS;

    @BeforeEach
    public void setup() {
        connectionManager = new ConnectionManagerImpl();

        expectedBTS = new BTS("BTS1", 50);

        Map<BTS, List<UEMeasurement>> assignments = new HashMap<>(
                Map.ofEntries(
                        Map.entry(
                                expectedBTS,
                                new ArrayList<>(List.of(new UEMeasurement("UE1", 20))))
                ));

        connectionManager.setAssignments(assignments);
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

}