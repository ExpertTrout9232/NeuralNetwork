package com.experttrout9232.neuralnetwork;

public class Neuron implements NeuronBase {
    private double value;

    @Override
    public double getValue() {
        return value;
    }

    public void activate(ActivationFunction activationFunction) {
        value = activationFunction.activate(value);
    }
}
