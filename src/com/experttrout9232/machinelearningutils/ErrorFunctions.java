package com.experttrout9232.machinelearningutils;

public final class ErrorFunctions {
    private ErrorFunctions() {}

    public static double meanSquaredError(double actualValue, double desiredValue) {
        return Math.pow(actualValue - desiredValue, 2);
    }
}
