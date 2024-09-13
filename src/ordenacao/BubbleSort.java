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

        int n = array.length;
        boolean houveTroca;
        int i = 0;

        while (i < n - 1) {
            houveTroca = false;
            int j = 0;
            while (j < n - i - 1) {
               

                if (mostrarArray) {
                    ConsoleUtils.mostrarEstado("Bubble Sort", array, trocas, comparacoes, j, j + 1, mostrarArray,
                            tempoSimulacao);
                }

                comparacoes++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocas++;
                    houveTroca = true;
                }
                j++;
            }
            if (!houveTroca)
                break;
            i++;
        }
        return array;
    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
