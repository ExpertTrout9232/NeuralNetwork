package com.experttrout9232.neuralnetwork;

public class Neuron implements NeuronBase {
    private double value;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    public void activate(ActivationFunction activationFunction) {
        value = activationFunction.activate(value);
    }
}
