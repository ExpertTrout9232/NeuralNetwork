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

    public void activate(LayerBase previousLayer, ActivationFunction activationFunction) {
        for (Neuron neuron : neurons) {
            neuron.activate(previousLayer, activationFunction);
        }
    }

    public void setError(Double[] error) {
        for (int i = 0; i < neurons.length; i++) {
            neurons[i].setError(error[i]);
        }
    }

    public void calculateWeightsGradient(LayerBase previousLayer) {
        for (Neuron neuron : neurons) {
            neuron.calculateGradients(previousLayer);
        }
    }

    public Double[] getWeightsFromNeuron(int neuronIndex) {
        return neurons[neuronIndex].getWeights();
    }

    public void updateWeights(double learningRate) {
        for (Neuron neuron : neurons) {
            neuron.updateWeights(learningRate);
        }
    }
}
