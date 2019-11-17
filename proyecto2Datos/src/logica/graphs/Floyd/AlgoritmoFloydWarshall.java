package logica.graphs.Floyd;

import java.util.Arrays;
import java.util.LinkedList;
import logica.graphs.Edge;
import logica.graphs.GVertex;
import logica.graphs.Graph;

public class AlgoritmoFloydWarshall<V, E> {

    public AlgoritmoFloydWarshall() {

    }

    public coleccionCamino<V, E> algoritmoFloydWarshall(Graph<V, E> g) {
        LinkedList<Edge<V, E>> edge = g.getEdges();
        int numAristas = edge.size();

        Object[][] pesos = new Object[numAristas][3];
        for (int i = 0; i < numAristas; i++) {
            pesos[i][0] = edge.get(i).getHead().getInfo();
            pesos[i][1] = edge.get(i).getTail().getInfo();
            pesos[i][2] = edge.get(i).getInfo();
        }
        return floydWarshall(pesos, numAristas, g);
    }

    coleccionCamino<V, E> floydWarshall(Object[][] pesos, int numVertices, Graph<V, E> g) {
        double[][] dist = new double[numVertices][numVertices];
        for (double[] row : dist) {
            Arrays.fill(row, Double.POSITIVE_INFINITY);
        }

        for (Object[] w : pesos) {
            dist[(int) w[0] - 1][(int) w[1] - 1] = Double.parseDouble(w[2].toString());
        }

        int[][] next = new int[numVertices][numVertices];
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++) {
                if (i != j) {
                    next[i][j] = j + 1;
                }
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        return agregandoCaminos(dist, next, g);
    }

    coleccionCamino<V, E> agregandoCaminos(double[][] dist, int[][] next, Graph g) {
        coleccionCamino<V, E> caminosPosibles = new coleccionCamino();
        LinkedList<GVertex<V>> listaRuta = new LinkedList<>();

        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++) {
                if (i != j) {
                    int u = i + 1;
                    int v = j + 1;
                    if (dist[i][j] != Double.POSITIVE_INFINITY) {
                        GVertex<V> vInicio = g.getVertex(v);
                        GVertex<V> vDestino = g.getVertex(u);
                        String num = String.format("%.2f", dist[i][j]);
                        E peso = (E) (num);

                        listaRuta.addLast(g.getVertex(u));
                        do {
                            u = next[u - 1][v - 1];
                            listaRuta.addFirst(g.getVertex(u));
                        } while (u != v);

                        LinkedList<GVertex<V>> camino = new LinkedList<>();

                        for (GVertex<V> a : listaRuta) {
                            camino.addLast((GVertex) a);
                        }

                        caminosPosibles.addLast(vInicio, vDestino, peso, camino);

                        listaRuta.clear();

                    }
                }
            }
        }

        return caminosPosibles;
    }
}
