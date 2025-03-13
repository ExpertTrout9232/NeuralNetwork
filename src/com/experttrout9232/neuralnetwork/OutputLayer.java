package com.experttrout9232.neuralnetwork;

import com.experttrout9232.machinelearningutils.ErrorFunctions;

public class OutputLayer extends Layer {
    private Double error = 0.0;

    public OutputLayer(int neuronsCount, int previousLayerSize) {
        super(neuronsCount, previousLayerSize);
    }

    public void calculateError(Double[] desiredOutput) {
        for (int i = 0; i < super.getNeurons().length; i++) {
            error += ErrorFunctions.meanSquaredError(desiredOutput[i], super.getNeurons()[i].getValue());
        }
    }

    public double calculateCost(int batchSize) {
        return error / batchSize;
    }
}
