package com.nokia.uwr.model;

import java.util.Map;

/**
 * @param name    name of the UE
 * @param signals measured signals from BTS's
 * @author MiSobecki
 */
public record Measurements(String name, Map<BTS, Integer> signals) {
}
