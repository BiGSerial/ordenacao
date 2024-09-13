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

        // Construir o heap (reorganizar o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extrair elementos do heap
        for (int j = n - 1; j > 0; j--) {
            // Atualiza o estado (mostrar ou não o array)
            ConsoleUtils.mostrarEstado("Heap Sort", array, trocas, comparacoes, 0, j, mostrarArray, tempoSimulacao);

            // Troca o primeiro (maior) elemento pelo último elemento não ordenado
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            trocas++; // Contando a troca

            // Chama heapify na árvore reduzida
            heapify(array, j, 0);
        }

        return array;
    }

    private void heapify(int[] array, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // Contando comparações para o filho esquerdo
        comparacoes++; // Contando a comparação entre i e esquerda
        if (esquerda < n) {
            comparacoes++; // Contando a comparação array[esquerda] > array[maior]
            if (array[esquerda] > array[maior]) {
                maior = esquerda;
            }
        }

        // Contando comparações para o filho direito
        comparacoes++; // Contando a comparação entre i e direita
        if (direita < n) {
            comparacoes++; // Contando a comparação array[direita] > array[maior]
            if (array[direita] > array[maior]) {
                maior = direita;
            }
        }

        // Se o maior não for o nó raiz, troca e continua o heapify
        if (maior != i) {
            int temp = array[i];
            array[i] = array[maior];
            array[maior] = temp;
            trocas++; // Contando a troca

            // Recursivamente heapifica a subárvore afetada
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
