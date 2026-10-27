import java.util.Random;

class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Lista {
    No inicio;
    int tamanho;

    public Lista() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adicionar(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No aux = inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = novo;
        }
        tamanho++;
    }

    public void mostrar() {
        No aux = inicio;
        while (aux != null) {
            System.out.print(aux.valor + " -> ");
            aux = aux.proximo;
        }
        System.out.println("null");
    }
}

public class Atividade1 {
    public static void main(String[] args) {
        Lista[] vetor = new Lista[100];
        Random gerador = new Random(1090);

        int[] ultimos = new int[3];
        int contUltimos = 0;

        for (int i = 0; i < 1000; i++) {
            int num = gerador.nextInt(100001);
            int pos = num % 100;

            if (vetor[pos] == null) {
                vetor[pos] = new Lista();
            }

            vetor[pos].adicionar(num);

            if (i >= 997) {
                ultimos[contUltimos] = num;
                contUltimos++;
            }
        }

        int qtdListas = 0;
        int vazias = 0;
        int maiorTam = 0;
        int posMaior = 0;

        for (int i = 0; i < 100; i++) {
            if (vetor[i] == null) {
                vazias++;
            } else {
                qtdListas++;
                if (vetor[i].tamanho > maiorTam) {
                    maiorTam = vetor[i].tamanho;
                    posMaior = i;
                }
            }
        }

        System.out.println("Maior lista encadeada (posicao " + posMaior + " com " + maiorTam + " elementos):");
        vetor[posMaior].mostrar();
        System.out.println("Quantidade de listas encadeadas geradas: " + qtdListas);
        System.out.println("Posicoes vazias: " + vazias);
        System.out.println("Tres ultimos valores inseridos: " + ultimos[0] + ", " + ultimos[1] + ", " + ultimos[2]);
    }
}
