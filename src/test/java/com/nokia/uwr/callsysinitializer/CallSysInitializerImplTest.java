package com.nokia.uwr.callsysinitializer;

import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CallSysInitializerImplTest {

    @Autowired
    private CallSysInitializer callSysInitializer;
    @Autowired
    private ConnectionManager connectionManager;

    @Test
    public void shouldInitializeAssignmentsMapAndSetInConnectionManager() {
        // given
        BTS bts1 = new BTS("BTS1", 50);
        BTS bts2 = new BTS("BTS2", 30);
        List<BTS> btsList = new ArrayList<>(
                List.of(
                        bts1,
                        bts2));

        Map<BTS, List<UEMeasurement>> givenAssignments = new HashMap<>(
                Map.ofEntries(
                        Map.entry(bts1, new ArrayList<>()),
                        Map.entry(bts2, new ArrayList<>())
                ));

        // when
        callSysInitializer.initializeAssignments(btsList);

        Map<BTS, List<UEMeasurement>> resultAssignments = connectionManager.getAssignments();

        // then
        assertEquals(givenAssignments, resultAssignments);
    }

}
