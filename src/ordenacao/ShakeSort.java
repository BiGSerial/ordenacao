package ordenacao;

import utils.ConsoleUtils;

public class ShakeSort {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    public ShakeSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    public int[] ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;
        shakeSort(array);
        return array;
    }

    private void shakeSort(int[] array) {
        boolean trocou = true;
        int inicio = 0;
        int fim = array.length - 1;

        while (trocou) {
            trocou = false;
            
            for (int i = inicio; i < fim; i++) {
                comparacoes++;
                ConsoleUtils.mostrarEstado("Shake Sort", array, trocas, comparacoes, i, -1, mostrarArray, tempoSimulacao);
                
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    
                    trocas++;
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }

            fim--;
            trocou = false;

            for (int i = fim; i > inicio; i--) {
                comparacoes++;
                ConsoleUtils.mostrarEstado("Shake Sort", array, trocas, comparacoes, i, -1, mostrarArray, tempoSimulacao);
                
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    
                    trocas++;
                    trocou = true;
                }
            }

            inicio++;
        }
    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
