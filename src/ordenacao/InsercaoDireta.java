package ordenacao;

import utils.ConsoleUtils;

public class InsercaoDireta implements Sorter {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    // Construtor para definir se o array será mostrado ou não
    public InsercaoDireta(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    @Override
    public void ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;

        int i = 1;
        while (i < array.length) {
            int chave = array[i];
            int j = i - 1;

            // Atualiza o estado (mostrar ou não o array)
            ConsoleUtils.mostrarEstado("Inserção Direta", array, trocas, comparacoes, i, j, mostrarArray,
                    tempoSimulacao);

            comparacoes++;
            while (j >= 0 && array[j] > chave) {
                comparacoes++;
                array[j + 1] = array[j];
                j = j - 1;
                trocas++;
            }
            array[j + 1] = chave;
            i++;
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
