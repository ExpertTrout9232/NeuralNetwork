package com.experttrout9232.neuralnetwork;

public class InputLayer implements LayerBase {
    private InputNeuron[] neurons;

    public InputLayer(int neuronsCount) {
        neurons = new InputNeuron[neuronsCount];
    }

    @Override
    public NeuronBase[] getNeurons() {
        return neurons;
    }

    public void setNeurons(Double[] inputValues) {
        for (int i = 0; i < neurons.length; i++) {
            neurons[i] = new InputNeuron(inputValues[i]);
        }
    }
}
