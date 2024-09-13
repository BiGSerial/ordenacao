import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class GeradorArquivos {

    private int[] numerosAleatorios;

    // Gera os números aleatórios e salva os três arquivos
    public void gerarArquivos(int quantidade) {
        gerarNumerosAleatorios(quantidade);
        salvarArquivo("aleatorios.txt", numerosAleatorios);
        salvarArquivo("crescente.txt", ordenarCrescente(numerosAleatorios.clone()));
        salvarArquivo("decrescente.txt", ordenarDecrescente(numerosAleatorios.clone()));
    }

    // Gera números aleatórios
    private void gerarNumerosAleatorios(int quantidade) {
        Random random = new Random();
        numerosAleatorios = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            numerosAleatorios[i] = random.nextInt(quantidade); // Números aleatórios entre 0 e 999
        }
    }

    // Ordena em ordem crescente
    private int[] ordenarCrescente(int[] array) {
        Arrays.sort(array);
        return array;
    }

    // Ordena em ordem decrescente
    private int[] ordenarDecrescente(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    // Salva o arquivo com os números
    private void salvarArquivo(String nomeArquivo, int[] array) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (int numero : array) {
                writer.write(numero + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GeradorArquivos gerador = new GeradorArquivos();
        gerador.gerarArquivos(100); // Gera arquivos com 100 números
    }
}
