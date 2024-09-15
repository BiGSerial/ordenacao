package ordenacao;

import utils.ConsoleUtils;

public class ShellSort implements Sorter {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    // Construtor para definir se o array será mostrado ou não
    public ShellSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    @Override
    public void ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;

        int h = 1;
        int temp;
        int i, j;

        do {
            h = 3 * h + 1;
        } while (h < array.length);

        do {
            h = h / 3;
            for (i = h; i < array.length; i++) {
                temp = array[i];
                j = i;

                // Atualiza o estado (mostrar ou não o array)
                ConsoleUtils.mostrarEstado("Shell Sort", array, trocas, comparacoes, (j - h), j, mostrarArray,
                        tempoSimulacao);

                comparacoes++;
                while (j >= h && array[j - h] > temp) {
                    comparacoes++;
                    array[j] = array[j - h];
                    trocas++;

                    j -= h;

                    if (j < h) {
                        break;
                    }
                }
                array[j] = temp;
            }

        } while (h != 1);

    }

    @Override
    public int getTrocas() {
        return trocas;
    }

    @Override
    public int getComparacoes() {
        return comparacoes;
    }
}
