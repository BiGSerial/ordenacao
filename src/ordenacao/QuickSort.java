package ordenacao;

import utils.ConsoleUtils;

public class QuickSort {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    // Construtor para definir se o array será mostrado ou não
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

    private void quickSort(int[] array, int low, int high) {
        // Contando uma comparação para a verificação do limite low < high
        comparacoes++;
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        int j = low;

        while (j < high) {
            comparacoes++; // Contando a comparação feita no while (j < high)

            // Atualiza o estado (mostrar ou não o array)
            ConsoleUtils.mostrarEstado("Quick Sort", array, trocas, comparacoes, j, i, mostrarArray, tempoSimulacao);

            comparacoes++; // Contando a comparação array[j] < pivot
            if (array[j] < pivot) {
                i++;
                if (i != j) { // Só conta como troca se i e j forem diferentes
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    trocas++; // Contando a troca real
                }
            }
            j++;
        }

        // Troca o pivô para a posição correta
        if (i + 1 != high) { // Só conta a troca se i + 1 e high forem diferentes
            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;
            trocas++; // Contando a troca do pivô
        }
        return i + 1;
    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
