package com.nokia.uwr.connectionmanager;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;
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
     * Assigns UE to given BTS.
     *
     * @param bts BTS to assign UE to.
     * @param ueMeasurement UE to be assigned with its measured signal power to given BTS.
     */
    void assignUE(BTS bts, UEMeasurement ueMeasurement);

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

    BTS getBTSByName(String name);

}
