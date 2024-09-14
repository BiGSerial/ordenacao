package ordenacao;

import utils.ConsoleUtils;

public class QuickSort {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    public QuickSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    public int[] ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int esq, int dir) {

        int pivo, i = esq, j = dir;
        int temp;

        pivo = array[(i + j) / 2];

        do {

            // Atualiza o estado (mostrar ou não o array)
            ConsoleUtils.mostrarEstado("Quick Sort", array, trocas, comparacoes, j, i, mostrarArray, tempoSimulacao);

            comparacoes++;
            while (array[i] < pivo) {
                i++;
                comparacoes++;
            }

            comparacoes++;
            while (array[j] > pivo) {
                j--;
                comparacoes++;
            }

            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
                trocas++;
            }

        } while (i <= j);

        if (esq < j) {
            quickSort(array, esq, j);
        }

        if (dir > i) {
            quickSort(array, i, dir);
        }

    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
