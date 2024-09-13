import ordenacao.*;
import utils.ConsoleUtils;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Aplicacao {

    private static int tempoSimulacao = 10; // Tempo padrão (em ms)
    private static boolean exibirArray = true; // Exibir array (padrão: não)
    private static int quantidadeRegistros = 0; // Quantidade de registros
    private static Scanner scanner = new Scanner(System.in); // Scanner global
    private static String arquivoRelatorioAtual = null; // Caminho do arquivo de relatório atual
    private static boolean cabecalhoEscrito = false; // Controla se o cabeçalho já foi escrito

    public static void main(String[] args) {
        while (true) {
            exibirMenuPrincipal();
        }
    }

    private static boolean exibirMenuPrincipal() {
        ConsoleUtils.clearConsole();
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1 - Nova Ordenação");
        System.out.println("2 - Exibir Resultados");
        System.out.println("3 - Configurações");
        System.out.println("0 - Sair");

        System.out.print("\nEscolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                novaOrdenacao();
                return true; // Continua no loop do menu principal após a ordenação.
            case 2:
                exibirResultados();
                return true;
            case 3:
                configuracoes();
                return true;
            case 0:
                return false; // Sai do loop e encerra o programa.
            default:
                System.out.println("Opção inválida! Tente novamente.");
                return true;
        }
    }

    private static void novaOrdenacao() {
        ConsoleUtils.clearConsole();
        System.out.println("Nova Ordenação\n");

        System.out.print("Digite a quantidade de registros: ");
        quantidadeRegistros = scanner.nextInt();

        // Gera os arquivos de valores
        GeradorArquivos gerador = new GeradorArquivos();
        gerador.gerarArquivos(quantidadeRegistros);

        // Gerar o nome do novo arquivo de relatório com base no número de registros e
        // timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        arquivoRelatorioAtual = "relatorios/relatorio_" + quantidadeRegistros + "_" + timestamp + ".csv";

        // Certificar-se de que a pasta "relatorios" exista
        File diretorio = new File("relatorios");
        if (!diretorio.exists()) {
            diretorio.mkdirs(); // Cria a pasta se não existir
        }

        boolean continuar = true;
        while (continuar) {
            continuar = exibirMenuOrdenacao(); // Exibe o menu de ordenação até que o usuário decida voltar
        }
    }

    private static boolean exibirMenuOrdenacao() {
        ConsoleUtils.clearConsole();
        System.out.println("Métodos de Ordenação - " + quantidadeRegistros + " Registros\n");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Inserção Direta");
        System.out.println("3 - Seleção Direta");
        System.out.println("4 - Heap Sort");
        System.out.println("5 - Quick Sort");
        System.out.println("6 - Merge Sort");
        System.out.println("7 - Shell Sort");
        System.out.println("9 - Todos");
        System.out.println("0 - Voltar");

        System.out.print("\nEscolha o método de ordenação: ");
        int metodo = scanner.nextInt();

        if (metodo == 0) {
            return false; // Volta para o menu principal
        }

        executarOrdenacao(metodo); // Executa a ordenação
        return true; // Continua no menu de ordenação
    }

    private static void executarOrdenacao(int metodo) {
        ConsoleUtils.clearConsole();
        System.out.println("Executando ordenação...\n");

        // Carregando os arquivos
        int[] arrayAleatorio = carregarArquivo("aleatorios.txt");
        int[] arrayCrescente = carregarArquivo("crescente.txt");
        int[] arrayDecrescente = carregarArquivo("decrescente.txt");

        String nomeMetodo = "";
        String resultadosAleatorio = "";
        String resultadosCrescente = "";
        String resultadosDecrescente = "";

        switch (metodo) {
            case 1:
                nomeMetodo = "BubbleSort";
                BubbleSort bubbleSort = new BubbleSort(exibirArray, tempoSimulacao);

                bubbleSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = bubbleSort.getTrocas() + "/" + bubbleSort.getComparacoes();

                bubbleSort.ordenar(arrayCrescente);
                resultadosCrescente = bubbleSort.getTrocas() + "/" + bubbleSort.getComparacoes();

                bubbleSort.ordenar(arrayDecrescente);
                resultadosDecrescente = bubbleSort.getTrocas() + "/" + bubbleSort.getComparacoes();
                break;

            case 2:
                nomeMetodo = "InsercaoDireta";
                InsercaoDireta insercaoDireta = new InsercaoDireta(exibirArray, tempoSimulacao);

                insercaoDireta.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = insercaoDireta.getTrocas() + "/" + insercaoDireta.getComparacoes();

                insercaoDireta.ordenar(arrayCrescente);
                resultadosCrescente = insercaoDireta.getTrocas() + "/" + insercaoDireta.getComparacoes();

                insercaoDireta.ordenar(arrayDecrescente);
                resultadosDecrescente = insercaoDireta.getTrocas() + "/" + insercaoDireta.getComparacoes();
                break;

            case 3:
                nomeMetodo = "SelecaoDireta";
                SelecaoDireta selecaoDireta = new SelecaoDireta(exibirArray, tempoSimulacao);

                selecaoDireta.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = selecaoDireta.getTrocas() + "/" + selecaoDireta.getComparacoes();

                selecaoDireta.ordenar(arrayCrescente);
                resultadosCrescente = selecaoDireta.getTrocas() + "/" + selecaoDireta.getComparacoes();

                selecaoDireta.ordenar(arrayDecrescente);
                resultadosDecrescente = selecaoDireta.getTrocas() + "/" + selecaoDireta.getComparacoes();
                break;

            case 4:
                nomeMetodo = "HeapSort";
                HeapSort heapSort = new HeapSort(exibirArray, tempoSimulacao);

                heapSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = heapSort.getTrocas() + "/" + heapSort.getComparacoes();

                heapSort.ordenar(arrayCrescente);
                resultadosCrescente = heapSort.getTrocas() + "/" + heapSort.getComparacoes();

                heapSort.ordenar(arrayDecrescente);
                resultadosDecrescente = heapSort.getTrocas() + "/" + heapSort.getComparacoes();
                break;

            case 5:
                nomeMetodo = "QuickSort";
                QuickSort quickSort = new QuickSort(exibirArray, tempoSimulacao);

                quickSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = quickSort.getTrocas() + "/" + quickSort.getComparacoes();

                quickSort.ordenar(arrayCrescente);
                resultadosCrescente = quickSort.getTrocas() + "/" + quickSort.getComparacoes();

                quickSort.ordenar(arrayDecrescente);
                resultadosDecrescente = quickSort.getTrocas() + "/" + quickSort.getComparacoes();
                break;

            case 6:
                nomeMetodo = "MergeSort";
                MergeSort mergeSort = new MergeSort(exibirArray, tempoSimulacao);

                mergeSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = mergeSort.getTrocas() + "/" + mergeSort.getComparacoes();

                mergeSort.ordenar(arrayCrescente);
                resultadosCrescente = mergeSort.getTrocas() + "/" + mergeSort.getComparacoes();

                mergeSort.ordenar(arrayDecrescente);
                resultadosDecrescente = mergeSort.getTrocas() + "/" + mergeSort.getComparacoes();
                break;

            case 7:
                nomeMetodo = "ShellSort";
                ShellSort shellSort = new ShellSort(exibirArray, tempoSimulacao);

                shellSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = shellSort.getTrocas() + "/" + shellSort.getComparacoes();

                shellSort.ordenar(arrayCrescente);
                resultadosCrescente = shellSort.getTrocas() + "/" + shellSort.getComparacoes();

                shellSort.ordenar(arrayDecrescente);
                resultadosDecrescente = shellSort.getTrocas() + "/" + shellSort.getComparacoes();
                break;
            case 9:

                nomeMetodo = "BubbleSort";
                bubbleSort = new BubbleSort(exibirArray, tempoSimulacao);

                bubbleSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = bubbleSort.getTrocas() + "/" + bubbleSort.getComparacoes();

                bubbleSort.ordenar(arrayCrescente);
                resultadosCrescente = bubbleSort.getTrocas() + "/" + bubbleSort.getComparacoes();

                bubbleSort.ordenar(arrayDecrescente);
                resultadosDecrescente = bubbleSort.getTrocas() + "/" + bubbleSort.getComparacoes();

                gerarRelatorio(nomeMetodo, resultadosAleatorio, resultadosCrescente, resultadosDecrescente);

                nomeMetodo = "InsercaoDireta";
                insercaoDireta = new InsercaoDireta(exibirArray, tempoSimulacao);

                insercaoDireta.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = insercaoDireta.getTrocas() + "/" + insercaoDireta.getComparacoes();

                insercaoDireta.ordenar(arrayCrescente);
                resultadosCrescente = insercaoDireta.getTrocas() + "/" + insercaoDireta.getComparacoes();

                insercaoDireta.ordenar(arrayDecrescente);
                resultadosDecrescente = insercaoDireta.getTrocas() + "/" + insercaoDireta.getComparacoes();

                gerarRelatorio(nomeMetodo, resultadosAleatorio, resultadosCrescente, resultadosDecrescente);

                nomeMetodo = "SelecaoDireta";
                selecaoDireta = new SelecaoDireta(exibirArray, tempoSimulacao);

                selecaoDireta.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = selecaoDireta.getTrocas() + "/" + selecaoDireta.getComparacoes();

                selecaoDireta.ordenar(arrayCrescente);
                resultadosCrescente = selecaoDireta.getTrocas() + "/" + selecaoDireta.getComparacoes();

                selecaoDireta.ordenar(arrayDecrescente);
                resultadosDecrescente = selecaoDireta.getTrocas() + "/" + selecaoDireta.getComparacoes();

                gerarRelatorio(nomeMetodo, resultadosAleatorio, resultadosCrescente, resultadosDecrescente);

                nomeMetodo = "HeapSort";
                heapSort = new HeapSort(exibirArray, tempoSimulacao);

                heapSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = heapSort.getTrocas() + "/" + heapSort.getComparacoes();

                heapSort.ordenar(arrayCrescente);
                resultadosCrescente = heapSort.getTrocas() + "/" + heapSort.getComparacoes();

                heapSort.ordenar(arrayDecrescente);
                resultadosDecrescente = heapSort.getTrocas() + "/" + heapSort.getComparacoes();

                gerarRelatorio(nomeMetodo, resultadosAleatorio, resultadosCrescente, resultadosDecrescente);

                nomeMetodo = "QuickSort";
                quickSort = new QuickSort(exibirArray, tempoSimulacao);

                quickSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = quickSort.getTrocas() + "/" + quickSort.getComparacoes();

                quickSort.ordenar(arrayCrescente);
                resultadosCrescente = quickSort.getTrocas() + "/" + quickSort.getComparacoes();

                quickSort.ordenar(arrayDecrescente);
                resultadosDecrescente = quickSort.getTrocas() + "/" + quickSort.getComparacoes();

                gerarRelatorio(nomeMetodo, resultadosAleatorio, resultadosCrescente, resultadosDecrescente);

                nomeMetodo = "MergeSort";
                mergeSort = new MergeSort(exibirArray, tempoSimulacao);

                mergeSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = mergeSort.getTrocas() + "/" + mergeSort.getComparacoes();

                mergeSort.ordenar(arrayCrescente);
                resultadosCrescente = mergeSort.getTrocas() + "/" + mergeSort.getComparacoes();

                mergeSort.ordenar(arrayDecrescente);
                resultadosDecrescente = mergeSort.getTrocas() + "/" + mergeSort.getComparacoes();

                gerarRelatorio(nomeMetodo, resultadosAleatorio, resultadosCrescente, resultadosDecrescente);

                nomeMetodo = "ShellSort";
                shellSort = new ShellSort(exibirArray, tempoSimulacao);

                shellSort.ordenar(arrayAleatorio.clone());
                resultadosAleatorio = shellSort.getTrocas() + "/" + shellSort.getComparacoes();

                shellSort.ordenar(arrayCrescente);
                resultadosCrescente = shellSort.getTrocas() + "/" + shellSort.getComparacoes();

                shellSort.ordenar(arrayDecrescente);
                resultadosDecrescente = shellSort.getTrocas() + "/" + shellSort.getComparacoes();
                break;

            default:
                System.out.println("Método de ordenação inválido!");
                return;
        }

        // Gerar o relatório com base no nome do método e resultados
        gerarRelatorio(nomeMetodo, resultadosAleatorio, resultadosCrescente, resultadosDecrescente);

        ConsoleUtils.pauseConsole();
    }

    // Método para carregar o arquivo em um array de inteiros
    private static int[] carregarArquivo(String nomeArquivo) {
        List<Integer> numeros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                numeros.add(Integer.parseInt(linha.trim()));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + nomeArquivo);
            e.printStackTrace();
        }

        // Convertendo a lista para um array de inteiros
        return numeros.stream().mapToInt(i -> i).toArray();
    }

    // Exibe os resultados das últimas ordenações
    private static void exibirResultados() {
        ConsoleUtils.clearConsole();
        System.out.println("Resultados das Últimas Ordenações\n");
        // Aqui você pode exibir os resultados das ordenações anteriores
        ConsoleUtils.pauseConsole();
    }

    private static void configuracoes() {
        while (true) {
            ConsoleUtils.clearConsole();
            System.out.println("Configurações:\n");
            System.out.println("1 - Tempo: " + tempoSimulacao + " ms");
            System.out.println("2 - Exibir Array: " + (exibirArray ? "Sim" : "Não"));
            System.out.println("0 - Voltar");

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo tempo (0 a 300 ms): ");
                    tempoSimulacao = scanner.nextInt();
                    if (tempoSimulacao < 0 || tempoSimulacao > 300) {
                        System.out.println("Tempo inválido! Usando valor padrão de 300 ms.");
                        tempoSimulacao = 300;
                    }
                    break;
                case 2:
                    System.out.print("Exibir Array? (s/n): ");
                    char escolha = scanner.next().charAt(0);
                    exibirArray = (escolha == 's' || escolha == 'S');
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void gerarRelatorio(String nomeMetodo, String resultadosAleatorio, String resultadosCrescente,
            String resultadosDecrescente) {
        // Verifica se o arquivo de relatório atual foi definido
        if (arquivoRelatorioAtual == null) {
            System.out.println("Nenhum arquivo de relatório foi criado ainda.");
            return;
        }

        File file = new File(arquivoRelatorioAtual);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // Adiciona conteúdo ao arquivo
                                                                                       // existente
            if (file.length() == 0) { // Se o arquivo estiver vazio, adiciona o cabeçalho
                writer.write("método;aleatório;crescente;decrescente\n");
            }
            // Escreve o conteúdo com uma nova linha no final
            writer.write(nomeMetodo + ";" + resultadosAleatorio + ";" + resultadosCrescente + ";"
                    + resultadosDecrescente + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao gerar o relatório.");
            e.printStackTrace();
        }
    }

}
