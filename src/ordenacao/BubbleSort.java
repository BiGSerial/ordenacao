package ordenacao;

import utils.ConsoleUtils;

public class BubbleSort {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    public BubbleSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    public int[] ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;

        int n = array.length - 1;
        int i, j, temp;

        do {
            i = 0;

            for (j = 0; j < n; j++) {
                comparacoes++;

                ConsoleUtils.mostrarEstado("Bubble Sort", array, trocas, comparacoes, j + 1, j, mostrarArray,
                        tempoSimulacao);

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    trocas++;
                    i = j;
                }
            }

            n = i;

        } while (n >= 1);

        return array;
    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
