package com.experttrout9232.neuralnetwork;

import com.experttrout9232.machinelearningutils.ActivationFunctions;

public class Main {
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        neuron.activate(() -> ActivationFunctions.sigmoid(9.5));
    }
}
