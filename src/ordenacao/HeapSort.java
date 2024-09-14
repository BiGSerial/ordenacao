package ordenacao;

import utils.ConsoleUtils;

public class HeapSort {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    // Construtor para definir se o array será mostrado ou não
    public HeapSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    public int[] ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;

        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int j = n - 1; j > 0; j--) {
            // Atualiza o estado (mostrar ou não o array)
            ConsoleUtils.mostrarEstado("Heap Sort", array, trocas, comparacoes, j, 0, mostrarArray, tempoSimulacao);

            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            trocas++;

            heapify(array, j, 0);
        }

        return array;
    }

    private void heapify(int[] array, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n) {
            comparacoes++;
            if (array[esquerda] > array[maior]) {
                maior = esquerda;
            }
        }

        if (direita < n) {
            comparacoes++;
            if (array[direita] > array[maior]) {
                maior = direita;
            }
        }

        if (maior != i) {
            int temp = array[i];
            array[i] = array[maior];
            array[maior] = temp;
            trocas++;

            heapify(array, n, maior);
        }
    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
