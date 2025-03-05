package com.experttrout9232.neuralnetwork;

public class Neuron implements INeuron {
    private double value;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    public void activate(Runnable activationFunction) {
        activationFunction.run();
    }
}
