package com.nokia.uwr.assigntmentsalgorithm;

import com.nokia.uwr.model.BTS;
import com.nokia.uwr.model.Measurements;

/**
 * Algorithm to find proper BTS to connect UE to.
 *
 * @author MiSobecki
 */
public interface AssignmentsAlgorithm {

    /**
     * Finds BTS where given UE should be connected to.
     *
     * @param measurements measured signals to BTS's from the UE.
     * @return BTS which UE should be connected to.
     */
    String findBTS(Measurements measurements);

}
