package com.experttrout9232.machinelearningutils;

public final class ActivationFunctions {
    private ActivationFunctions() {}

    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public static double sigmoidDerivative(double x) {
        return x * (1 - x);
    }

    public static double relu(double x) {
        return Math.max(0, x);
    }
}
