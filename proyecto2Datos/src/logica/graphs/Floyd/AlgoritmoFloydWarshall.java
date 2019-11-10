package logica.graphs.Floyd;

import java.util.Arrays;
import javax.xml.bind.ParseConversionEvent;
import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;
import logica.graphs.Edge;
import logica.graphs.GVertex;
import logica.graphs.Graph;

public class AlgoritmoFloydWarshall {

    public AlgoritmoFloydWarshall() {

    }

    public coleccionCamino algoritmoFloydWarshall(Graph g) {
        List<Edge> edge = g.getEdges();
        int numAristas = edge.count();

//        System.out.printf("numero de aristas: %d %n", numAristas);
        Object[][] weights = new Object[numAristas][3];
        for (int i = 0; i < numAristas; i++) {
            weights[i][0] = edge.get(i).getHead().getInfo();
            weights[i][1] = edge.get(i).getTail().getInfo();
            weights[i][2] = edge.get(i).getInfo();
        }
        return floydWarshall(weights, numAristas, g);
    }

    coleccionCamino floydWarshall(Object[][] weights, int numVertices, Graph g) {
        double[][] dist = new double[numVertices][numVertices];
        for (double[] row : dist) {
            Arrays.fill(row, Double.POSITIVE_INFINITY);
        }

        for (Object[] w : weights) {
            dist[(int) w[0] - 1][(int) w[1] - 1] = (double) w[2];
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

    coleccionCamino agregandoCaminos(double[][] dist, int[][] next, Graph g) {
//        List<camino> caminosPosibles = new SimpleLinkedList<>();
        coleccionCamino caminosPosibles = new coleccionCamino();
        camino caminoptr = new camino();
        List<GVertex> listaRuta = new SimpleLinkedList<>();

//        System.out.println("Par     Peso    Camino");
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j) {
                    int u = i + 1;
                    int v = j + 1;
                    if (dist[i][j] != Double.POSITIVE_INFINITY) {
//                        String path = format("%d -> %d    %.2f     %s", u, v,
//                                dist[i][j], u);

                        caminoptr.setVerticeInicio(g.getVertex(v));
                        caminoptr.setVerticeDestino(g.getVertex(u));
                        String num = String.format("%.2f", dist[i][j]);
                        caminoptr.setPeso(Double.parseDouble(num));

                        listaRuta.addLast(g.getVertex(u));
                        do {
                            u = next[u - 1][v - 1];
//                            path += " -> " + u;
                            listaRuta.addFirst(g.getVertex(u));
                        } while (u != v);

                        Iterator<GVertex> a = listaRuta.getIterator();
                        GVertex[] camino = new GVertex[listaRuta.count()];
                        int cont = 0;
                        while (a.hasNext()) {
                            camino[cont++] = a.getNext();
                        }
                        cont = 0;
                        caminoptr.setRuta(camino);
                        caminosPosibles.addLast(new camino(caminoptr.getVerticeInicio(),
                                caminoptr.getVerticeDestino(), caminoptr.getPeso(),
                                caminoptr.getRuta()));
                        listaRuta.clear();
//                        System.out.println(path);
                    }
                }
            }
        }
        System.out.println(caminosPosibles);
        return caminosPosibles;
    }
}
