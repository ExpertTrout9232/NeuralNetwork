package com.experttrout9232.neuralnetwork;

public class InputNeuron implements NeuronBase {
    private double value;

    public InputNeuron(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }
}
