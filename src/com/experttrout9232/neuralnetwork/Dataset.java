package com.experttrout9232.neuralnetwork;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Dataset {
    private Double[][] data;
    private Double[][] desiredOutput;

    public Dataset(long seed) {
        data = new Double[65536][16];
        desiredOutput = new Double[65536][1]; // Pro každé číslo jedna hodnota

        for (int i = 0; i < 65536; i++) {
            int onesCount = 0; // Počítadlo jedniček

            for (int j = 15; j >= 0; j--) {
                data[i][j] = (double) ((i >> (15 - j)) & 1);
                onesCount += data[i][j]; // Přičítáme počet jedniček
            }

            desiredOutput[i][0] = onesCount / 16.0; // Podíl jedniček
        }

        // Vytvořím seznam indexů
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < 65536; i++) {
            indices.add(i);
        }

        // Použiju seed pro generátor náhodných čísel, aby shuffle bylo deterministické
        Random rand = new Random(seed);
        Collections.shuffle(indices, rand); // Zamíchám indexy

        // Vytvoření nových zamíchaných polí pro data a desiredOutput
        Double[][] shuffledData = new Double[65536][16];
        Double[][] shuffledDesiredOutput = new Double[65536][1];

        for (int i = 0; i < 65536; i++) {
            int idx = indices.get(i); // Index zamíchaného pořadí
            shuffledData[i] = data[idx]; // Přesunu data podle zamíchaných indexů
            shuffledDesiredOutput[i] = desiredOutput[idx]; // Stejně pro desiredOutput
        }

        // Nastavení zamíchaných hodnot
        data = shuffledData;
        desiredOutput = shuffledDesiredOutput;
    }

    // Getter pro data a desiredOutput (pokud chceš načítat hodnoty)
    public Double[][] getData() {
        return data;
    }

    public Double[][] getDesiredOutput() {
        return desiredOutput;
    }
}