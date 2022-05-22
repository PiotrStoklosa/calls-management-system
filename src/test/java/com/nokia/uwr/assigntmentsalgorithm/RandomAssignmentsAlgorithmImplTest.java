package com.nokia.uwr.assigntmentsalgorithm;

import com.nokia.uwr.model.Measurements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class RandomAssignmentsAlgorithmImplTest {

    private static AssignmentsAlgorithm assignmentsAlgorithm;

    @BeforeEach
    void setup(){
        assignmentsAlgorithm = new RandomAssignmentsAlgorithmImpl();
    }

    @Test
    void shouldReturnRandomBtsThatIsInTheMap(){

        Measurements measurements = new Measurements(
                "UE1",
                Map.ofEntries(
                        Map.entry("BTS1", 25),
                        Map.entry("BTS2", 15),
                        Map.entry("BTS3", 8),
                        Map.entry("BTS4", 6)
                ));

        //when
        String result = assignmentsAlgorithm.findBTS(measurements);

        //then
        Assertions.assertTrue(measurements.signals().containsKey(result));
    }

}