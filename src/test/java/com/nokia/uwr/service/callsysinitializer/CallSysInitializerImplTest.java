package com.nokia.uwr.service.callsysinitializer;

import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;
import com.nokia.uwr.service.callsysinitializer.assignmentsmap.AssignmentsMapFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CallSysInitializerImplTest {

    @Mock
    private ConnectionManager connectionManager;
    @Mock
    private AssignmentsMapFactory assignmentsMapFactory;
    @InjectMocks
    private CallSysInitializerImpl callSysInitializer;
    private static List<BTS> btsList;
    private static Map<BTS, List<UEMeasurement>> givenAssignments;

    @BeforeAll
    static void setup() {
        BTS bts1 = new BTS("BTS1", 50);
        BTS bts2 = new BTS("BTS2", 30);
        btsList = List.of(
                bts1,
                bts2);

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
