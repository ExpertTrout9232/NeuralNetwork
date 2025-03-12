package com.experttrout9232.neuralnetwork;

import java.util.Random;

public class Neuron implements NeuronBase {
    private double value;
    private Double[] weights;
    private double bias;
    private static Random random = new Random();

    public Neuron(int neuronsCount) {
        weights = new Double[neuronsCount];
        bias = 0.0;

        for (int i = 0; i < neuronsCount; i++) {
            weights[i] = random.nextGaussian() * 0.01;
        }
    }

    @Override
    public double getValue() {
        return value;
    }

    public void activate(ActivationFunction activationFunction) {
        value = activationFunction.activate(value);
    }
}
