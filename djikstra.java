import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[][] grafo = new int[5][5];
        int[] distancia = new int[5];
        boolean[] visitado = new boolean[5];
        int origem, atual, menor;
        int i, j, v;

        int[][] matriz = {
                {0, 10, 0, 30, 100},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {100, 0, 10, 60, 0}
        };

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                grafo[i][j] = matriz[i][j];
            }
        }

        System.out.print("\n ALGORITMO DE DIJKSTRA");
        System.out.print("\n Vértices: 0, 1, 2, 3, 4");

        do {
            System.out.print("\n Informe o vértice de origem: ");
            origem = sc.nextInt();
        } while (origem < 0 || origem >= n);

        for (i = 0; i < n; i++) {
            distancia[i] = 99999;
            visitado[i] = false;
        }
        distancia[origem] = 0;

        for (i = 0; i < n; i++) {
            menor = 99999;
            atual = -1;
            for (j = 0; j < n; j++) {
                if (!visitado[j] && distancia[j] < menor) {
                    menor = distancia[j];
                    atual = j;
                }
            }

            if (atual == -1) {
                break;
            }

            visitado[atual] = true;

            for (v = 0; v < n; v++) {
                if (grafo[atual][v] > 0 && !visitado[v]) {
                    if (distancia[atual] + grafo[atual][v] < distancia[v]) {
                        distancia[v] = distancia[atual] + grafo[atual][v];
                    }
                }
            }
        }
        System.out.print("\n Menores distâncias a partir do vértice " + origem + ":\n");
        for (i = 0; i < n; i++) {
            if (distancia[i] == 99999) {
                System.out.print(" Vértice " + i + " = inalcançável\n");
            } else {
                System.out.print(" Vértice " + i + " = " + distancia[i] + "\n");
            }
        }

        sc.close();
    }
}
