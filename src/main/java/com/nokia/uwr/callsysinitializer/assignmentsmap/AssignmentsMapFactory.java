package com.nokia.uwr.callsysinitializer.assignmentsmap;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;

import java.util.List;
import java.util.Map;

public interface AssignmentsMapFactory {

    Map<BTS, List<UEMeasurement>> createAssignmentsMap(List<BTS> btsList);

}
