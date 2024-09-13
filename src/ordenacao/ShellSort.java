package ordenacao;

import utils.ConsoleUtils;

public class ShellSort {

    private int trocas = 0;
    private int comparacoes = 0;
    private boolean mostrarArray;
    private int tempoSimulacao;

    // Construtor para definir se o array será mostrado ou não
    public ShellSort(boolean mostrarArray, int tempoSimulacao) {
        this.mostrarArray = mostrarArray;
        this.tempoSimulacao = tempoSimulacao;
    }

    public int[] ordenar(int[] array) {
        trocas = 0;
        comparacoes = 0;

        int n = array.length;
        int gap = n / 2;

        while (gap > 0) {
            int i = gap;
            while (i < n) {
                int temp = array[i];
                int j = i;

                // Atualiza o estado (mostrar ou não o array)
                ConsoleUtils.mostrarEstado("Shell Sort", array, trocas, comparacoes, j, j - gap, mostrarArray,
                        tempoSimulacao);

               
                while (j >= gap) {
                    comparacoes++; 
                    if (array[j - gap] > temp) {
                       
                        array[j] = array[j - gap];
                        j -= gap;
                        trocas++; 

                    } else {
                        break; 
                    }
                }

               
                array[j] = temp;
                trocas++;

                i++;
            }
            
            gap /= 2;
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
