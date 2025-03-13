package com.experttrout9232.neuralnetwork;

public record NeuralNetworkConfig(
        int inputLayerSize,
        int hiddenLayersCount,
        int hiddenLayerSize,
        int outputLayerSize
) {}
