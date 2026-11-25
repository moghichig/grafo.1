programa
{
    funcao inicio()
    {
        inteiro n = 5
        inteiro grafo[5][5]
        inteiro distancia[5]
        logico visitado[5]
        inteiro origem, atual, menor
        inteiro i, j, v

        inteiro matriz[5][5] = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        }

        para (i = 0; i < n; i++)
        {
            para (j = 0; j < n; j++)
            {
                grafo[i][j] = matriz[i][j]
            }
        }

        escreva("\n ALGORITMO DE DIJKSTRA")
        escreva("\n Vértices: 0, 1, 2, 3, 4")

        faca
        {
            escreva("\n Informe o vértice de origem: ")
            leia(origem)
        } enquanto (origem < 0 ou origem >= n)

        para (i = 0; i < n; i++)
        {
            distancia[i] = 99999
            visitado[i] = falso
        }
        distancia[origem] = 0

        para (i = 0; i < n; i++)
        {
            menor = 99999
            atual = -1
            para (j = 0; j < n; j++)
            {
                se (visitado[j] == falso e distancia[j] < menor)
                {
                    menor = distancia[j]
                    atual = j
                }
            }

            se (atual == -1)
            {
                pare
            }

            visitado[atual] = verdadeiro

            para (v = 0; v < n; v++)
            {
                se (grafo[atual][v] > 0 e visitado[v] == falso)
                {
                    se (distancia[atual] + grafo[atual][v] < distancia[v])
                    {
                        distancia[v] = distancia[atual] + grafo[atual][v]
                    }
                }
            }
        }

        escreva("\n Menores distâncias a partir do vértice ", origem, ":\n")
        para (i = 0; i < n; i++)
        {
            se (distancia[i] == 99999)
            {
                escreva(" Vértice ", i, " = inalcançável\n")
            }
            senao
            {
                escreva(" Vértice ", i, " = ", distancia[i], "\n")
            }
        }
    }
}

