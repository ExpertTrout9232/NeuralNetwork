package com.experttrout9232.neuralnetwork;

public class NeuralNetwork {
    private InputLayer inputLayer;
    private OutputLayer outputLayer;
    private Layer[] hiddenLayers;

    public NeuralNetwork(int hiddenLayersCount) {
        this.inputLayer = new InputLayer();
        this.outputLayer = new OutputLayer();
        this.hiddenLayers = new Layer[hiddenLayersCount];

        for (int i = 0; i < hiddenLayersCount; i++) {
            hiddenLayers[i] = new Layer();
        }
    }

    public void feedForward(double[] input) {

    }
}
