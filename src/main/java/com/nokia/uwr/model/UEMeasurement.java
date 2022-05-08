package com.nokia.uwr.model;

/**
 * @param name                name of the UE.
 * @param measuredSignalPower measured signal power to the assigned BTS.
 * @author MiSobecki.
 */
public record UEMeasurement(String name, int measuredSignalPower) {
}
