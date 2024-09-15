package ordenacao;

public interface Sorter {
    void ordenar(int[] array);

    int getTrocas();

    int getComparacoes();
}
