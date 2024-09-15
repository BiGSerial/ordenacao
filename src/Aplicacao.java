import ordenacao.*;
import utils.ConsoleUtils;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Aplicacao {

    private static int tempoSimulacao = 1; // Tempo padrão (em ms)
    private static boolean exibirArray = true, sel = true; // Exibir array (padrão: não)
    private static int quantidadeRegistros = 0; // Quantidade de registros
    private static Scanner scanner = new Scanner(System.in); // Scanner global
    private static String arquivoRelatorioAtual = null; // Caminho do arquivo de relatório atual
    private static boolean cabecalhoEscrito = false; // Controla se o cabeçalho já foi escrito

    public static void main(String[] args) {
        while (sel == true) {
            sel = exibirMenuPrincipal();
        }

    }

    private static boolean exibirMenuPrincipal() {
        ConsoleUtils.clearConsole();
        System.out.println("ORDENATOR v1.0.2 - Will Oliveira - FAESA \n Prof. Renata Laranja \n\n");
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
                System.out.println("Obrigado por Usar...");
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
        System.out.println("ORDENATOR v1.0.2 - Will Oliveira - FAESA \n Prof. Renata Laranja \n\n");
        System.out.println("=== MENU ORDENAÇÃO ===");
        System.out.println("Métodos de Ordenação - " + quantidadeRegistros + " Registros\n");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Inserção Direta");
        System.out.println("3 - Seleção Direta");
        System.out.println("4 - Heap Sort");
        System.out.println("5 - Quick Sort");
        System.out.println("6 - Merge Sort");
        System.out.println("7 - Shell Sort");
        System.out.println("8 - ShakeSort");
        System.out.println("9 - Todos");
        System.out.println("0 - Voltar");

        System.out.print("\nEscolha o método de ordenação: ");
        int metodo = scanner.nextInt();

        if (metodo == 0) {
            return false; // Volta para o menu principal
        }

        // Agora, solicitar os tipos de dados
        List<Integer> dataTypes = exibirMenuTipoDados();
        if (dataTypes.isEmpty()) {
            System.out.println("Nenhum tipo de dado selecionado!");
            ConsoleUtils.pauseConsole();
            return true;
        }

        executarOrdenacao(metodo, dataTypes); // Executa a ordenação
        return true; // Continua no menu de ordenação
    }

    private static List<Integer> exibirMenuTipoDados() {
        ConsoleUtils.clearConsole();
        System.out.println("ORDENATOR v1.0.2 - Will Oliveira - FAESA \n Prof. Renata Laranja \n\n");
        System.out.println("=== TIPO DE DADOS ===");
        System.out.println("Selecione os tipos de dados para ordenar:\n");
        System.out.println("1 - Aleatórios");
        System.out.println("2 - Crescente");
        System.out.println("3 - Decrescente");
        System.out.println("4 - Todos");
        System.out.println("0 - Concluir seleção");

        Set<Integer> dataTypes = new HashSet<>();
        while (true) {
            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            if (opcao == 0) {
                break;
            } else if (opcao >= 1 && opcao <= 3) {
                if (!dataTypes.contains(opcao)) {
                    dataTypes.add(opcao);
                } else {
                    System.out.println("Tipo já selecionado.");
                }
            } else if (opcao == 4) {
                dataTypes.add(1);
                dataTypes.add(2);
                dataTypes.add(3);
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        return new ArrayList<>(dataTypes);
    }

    private static void executarOrdenacao(int metodo, List<Integer> dataTypes) {
        ConsoleUtils.clearConsole();
        System.out.println("Executando ordenação...\n");

        // Carregando os arquivos selecionados
        Map<Integer, int[]> dataArrays = new HashMap<>();
        if (dataTypes.contains(1)) {
            dataArrays.put(1, carregarArquivo("aleatorios.txt"));
        }
        if (dataTypes.contains(2)) {
            dataArrays.put(2, carregarArquivo("crescente.txt"));
        }
        if (dataTypes.contains(3)) {
            dataArrays.put(3, carregarArquivo("decrescente.txt"));
        }

        if (dataArrays.isEmpty()) {
            System.out.println("Nenhum tipo de dado selecionado!");
            ConsoleUtils.pauseConsole();
            return;
        }

        if (metodo == 9) {
            // Loop sobre todos os métodos
            for (int method = 1; method <= 8; method++) {
                String nomeMetodo = getNomeMetodo(method);
                Map<Integer, String> resultados = new HashMap<>();

                for (Integer dataType : dataTypes) {
                    int[] array = dataArrays.get(dataType);
                    if (array != null) {
                        Sorter sorter = getSorter(method); // Cria nova instância do sorter
                        sorter.ordenar(array.clone());
                        resultados.put(dataType, sorter.getTrocas() + "/" + sorter.getComparacoes());
                    }
                }

                // Gerar relatório para este método
                gerarRelatorio(nomeMetodo, resultados);
            }
        } else {
            String nomeMetodo = getNomeMetodo(metodo);
            Map<Integer, String> resultados = new HashMap<>();

            for (Integer dataType : dataTypes) {
                int[] array = dataArrays.get(dataType);
                if (array != null) {
                    Sorter sorter = getSorter(metodo); // Cria nova instância do sorter
                    sorter.ordenar(array.clone());
                    resultados.put(dataType, sorter.getTrocas() + "/" + sorter.getComparacoes());
                }
            }

            gerarRelatorio(nomeMetodo, resultados);
        }

        ConsoleUtils.pauseConsole();
    }

    private static Sorter getSorter(int metodo) {
        switch (metodo) {
            case 1:
                return new BubbleSort(exibirArray, tempoSimulacao);
            case 2:
                return new InsercaoDireta(exibirArray, tempoSimulacao);
            case 3:
                return new SelecaoDireta(exibirArray, tempoSimulacao);
            case 4:
                return new HeapSort(exibirArray, tempoSimulacao);
            case 5:
                return new QuickSort(exibirArray, tempoSimulacao);
            case 6:
                return new MergeSort(exibirArray, tempoSimulacao);
            case 7:
                return new ShellSort(exibirArray, tempoSimulacao);
            case 8:
                return new ShakeSort(exibirArray, tempoSimulacao);
            default:
                return null;
        }
    }

    private static String getNomeMetodo(int metodo) {
        switch (metodo) {
            case 1:
                return "BubbleSort";
            case 2:
                return "InsercaoDireta";
            case 3:
                return "SelecaoDireta";
            case 4:
                return "HeapSort";
            case 5:
                return "QuickSort";
            case 6:
                return "MergeSort";
            case 7:
                return "ShellSort";
            case 8:
                return "ShakeSort";
            default:
                return "Desconhecido";
        }
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

    private static void gerarRelatorio(String nomeMetodo, Map<Integer, String> resultados) {
        // Verifica se o arquivo de relatório atual foi definido
        if (arquivoRelatorioAtual == null) {
            System.out.println("Nenhum arquivo de relatório foi criado ainda.");
            return;
        }

        File file = new File(arquivoRelatorioAtual);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            if (file.length() == 0) {
                // Escrever o cabeçalho
                writer.write("método;aleatório;crescente;decrescente\n");
            }

            // Escreve o conteúdo
            writer.write(nomeMetodo + ";");

            String resAleatorio = resultados.getOrDefault(1, "-");
            String resCrescente = resultados.getOrDefault(2, "-");
            String resDecrescente = resultados.getOrDefault(3, "-");

            writer.write(resAleatorio + ";" + resCrescente + ";" + resDecrescente + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao gerar o relatório.");
            e.printStackTrace();
        }
    }

}
