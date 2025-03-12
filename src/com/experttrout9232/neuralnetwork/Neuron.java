package com.experttrout9232.neuralnetwork;

import java.util.Random;

public class Neuron implements NeuronBase {
    private double value;
    private int neuronsCount;
    private Double[] weights;
    private double bias;
    private static Random random = new Random();

    public Neuron(int neuronsCount) {
        this.neuronsCount = neuronsCount;
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

    public void activate(Layer previousLayer, ActivationFunction activationFunction) {
        double z = 0.0;

        for (int i = 0; i < neuronsCount; i++) {
            z += previousLayer.getNeurons()[i].getValue() * weights[i];
        }
        z += bias;

        value = activationFunction.activate(z);
    }
}
