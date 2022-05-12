package com.nokia.uwr.callsysinitializer.assignmentsmap;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentsMapFactoryImplTest {

    private AssignmentsMapFactory assignmentsMapFactory;

    @BeforeEach
    public void setup() {
        assignmentsMapFactory = new AssignmentsMapFactoryImpl();
    }

    @Test
    public void shouldCreateAssignmentsMapCorrectly() {
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
        Map<BTS, List<UEMeasurement>> result = assignmentsMapFactory.createAssignmentsMap(btsList);

        // then
        assertEquals(result, givenAssignments);
    }

}