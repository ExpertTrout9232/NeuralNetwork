package com.experttrout9232.neuralnetwork;

import java.util.Random;

public class Neuron implements NeuronBase {
    private double value;
    private int neuronsCount;
    private Double[] weights;
    private double bias;
    private static Random random = new Random();
    private double error;
    private Double[] weightsGradient;
    private double biasGradient;

    public Neuron(int neuronsCount) {
        this.neuronsCount = neuronsCount;
        weights = new Double[neuronsCount];
        weightsGradient = new Double[neuronsCount];
        bias = 0.0;

        for (int i = 0; i < neuronsCount; i++) {
            weights[i] = random.nextGaussian() * 0.01;
        }
    }

    @Override
    public double getValue() {
        return value;
    }

    public void activate(LayerBase previousLayer, ActivationFunction activationFunction) {
        double z = 0.0;

        for (int i = 0; i < neuronsCount; i++) {
            z += previousLayer.getNeurons()[i].getValue() * weights[i];
        }
        z += bias;

        value = activationFunction.activate(z);
    }

    public void setError(double error) {
        this.error = error;
    }

    public void calculateGradients(LayerBase previousLayer) {
        for (int i = 0; i < neuronsCount; i++) {
            weightsGradient[i] = error * previousLayer.getNeurons()[i].getValue();
        }
        biasGradient = error;
    }

    public Double[] getWeights() {
        return weights;
    }

    public void updateWeights(double learningRate) {
        for (int i = 0; i < neuronsCount; i++) {
            weights[i] -= learningRate * weightsGradient[i];
        }
    }
}
