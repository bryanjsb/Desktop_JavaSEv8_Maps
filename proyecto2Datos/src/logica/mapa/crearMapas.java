package logica.mapa;

import java.awt.geom.Point2D;

/**
 *
 * @author Priscilla
 */
public class crearMapas<V, E> {

    /**
     *
     * @return
     */
    public static mapa posicionarNodosMapaI() {

        mapa<Integer, Double> mapita = new mapa();
        mapita.add(1, new Point2D.Float(98, 80));
        mapita.add(2, new Point2D.Float(225, 85));
        mapita.add(3, new Point2D.Float(340, 95));
        mapita.add(4, new Point2D.Float(460, 105));
        mapita.add(5, new Point2D.Float(583, 120));
        mapita.add(6, new Point2D.Float(693, 125));
        mapita.add(7, new Point2D.Float(812, 135));

        int n = 12;
        mapita.add(8, new Point2D.Float(98, 180 + n));
        mapita.add(9, new Point2D.Float(225, 185 + n));
        mapita.add(10, new Point2D.Float(340, 195 + n));
        mapita.add(11, new Point2D.Float(460, 205 + n));
        mapita.add(12, new Point2D.Float(583, 220 + n));
        mapita.add(13, new Point2D.Float(693, 225 + n));
        mapita.add(14, new Point2D.Float(812, 235 + n));

        n = 142;
        mapita.add(15, new Point2D.Float(98, 180 + n));
        mapita.add(16, new Point2D.Float(225, 185 + n));
        mapita.add(17, new Point2D.Float(340, 195 + n));
        mapita.add(18, new Point2D.Float(460, 205 + n));
        mapita.add(19, new Point2D.Float(583, 220 + n));
        mapita.add(20, new Point2D.Float(693, 225 + n));
        mapita.add(21, new Point2D.Float(812, 235 + n));

        n = 270;
        mapita.add(22, new Point2D.Float(98, 160 + n));
        mapita.add(23, new Point2D.Float(225, 175 + n));
        mapita.add(24, new Point2D.Float(340, 195 + n));
        mapita.add(25, new Point2D.Float(460, 205 + n));
        mapita.add(26, new Point2D.Float(583, 220 + n));
        mapita.add(27, new Point2D.Float(693, 225 + n));
        mapita.add(28, new Point2D.Float(812, 235 + n));

        n = 390;
        mapita.add(29, new Point2D.Float(98, 160 + n));
        mapita.add(30, new Point2D.Float(225, 175 + n));
        mapita.add(31, new Point2D.Float(340, 195 + n));
        mapita.add(32, new Point2D.Float(460, 205 + n));
        mapita.add(33, new Point2D.Float(583, 220 + n));
        mapita.add(34, new Point2D.Float(693, 225 + n));
        mapita.add(35, new Point2D.Float(812, 235 + n));

        mapita.add(1, 2, 4.6);
        mapita.add(2, 3, 5.0);
        mapita.add(3, 4, 2.7);
        mapita.add(4, 5, 8.9);
        mapita.add(5, 6, 1.1);
        mapita.add(6, 7, 1.1);

        mapita.add(14, 13, 4.6);
        mapita.add(13, 12, 5.0);
        mapita.add(12, 11, 2.7);
        mapita.add(11, 10, 8.9);
        mapita.add(10, 9, 1.1);
        mapita.add(9, 8, 1.1);

        mapita.add(15, 16, 4.6);
        mapita.add(16, 17, 5.0);
        mapita.add(17, 18, 2.7);
        mapita.add(18, 19, 2.7);
        mapita.add(19, 20, 8.9);
        mapita.add(20, 21, 1.1);

        mapita.add(28, 27, 3.3);
        mapita.add(27, 26, 2.8);
        mapita.add(26, 25, 2.7);
        mapita.add(25, 24, 4.1);
        mapita.add(24, 23, 4.5);
        mapita.add(23, 22, 8.6);

        mapita.add(29, 30, 5.2);
        mapita.add(30, 31, 7.3);
        mapita.add(31, 32, 9.1);
        mapita.add(32, 33, 3.8);
        mapita.add(33, 34, 2.8);
        mapita.add(34, 35, 8.3);

        mapita.add(7, 14, 1.1);
        mapita.add(14, 21, 1.1);
        mapita.add(21, 28, 6.9);
        mapita.add(28, 35, 1.7);

        mapita.add(34, 27, 1.1);
        mapita.add(27, 20, 1.1);
        mapita.add(20, 13, 6.9);
        mapita.add(13, 6, 1.7);

        mapita.add(5, 12, 3.8);
        mapita.add(12, 19, 9.1);
        mapita.add(19, 26, 2.2);
        mapita.add(26, 33, 7.3);

        mapita.add(32, 25, 9.3);
        mapita.add(25, 18, 5.5);
        mapita.add(18, 11, 6.2);
        mapita.add(11, 4, 6.1);

        mapita.add(3, 10, 8.8);
        mapita.add(10, 17, 2.7);
        mapita.add(17, 24, 8.1);
        mapita.add(24, 31, 1.1);

        mapita.add(23, 16, 7.8);
        mapita.add(16, 9, 1.5);
        mapita.add(9, 2, 2.2);

        mapita.add(29, 22, 2.1);
        mapita.add(22, 15, 4.1);
        mapita.add(15, 8, 4.4);
        mapita.add(8, 1, 4.4);
        
        return mapita;

    }

    public static mapa<Integer, Double> posicionarNodosMapaII() {

        mapa<Integer, Double> mapita = new mapa();
        mapita.add(1, new Point2D.Float(98, 80));
        mapita.add(2, new Point2D.Float(225, 85));
        mapita.add(3, new Point2D.Float(340, 95));
        mapita.add(4, new Point2D.Float(460, 105));
        mapita.add(5, new Point2D.Float(583, 120));
        mapita.add(6, new Point2D.Float(693, 125));
        mapita.add(7, new Point2D.Float(812, 135));

        return mapita;

    }

}
