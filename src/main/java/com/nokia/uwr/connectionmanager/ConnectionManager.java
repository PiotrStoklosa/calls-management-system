package com.nokia.uwr.connectionmanager;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.UEMeasurement;

import java.util.List;
import java.util.Map;

/**
 * Stores information about UE's assignments to BTS's.
 *
 * @author MiSobecki
 * @author Barbara Moczulska
 */
public interface ConnectionManager {

    /**
     * Assigns UE to given BTS.
     *
     * @param bts           BTS to assign UE to.
     * @param ueMeasurement UE to be assigned with its measured signal power to given BTS.
     * @author MiSobecki
     */
    void assignUE(BTS bts, UEMeasurement ueMeasurement);

    /**
     * Reassigns UE to given BTS.
     *
     * @param bts           BTS to assign UE to.
     * @param ueMeasurement UE to be assigned with its measured signal power to given BTS.
     * @author MiSobecki
     */
    void reassignUE(BTS bts, UEMeasurement ueMeasurement);

    /**
     * Setter for assignments.
     *
     * @param assignments map of UE's assignments to BTS's.
     * @author MiSobecki
     */
    void setAssignments(Map<BTS, List<UEMeasurement>> assignments);

    /**
     * Getter for assignments.
     *
     * @author MiSobecki
     */
    Map<BTS, List<UEMeasurement>> getAssignments();

    /**
     * Searches for BTS with given name.
     *
     * @param name name of the BTS.
     * @return BTS object.
     * @author MiSobecki
     */
    BTS getBTSByName(String name);

    /**
     * Ends the connection for UE.
     *
     * @param ueName name of the UE.
     * @author Barbara Moczulska
     */
    void endConnection(String ueName);
}
