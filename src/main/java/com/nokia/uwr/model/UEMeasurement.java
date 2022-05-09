package com.nokia.uwr.model;

/**
 * @param name                name of the UE.
 * @param measuredSignalPower measured signal power to the assigned BTS.
 * @author MiSobecki.
 */
public record UEMeasurement(String name, int measuredSignalPower) {

    /**
     * @param btsConnectedTo BTS which UE should be connected to.
     * @param measurements   measured signal powers to BTS's from given UE.
     */
    public UEMeasurement(BTS btsConnectedTo, Measurements measurements) {
        this(measurements.name(), measurements.signals().get(btsConnectedTo));
    }

}
