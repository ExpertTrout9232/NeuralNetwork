package com.experttrout9232.neuralnetwork;

public class Layer {
    private Neuron[] neurons;

    public Layer(int neuronsCount) {
        neurons = new Neuron[neuronsCount];

        for (int i = 0; i < neuronsCount; i++) {
            neurons[i] = new Neuron();
        }
    }

    public Neuron[] getNeurons() {
        return neurons;
    }
}
