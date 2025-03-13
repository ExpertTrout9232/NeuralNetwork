package com.experttrout9232.machinelearningutils;

public final class ErrorFunctions {
    private ErrorFunctions() {}

    public static double meanSquaredError(double realValue, double desiredValue) {
        return Math.pow(realValue - desiredValue, 2);
    }
}
