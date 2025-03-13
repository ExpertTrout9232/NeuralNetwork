package com.experttrout9232.neuralnetwork;

public class Main {
    public static void main(String[] args) {
        NeuralNetworkConfig config = new NeuralNetworkConfig(16, 2, 16, 1);

        NeuralNetwork network = new NeuralNetwork(config);

        network.train(256, 64, 0.01);
    }
}
