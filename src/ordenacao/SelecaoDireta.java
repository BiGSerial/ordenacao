package ordenacao;

import utils.ConsoleUtils;

public class SelecaoDireta implements Sorter {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao, temp;

    // Construtor para definir se o array será mostrado ou não
    public SelecaoDireta(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    @Override
    public void ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                // Atualiza o estado (mostrar ou não o array)
                ConsoleUtils.mostrarEstado("Seleção Direta", array, trocas, comparacoes, j, minIndex, mostrarArray,
                        tempoSimulacao);

                comparacoes++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            trocas++;

        }

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
