package com.nokia.uwr.service.callsysinitializer.assignmentsmap;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;

import java.util.List;
import java.util.Map;

/**
 * Factory to create assignments map.
 *
 * @author MiSobecki
 */
public interface AssignmentsMapFactory {

    /**
     * Creates assignment map from BTS's list.
     *
     * @param btsList BTS's list.
     * @return map of assignments.
     */
    Map<BTS, List<UEMeasurement>> createAssignmentsMap(List<BTS> btsList);

}
