# Ordenação de Algoritmos - Aplicação Java

Este projeto em Java é uma ferramenta simples e interativa para ilustrar o funcionamento de diversos algoritmos de ordenação. Ele é ideal para fins **didáticos**, permitindo que estudantes e interessados visualizem, em tempo real, como os algoritmos processam e ordenam conjuntos de números. A aplicação oferece animações coloridas que representam a leitura e escrita dos elementos no vetor, ajudando a entender o comportamento de cada algoritmo.

## Funcionalidades

- **Escolha de algoritmos de ordenação**: O usuário pode selecionar entre diversos algoritmos clássicos, como Bubble Sort, Quick Sort, Shell Sort, entre outros.
- **Visualização animada**: O estado do array é representado visualmente e de forma animada, com cores destacando a leitura e escrita dos elementos durante o processo de ordenação. Isso facilita a compreensão das operações realizadas por cada algoritmo.
- **Geração automática de arquivos de teste**: A aplicação cria arquivos com conjuntos de números em ordem aleatória, crescente e decrescente para testar os algoritmos de ordenação.
- **Relatório de desempenho**: Após a execução de cada algoritmo, um relatório em formato CSV é gerado, mostrando o número de trocas e comparações realizadas, permitindo que o usuário avalie a eficiência de cada método.

## Algoritmos Implementados

Os seguintes algoritmos de ordenação foram implementados, cada um com sua própria animação e feedback visual:

- **Bubble Sort**: Ordenação por bolha, onde elementos são comparados e trocados de posição até que o array esteja ordenado.
- **Inserção Direta (Insertion Sort)**: Insere cada novo elemento em sua posição correta em uma lista previamente ordenada.
- **Seleção Direta (Selection Sort)**: Seleciona o menor elemento de uma lista desordenada e o coloca na posição correta, repetindo o processo até que o array esteja ordenado.
- **Heap Sort**: Organiza os elementos em uma estrutura de heap e os ordena removendo o maior item sucessivamente.
- **Quick Sort**: Um algoritmo eficiente que divide o array em partes menores, ordenando cada parte independentemente, usando a técnica de divisão e conquista.
- **Shell Sort**: Uma versão aprimorada do Insertion Sort, onde são feitas comparações e trocas com uma sequência de gaps decrescentes.
- **Shake Sort (Cocktail Sort)**: Uma variação do Bubble Sort que percorre o array em ambas as direções, movendo os elementos maiores para o fim e os menores para o início em cada passagem.

## Objetivo e Valor Didático

Este projeto foi desenvolvido com o objetivo de **visualizar e ensinar algoritmos de ordenação** de maneira acessível e interativa. As animações que destacam as operações de leitura e escrita no vetor com cores diferentes tornam o aprendizado mais dinâmico e intuitivo, permitindo uma compreensão profunda do que acontece em cada etapa do processo de ordenação. Isso é particularmente útil em ambientes educacionais, onde conceitos abstratos podem ser difíceis de explicar sem uma demonstração visual.

## Como Utilizar

1. **Escolha o algoritmo**: Selecione o algoritmo de ordenação que deseja executar.
2. **Visualize o processo**: Acompanhe a animação que exibe o comportamento do algoritmo, com comparações e trocas destacadas de forma visual e colorida.
3. **Gere arquivos de teste**: Teste a eficiência dos algoritmos em dados aleatórios, ordenados ou reversamente ordenados.
4. **Avalie o desempenho**: Ao final, um relatório em CSV será gerado com o número de comparações e trocas realizadas.

## Exemplo de Uso

- **Visualização de Bubble Sort**: O algoritmo começa comparando os elementos adjacentes do vetor. A animação mostra as comparações em tempo real, destacando os elementos trocados e os movimentos dentro do array.
- **Shake Sort**: O algoritmo varre o array em duas direções, primeiro da esquerda para a direita e depois da direita para a esquerda, ordenando os elementos à medida que avança.

## Requisitos

- Java 8 ou superior

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias, correções de bugs ou novos recursos.

## Autor

Desenvolvido por **Will Oliveira** - 2024/2

[Repositório de Ordenação no GitHub](https://github.com/BiGSerial/ordenacao)
