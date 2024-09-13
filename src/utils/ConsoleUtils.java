package utils;

public class ConsoleUtils {

    // Limpa o console (Simulação)
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Exibe o nome do método, contadores e opcionalmente o array sendo ordenado
    public static void mostrarEstado(String nomeMetodo, int[] array, int trocas, int comparacoes, int posicaoLida,
            int posicaoEscrita, boolean mostrarArray, int tempo) {
        clearConsole();
        System.out.println("Método: " + nomeMetodo);
        System.out.println("Trocas: " + trocas + " | Comparações: " + comparacoes);

        // Se mostrarArray for true, exibe o array
        if (mostrarArray) {
            System.out.print("Array: ");
            for (int i = 0; i < array.length; i++) {
                if (i == posicaoLida) {
                    // Exibe o número sendo lido em verde
                    System.out.print("\033[32m" + array[i] + "\033[0m ");
                } else if (i == posicaoEscrita) {
                    // Exibe o número sendo escrito em vermelho
                    System.out.print("\033[31m" + array[i] + "\033[0m ");
                } else {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
        }

        try {
            Thread.sleep(tempo); // Pausa para simular "tempo real"
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pauseConsole() {
        System.out.println("\nPressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
