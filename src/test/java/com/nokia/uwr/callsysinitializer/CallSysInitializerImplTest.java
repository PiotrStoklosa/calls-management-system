package com.nokia.uwr.callsysinitializer;

import com.nokia.uwr.callsysinitializer.assignmentsmap.AssignmentsMapFactory;
import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class CallSysInitializerImplTest {

    private ConnectionManager connectionManager;
    private AssignmentsMapFactory assignmentsMapFactory;
    private CallSysInitializer callSysInitializer;
    private List<BTS> btsList;
    private Map<BTS, List<UEMeasurement>> givenAssignments;

    @BeforeEach
    public void setup() {
        connectionManager = mock(ConnectionManager.class);
        assignmentsMapFactory = mock(AssignmentsMapFactory.class);
        callSysInitializer = spy(new CallSysInitializerImpl(connectionManager, assignmentsMapFactory));

        BTS bts1 = new BTS("BTS1", 50);
        BTS bts2 = new BTS("BTS2", 30);
        btsList = new ArrayList<>(
                List.of(
                        bts1,
                        bts2));

        givenAssignments = new HashMap<>(
                Map.ofEntries(
                        Map.entry(bts1, new ArrayList<>()),
                        Map.entry(bts2, new ArrayList<>())
                ));
    }

    @Test
    public void shouldInitializeAssignmentsMapAndSetInConnectionManager() {
        // given
        given(assignmentsMapFactory.createAssignmentsMap(btsList)).willReturn(givenAssignments);

        // when
        callSysInitializer.initializeAssignments(btsList);

        // then
        verify(assignmentsMapFactory).createAssignmentsMap(btsList);
        verify(connectionManager).setAssignments(givenAssignments);
    }

    @Test
    public void shouldThrowEmptyBTSListExceptionWhileGivenEmptyListAsParameter() {
        assertThrows(EmptyBTSListException.class, () -> callSysInitializer.initializeAssignments(new ArrayList<>()));
    }

}
