package ordenacao;

import utils.ConsoleUtils;

public class SelecaoDireta {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    // Construtor para definir se o array será mostrado ou não
    public SelecaoDireta(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    public int[] ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;

        int i = 0;
        while (i < array.length - 1) {
            int minIndex = i;
            int j = i + 1;
            while (j < array.length) {
                comparacoes++;

                // Atualiza o estado (mostrar ou não o array)
                ConsoleUtils.mostrarEstado("Seleção Direta", array, trocas, comparacoes, j, minIndex, mostrarArray, tempoSimulacao);

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                j++;
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                trocas++;
            }
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
