package com.nokia.uwr.connectionmanager;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;

import java.util.List;
import java.util.Map;

/**
 * Stores information about UE's assignments to BTS's.
 *
 * @author MiSobecki
 */
public interface ConnectionManager {

    /**
     * Setter for assignments.
     *
     * @param assignments map of UE's assignments to BTS's.
     */
    void setAssignments(Map<BTS, List<UEMeasurement>> assignments);

    /**
     * Getter for assignments.
     */
    Map<BTS, List<UEMeasurement>> getAssignments();

}
