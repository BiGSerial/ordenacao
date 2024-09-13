package ordenacao;

import utils.ConsoleUtils;

public class MergeSort {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    // Construtor para definir se o array será mostrado ou não
    public MergeSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    public int[] ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        int i = 0, j = 0, k = left;

        while (i < n1) {
            comparacoes++;
            L[i] = array[left + i];
            i++;
            trocas++;
        }

        while (j < n2) {
            comparacoes++;
            R[j] = array[middle + 1 + j];
            j++;
            trocas++;
        }

        i = 0;
        j = 0;

        while (i < n1 && j < n2) {
            comparacoes++;

            // Atualiza o estado (mostrar ou não o array)
            ConsoleUtils.mostrarEstado("Merge Sort", array, trocas, comparacoes, k, -1, mostrarArray, tempoSimulacao);

            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
                trocas++;
            } else {
                array[k] = R[j];
                j++;
                trocas++;
            }
            k++;
        }

        while (i < n1) {
            comparacoes++;
            array[k] = L[i];
            i++;
            k++;
            trocas++;
        }

        while (j < n2) {
            comparacoes++;
            array[k] = R[j];
            j++;
            k++;
            trocas++;
        }
    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
