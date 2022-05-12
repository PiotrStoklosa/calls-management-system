package com.nokia.uwr.callsysinitializer;

import com.nokia.uwr.connectionmanager.ConnectionManager;
import com.nokia.uwr.model.BTS;

import java.util.List;

/**
 * Initializes ConnectionManager.
 *
 * @author MiSobecki
 */
public interface CallSysInitializer {

    /**
     * Initializes map of BTS's and lists of UE's assigned to them.
     *
     * @param btsList list of BTS's.
     */
    ConnectionManager initializeAssignments(List<BTS> btsList);

}
