package logica.mapa;

import java.awt.geom.Point2D;
import logica.graphs.Graph;

public class crearMapas {

    public static Graph<Integer, Double> posicionarNodosMapaI() {

        Graph<Integer, Double> g0 = new Graph<>();
        g0.add(1, new Point2D.Float(98, 80));
        g0.add(2, new Point2D.Float(225, 85));
        g0.add(3, new Point2D.Float(340, 95));
        g0.add(4, new Point2D.Float(460, 105));
        g0.add(5, new Point2D.Float(583, 120));
        g0.add(6, new Point2D.Float(693, 125));
        g0.add(7, new Point2D.Float(812, 135));

        int n = 12;
        g0.add(8, new Point2D.Float(98, 180 + n));
        g0.add(9, new Point2D.Float(225, 185 + n));
        g0.add(10, new Point2D.Float(340, 195 + n));
        g0.add(11, new Point2D.Float(460, 205 + n));
        g0.add(12, new Point2D.Float(583, 220 + n));
        g0.add(13, new Point2D.Float(693, 225 + n));
        g0.add(14, new Point2D.Float(812, 235 + n));

        n = 142;
        g0.add(15, new Point2D.Float(98, 180 + n));
        g0.add(16, new Point2D.Float(225, 185 + n));
        g0.add(17, new Point2D.Float(340, 195 + n));
        g0.add(18, new Point2D.Float(460, 205 + n));
        g0.add(19, new Point2D.Float(583, 220 + n));
        g0.add(20, new Point2D.Float(693, 225 + n));
        g0.add(21, new Point2D.Float(812, 235 + n));

        n = 270;
        g0.add(22, new Point2D.Float(98, 160 + n));
        g0.add(23, new Point2D.Float(225, 175 + n));
        g0.add(24, new Point2D.Float(340, 195 + n));
        g0.add(25, new Point2D.Float(460, 205 + n));
        g0.add(26, new Point2D.Float(583, 220 + n));
        g0.add(27, new Point2D.Float(693, 225 + n));
        g0.add(28, new Point2D.Float(812, 235 + n));

        n = 390;
        g0.add(29, new Point2D.Float(98, 160 + n));
        g0.add(30, new Point2D.Float(225, 175 + n));
        g0.add(31, new Point2D.Float(340, 195 + n));
        g0.add(32, new Point2D.Float(460, 205 + n));
        g0.add(33, new Point2D.Float(583, 220 + n));
        g0.add(34, new Point2D.Float(693, 225 + n));
        g0.add(35, new Point2D.Float(812, 235 + n));

        g0.add(1, 2, 4.6);
        g0.add(2, 3, 5.0);
        g0.add(3, 4, 2.7);
        g0.add(4, 5, 8.9);
        g0.add(5, 6, 1.1);
        g0.add(6, 7, 1.1);

        g0.add(14, 13, 4.6);
        g0.add(13, 12, 5.0);
        g0.add(12, 11, 2.7);
        g0.add(11, 10, 8.9);
        g0.add(10, 9, 1.1);
        g0.add(9, 8, 1.1);

        g0.add(15, 16, 4.6);
        g0.add(16, 17, 5.0);
        g0.add(17, 18, 2.7);
        g0.add(18, 19, 2.7);
        g0.add(19, 20, 8.9);
        g0.add(20, 21, 1.1);

        g0.add(28, 27, 3.3);
        g0.add(27, 26, 2.8);
        g0.add(26, 25, 2.7);
        g0.add(25, 24, 4.1);
        g0.add(24, 23, 4.5);
        g0.add(23, 22, 8.6);

        g0.add(29, 30, 5.2);
        g0.add(30, 31, 7.3);
        g0.add(31, 32, 9.1);
        g0.add(32, 33, 3.8);
        g0.add(33, 34, 2.8);
        g0.add(34, 35, 8.3);

        g0.add(7, 14, 1.1);
        g0.add(14, 21, 1.1);
        g0.add(21, 28, 6.9);
        g0.add(28, 35, 1.7);

        g0.add(34, 27, 1.1);
        g0.add(27, 20, 1.1);
        g0.add(20, 13, 6.9);
        g0.add(13, 6, 1.7);

        g0.add(5, 12, 3.8);
        g0.add(12, 19, 9.1);
        g0.add(19, 26, 2.2);
        g0.add(26, 33, 7.3);

        g0.add(32, 25, 9.3);
        g0.add(25, 18, 5.5);
        g0.add(18, 11, 6.2);
        g0.add(11, 4, 6.1);

        g0.add(3, 10, 8.8);
        g0.add(10, 17, 2.7);
        g0.add(17, 24, 8.1);
        g0.add(24, 31, 1.1);

        g0.add(23, 16, 7.8);
        g0.add(16, 9, 1.5);
        g0.add(9, 2, 2.2);

        g0.add(29, 22, 2.1);
        g0.add(22, 15, 4.1);
        g0.add(15, 8, 4.4);
        g0.add(8, 1, 4.4);


        System.out.printf("%s%n%n", g0);
        System.out.println();
        System.out.println(g0.getAdjacencyInfo());
        System.out.println();

         mapa<Integer,Double> mapita=new mapa(g0);
         mapita.calcularRutasMinimas();
        return mapita.getGrafo();

    }

    public static Graph<Integer, Double> posicionarNodosMapaII() {

        Graph<Integer, Double> g0 = new Graph<>();
        g0.add(1, new Point2D.Float(98, 80));
        g0.add(2, new Point2D.Float(225, 85));
        g0.add(3, new Point2D.Float(340, 95));
        g0.add(4, new Point2D.Float(460, 105));
        g0.add(5, new Point2D.Float(583, 120));
        g0.add(6, new Point2D.Float(693, 125));
        g0.add(7, new Point2D.Float(812, 135));

        return g0;

    }

}
