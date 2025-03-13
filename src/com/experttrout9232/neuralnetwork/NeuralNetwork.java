package com.experttrout9232.neuralnetwork;

public class NeuralNetwork {
    private InputLayer inputLayer;
    private OutputLayer outputLayer;
    private Layer[] hiddenLayers;

    public NeuralNetwork(NeuralNetworkConfig config) {
        inputLayer = new InputLayer(config.inputLayerSize());
        outputLayer = new OutputLayer(config.outputLayerSize(), config.hiddenLayerSize());
        hiddenLayers = new Layer[config.hiddenLayerSize()];

        hiddenLayers[0] = new Layer(config.hiddenLayerSize(), config.inputLayerSize());
        for (int i = 1; i < config.hiddenLayersCount(); i++) {
            hiddenLayers[i] = new Layer(config.hiddenLayerSize(), config.hiddenLayerSize());
        }
    }

    public void feedforward(double[] input) {

    }

    public void backpropagation() {

    }

    public void train() {

    }
}
