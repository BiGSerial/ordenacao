# Ordenação de Algoritmos - Aplicação Java

Este é um projeto Java de estudo e aplicação de diversos algoritmos de ordenação. Ele permite que os usuários escolham entre diferentes métodos de ordenação para ordenar conjuntos de números e, ao final, gera um relatório contendo o desempenho de cada algoritmo em termos de trocas e comparações realizadas.

## Funcionalidades

- **Escolha de algoritmos de ordenação**: O usuário pode escolher entre os algoritmos de ordenação mais conhecidos, como Bubble Sort, Quick Sort, Merge Sort, entre outros.
- **Visualização do processo de ordenação**: O programa permite ao usuário visualizar o estado do array a cada passo de execução, incluindo a quantidade de trocas e comparações feitas.
- **Geração de arquivos de teste**: O programa gera automaticamente arquivos contendo valores a serem ordenados, como valores em ordem aleatória, crescente ou decrescente.
- **Relatório de desempenho**: Ao final da execução de um algoritmo, o programa gera um relatório detalhado em formato CSV contendo o número de trocas e comparações para cada tipo de ordenação (aleatório, crescente, decrescente).
  
## Algoritmos Implementados

O programa oferece suporte a vários algoritmos de ordenação clássicos:

- **Bubble Sort**: Ordenação por bolha, uma técnica simples de ordenação, onde os elementos são repetidamente comparados e trocados de posição até que o array esteja ordenado.
- **Inserção Direta (Insertion Sort)**: Ordena os elementos de forma incremental, posicionando cada novo elemento no lugar correto em uma lista ordenada.
- **Seleção Direta (Selection Sort)**: Seleciona o menor elemento de uma lista não ordenada e o coloca na posição correta, repetindo o processo para os próximos elementos.
- **Heap Sort**: Constrói uma estrutura de heap e ordena os elementos removendo o maior item repetidamente.
- **Quick Sort**: Utiliza a técnica de divisão e conquista, selecionando um pivô e particionando o array em duas partes menores.
- **Merge Sort**: Outro algoritmo de divisão e conquista que divide o array em duas metades, ordena as metades e depois as junta.
- **Shell Sort**: Uma melhoria sobre o Insertion Sort, utilizando uma sequência de gaps para realizar comparações e trocas.
