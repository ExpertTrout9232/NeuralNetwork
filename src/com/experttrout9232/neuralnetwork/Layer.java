package com.experttrout9232.neuralnetwork;

public class Layer implements LayerBase {
    private Neuron[] neurons;

    public Layer(int neuronsCount, int previousLayerSize) {
        neurons = new Neuron[neuronsCount];

        for (int i = 0; i < neuronsCount; i++) {
            neurons[i] = new Neuron(previousLayerSize);
        }
    }

    @Override
    public NeuronBase[] getNeurons() {
        return neurons;
    }

    public void activate(Layer previousLayer, ActivationFunction activationFunction) {
        for (Neuron neuron : neurons) {
            neuron.activate(previousLayer, activationFunction);
        }
    }
}
