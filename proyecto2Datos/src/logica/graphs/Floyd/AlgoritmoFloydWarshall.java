package logica.graphs.Floyd;

import java.awt.geom.Point2D;
import java.util.Arrays;
import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;
import logica.graphs.Edge;
import logica.graphs.Graph;

public class AlgoritmoFloydWarshall {

    public static void main(String[] args) {
//        double[][] weights = {{1, 3, 4.6}, {1, 2, 5.1}, {2, 5, 2.5},
//        {3, 2, 1.1}, {5, 3, 8.9}, {2, 4, 1.7}, {4, 5, 5.4}, {5, 6, 2.4},
//        {6, 3, 9.9}};
//        int numVertices = 6;
//        floydWarshall(weights, numVertices);
        Graph<Integer, Double> g0 = new Graph<>();
        g0.add(1, new Point2D.Float(400, 100));
        g0.add(2, new Point2D.Float(250, 250));
        g0.add(3, new Point2D.Float(550, 250));
        g0.add(4, new Point2D.Float(250, 400));
        g0.add(5, new Point2D.Float(350, 350));
        g0.add(6, new Point2D.Float(600, 450));

        g0.add(1, 3, 4.6);
        g0.add(1, 2, 5.0);
        g0.add(2, 5, 2.7);
        g0.add(5, 3, 8.9);
        g0.add(2, 4, 1.1);
        g0.add(4, 5, 5.3);
        g0.add(5, 6, 2.7);
        g0.add(6, 3, 9.9);

        algoritmoFloydWarshall(g0.getEdges());
    }

    static void algoritmoFloydWarshall(List<Edge<Integer, Double>> edge) {
        int numVertices = edge.count();
        System.out.println(numVertices);
        double[][] weights = new double[numVertices][3];
        for (int i = 0; i < numVertices; i++) {

            weights[i][0] = (int) edge.get(i).getHead().getInfo();
            weights[i][1] = (int) edge.get(i).getTail().getInfo();
            weights[i][2] = (double) edge.get(i).getInfo();

        }

        floydWarshall(weights, numVertices);
    }

    static void floydWarshall(double[][] weights, int numVertices) {
        double[][] dist = new double[numVertices][numVertices];
        for (double[] row : dist) {
            Arrays.fill(row, Double.POSITIVE_INFINITY);
        }

        for (double[] w : weights) {
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

        printResult(dist, next);
    }

    static List<camino> printResult(double[][] dist, int[][] next) {
        List<camino> caminosPosibles = new SimpleLinkedList<>();
        camino caminoptr = new camino();
        List<Integer> listaRuta = new SimpleLinkedList<>();

        System.out.println("Par     Peso    Camino");
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++) {
                if (i != j) {
                    int u = i + 1;
                    int v = j + 1;
                    if (dist[i][j] != Double.POSITIVE_INFINITY) {
//                        String path = format("%d -> %d    %.2f     %s", u, v,
//                                dist[i][j], u);
                        caminoptr.setVerticeInicio(u);
                        caminoptr.setVerticeDestino(v);
                        String num = String.format("%.2f", dist[i][j]);
                        caminoptr.setPeso(Double.parseDouble(num));

                        listaRuta.addLast(u);
                        do {
                            u = next[u - 1][v - 1];
//                            path += " -> " + u;
                            listaRuta.addLast(u);
                        } while (u != v);

                        Iterator<Integer> a = listaRuta.getIterator();
                        int[] camino = new int[listaRuta.count()];
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
