package ordenacao;

import utils.ConsoleUtils;

public class ShakeSort implements Sorter {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    public ShakeSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    @Override
    public void ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;
        shakeSort(array);

    }

    private void shakeSort(int[] array) {
        int esq = 0;
        int dir = array.length - 1;
        int j = dir;
        int read, temp;
        int i;

        do {

            for (i = dir; i > esq; i--) {
                comparacoes++;

                // Para evitar que a Leitura fique fora dos Indices, nao faz parte da ordenação!
                if (i > 0) {
                    read = i - 1;
                } else {
                    read = i;
                }

                // Animação da leitura do array (atualiza o estado para visualização)
                ConsoleUtils.mostrarEstado("Shake Sort <<", array, trocas, comparacoes, read, i, mostrarArray,
                        tempoSimulacao);

                if (array[i - 1] > array[i]) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;

                    trocas++;
                    j = i;
                }
            }
            esq = j;

            for (i = esq; i < dir; i++) {
                comparacoes++;

                // Para evitar que a Leitura fique fora dos Indices, nao faz parte da ordenação!
                if (i < dir) {
                    read = i + 1;
                } else {
                    read = i;
                }

                // Animação da leitura do array (atualiza o estado para visualização)
                ConsoleUtils.mostrarEstado("Shake Sort >>", array, trocas, comparacoes, read, i, mostrarArray,
                        tempoSimulacao);

                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    trocas++;
                    j = i + 1;
                }
            }
            dir = j - 1;
        } while (esq <= dir);
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
