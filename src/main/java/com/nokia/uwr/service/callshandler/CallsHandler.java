package com.nokia.uwr.service.callshandler;

import com.nokia.uwr.model.Measurements;

/**
 * Handler for calls.
 *
 * @author MiSobecki
 */
public interface CallsHandler {

    /**
     * Starts call for given UE.
     *
     * @param measurements measured signal powers to BTS's from given UE.
     */
    void startCall(Measurements measurements);

}
