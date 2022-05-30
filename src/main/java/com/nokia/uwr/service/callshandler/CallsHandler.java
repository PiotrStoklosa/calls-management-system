package com.nokia.uwr.service.callshandler;

import com.nokia.uwr.model.Measurements;

/**
 * Handler for calls.
 *
 * @author MiSobecki
 * @author Barbara Moczulska
 */
public interface CallsHandler {

    /**
     * Starts call for given UE.
     *
     * @param measurements measured signal powers to BTS's from given UE.
     * @author MiSobecki
     */
    void startCall(Measurements measurements);

    /**
     * Move call for given UE - changes location of UE and its assignment.
     *
     * @param measurements measured signal powers to BTS's from given UE.
     * @author MiSobecki
     */
    void moveCall(Measurements measurements);

    /**
     * Stop call for given UE.
     *
     * @param ueName name of the UE ending the connection.
     * @author Barbara Moczulska
     */
    void stopCall(String ueName);

}
