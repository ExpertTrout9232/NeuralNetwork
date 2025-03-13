package com.experttrout9232.neuralnetwork;

import com.experttrout9232.machinelearningutils.ActivationFunctions;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    private InputLayer inputLayer;
    private OutputLayer outputLayer;
    private Layer[] hiddenLayers;
    private List<Layer> layersProcessing = new ArrayList<Layer>();
    private List<LayerBase> layersAll = new ArrayList<LayerBase>();

    public NeuralNetwork(NeuralNetworkConfig config) {
        inputLayer = new InputLayer(config.inputLayerSize());
        outputLayer = new OutputLayer(config.outputLayerSize(), config.hiddenLayerSize());
        hiddenLayers = new Layer[config.hiddenLayerSize()];

        layersAll.add(inputLayer);

        hiddenLayers[0] = new Layer(config.hiddenLayerSize(), config.inputLayerSize());
        for (int i = 1; i < config.hiddenLayersCount(); i++) {
            hiddenLayers[i] = new Layer(config.hiddenLayerSize(), config.hiddenLayerSize());
            layersProcessing.add(hiddenLayers[i]);
            layersAll.add(hiddenLayers[i]);
        }

        layersProcessing.add(outputLayer);
        layersAll.add(outputLayer);
    }

    public void feedforward(Double[] input) {
        inputLayer.setNeurons(input);
        for (int i = 0; i < layersProcessing.size(); i++) {
            layersProcessing.get(i).activate(layersAll.get(i), ActivationFunctions::sigmoid);
        }
    }

    private void backpropagation(int batchSize, Double[] desiredOutput, double learningRate) {
        System.out.println(outputLayer.calculateCost(batchSize));
        for (int i = layersProcessing.size() - 1; i >= 0; i--) {
            Double[] error = new Double[layersProcessing.get(i).getNeurons().length];
            if (layersProcessing.get(i) instanceof OutputLayer) {
                for (int j = 0; j < layersProcessing.get(i).getNeurons().length; j++) {
                    error[j] = (layersProcessing.get(i).getNeurons()[j].getValue() - desiredOutput[j]) * ActivationFunctions.sigmoidDerivative(layersProcessing.get(i).getNeurons()[j].getValue());
                }
            } else {
                for (int j = 0; j < layersProcessing.get(i).getNeurons().length; j++) {
                    for (int k = 0; k < layersProcessing.get(i + 1).getNeurons().length; k++) {
                        error[j] += layersProcessing.get(i + 1).getWeightsFromNeuron(k)[j] * layersProcessing.get(i + 1).getNeurons()[k].getValue();
                    }
                    error[j] *= ActivationFunctions.sigmoidDerivative(layersProcessing.get(i).getNeurons()[j].getValue());
                }
            }

            layersProcessing.get(i).setError(error);

            layersProcessing.get(i).calculateWeightsGradient(layersAll.get(i));

        }

        for (Layer layer : layersProcessing) {
            layer.updateWeights(learningRate);
        }
    }

    public void train(int epochs, int batchSize, double learningRate) {
        for (int i = 0; i < epochs; i++) {
            System.out.println("Epoch " + i);
            Dataset dataset = new Dataset((long) (Math.random() * Long.MAX_VALUE));

            for (int j = 0; j < dataset.getData().length; j++) {
                feedforward(dataset.getData()[j]);
                if (j % batchSize == 0) {
                    backpropagation(batchSize, dataset.getDesiredOutput()[j], learningRate);
                }
            }
        }
    }
}
