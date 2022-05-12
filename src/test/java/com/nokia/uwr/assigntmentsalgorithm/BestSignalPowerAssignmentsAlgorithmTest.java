package com.nokia.uwr.assigntmentsalgorithm;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BestSignalPowerAssignmentsAlgorithmTest {

    private AssignmentsAlgorithm assignmentsAlgorithm;

    @BeforeEach
    public void setup() {
        assignmentsAlgorithm = new BestSignalPowerAssignmentsAlgorithm();
    }

    @Test
    public void shouldReturnBtsWithBestSignalPower() {
        // given
        Measurements measurements = new Measurements(
                "UE1",
                new HashMap<>(
                        Map.ofEntries(
                                Map.entry(new BTS("BTS1", 50), 25),
                                Map.entry(new BTS("BTS2", 60), 15),
                                Map.entry(new BTS("BTS3", 10), 8),
                                Map.entry(new BTS("BTS4", 20), 6),
                                Map.entry(new BTS("BTS5", 30), 29)
                        )));

        // when
        BTS result = assignmentsAlgorithm.findBTS(measurements);

        // then
        assertEquals(result.name(), "BTS5");
        assertEquals(result.signalPower(), 30);
    }

}