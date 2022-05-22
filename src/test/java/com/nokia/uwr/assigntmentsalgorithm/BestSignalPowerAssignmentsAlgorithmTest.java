package com.nokia.uwr.assigntmentsalgorithm;

import com.nokia.uwr.model.Measurements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestSignalPowerAssignmentsAlgorithmTest {

    private static AssignmentsAlgorithm assignmentsAlgorithm;

    @BeforeAll
    static void setup() {
        assignmentsAlgorithm = new BestSignalPowerAssignmentsAlgorithm();
    }

    @Test
    public void shouldReturnBtsWithBestMeasuredSignalPower() {
        // given
        Measurements measurements = new Measurements(
                "UE1",
                Map.ofEntries(
                        Map.entry("BTS1", 25),
                        Map.entry("BTS2", 15),
                        Map.entry("BTS3", 8),
                        Map.entry("BTS4", 6),
                        Map.entry("BestBTS", 29)
                ));

        // when
        String result = assignmentsAlgorithm.findBTS(measurements);

        // then
        assertEquals(result, "BestBTS");
    }

}