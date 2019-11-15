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
        mapita.add(2, 9, 2.2);

        mapita.add(29, 22, 2.1);
        mapita.add(22, 15, 4.1);
        mapita.add(15, 8, 4.4);
        mapita.add(8, 1, 4.4);

        mapita.setUbicacionImagen("/ima/imaMapa/heredia.png");
        return mapita;

    }

    public static mapa posicionarNodosMapaII() {

        mapa<Integer, Double> mapita = new mapa();
       mapita.add(1, new Point2D.Float(10, 210));
        mapita.add(2, new Point2D.Float(170, 210));
        mapita.add(3, new Point2D.Float(280, 220));
        mapita.add(4, new Point2D.Float(295, 110));
        mapita.add(5, new Point2D.Float(400, 130));
        mapita.add(6, new Point2D.Float(535, 145));
        mapita.add(7, new Point2D.Float(620, 155));
        mapita.add(8, new Point2D.Float(720, 170));
        mapita.add(9, new Point2D.Float(825, 180));
        mapita.add(10, new Point2D.Float(840, 285));
        mapita.add(11, new Point2D.Float(830, 400));
        mapita.add(12, new Point2D.Float(690, 400));
        mapita.add(13, new Point2D.Float(690, 490));
        mapita.add(14, new Point2D.Float(680, 580));
        mapita.add(15, new Point2D.Float(590, 570));
        mapita.add(16, new Point2D.Float(490, 560));
        mapita.add(17, new Point2D.Float(380, 545));
        mapita.add(18, new Point2D.Float(280, 535));
        mapita.add(19, new Point2D.Float(190, 525));
        mapita.add(20, new Point2D.Float(110, 505));
        mapita.add(21, new Point2D.Float(120, 440));
        mapita.add(22, new Point2D.Float(10, 400));
        
        mapita.add(23, new Point2D.Float(170, 290));
        mapita.add(24, new Point2D.Float(230, 290));
        mapita.add(25, new Point2D.Float(215, 390));
        mapita.add(26, new Point2D.Float(140, 390));
        
        mapita.add(27, new Point2D.Float(280, 330));
        mapita.add(28, new Point2D.Float(280, 430));
        
        mapita.add(29, new Point2D.Float(590, 480));
        mapita.add(30, new Point2D.Float(500, 470));
        mapita.add(31, new Point2D.Float(390, 460));
        mapita.add(32, new Point2D.Float(220, 430));
        mapita.add(33, new Point2D.Float(200, 480));
        mapita.add(34, new Point2D.Float(590, 380));
        mapita.add(35, new Point2D.Float(500, 370));
        mapita.add(36, new Point2D.Float(410, 350));
        
        mapita.add(37, new Point2D.Float(700, 280));
        mapita.add(38, new Point2D.Float(610, 260));
        mapita.add(39, new Point2D.Float(520, 240));
        mapita.add(40, new Point2D.Float(410, 230));
        
        mapita.add(1, 2, 4.6);
        mapita.add(2, 3, 5.0);
        mapita.add(3, 4, 2.7);
        mapita.add(4, 5, 8.9);
        mapita.add(5, 6, 1.1);
        mapita.add(6, 7, 1.1);
        mapita.add(7, 8, 4.6);
        mapita.add(8, 9, 5.0);
        mapita.add(9, 10, 2.7);
        mapita.add(10, 11, 8.9);
        
        mapita.add(11, 12, 1.1);
        mapita.add(12, 13, 1.1);
        mapita.add(13, 14, 1.1);

        mapita.add(14, 15, 4.6);
        mapita.add(15, 16, 5.0);
        mapita.add(16, 17, 2.7);
        mapita.add(17, 18, 2.7);
        mapita.add(18, 19, 8.9);
        mapita.add(19, 20, 1.1);

        mapita.add(20, 21, 3.3);
        mapita.add(21, 1, 2.8);
     
        
        mapita.add(2, 23, 3.3);
        mapita.add(23, 24, 2.8);
        mapita.add(24, 25, 2.7);
        mapita.add(25, 26, 4.1);
        mapita.add(26, 21, 4.5);
        mapita.add(23, 26, 8.6);
        
        mapita.add(3, 27, 5.2);
        mapita.add(27, 28, 7.3); 

        mapita.add(28, 18, 9.1);
        
        mapita.add(13, 29, 3.3);
        mapita.add(29, 30, 2.8);
        mapita.add(30, 31, 2.7);
        mapita.add(31, 28, 4.1);
        mapita.add(28, 25, 4.5);
        mapita.add(25, 26, 8.6);
        mapita.add(27, 28, 5.2);
        mapita.add(28, 32, 7.3); 
        mapita.add(32, 33, 7.3); 
        
        mapita.add(11, 12, 7.3); 
        mapita.add(12, 34, 1.3); 
        mapita.add(34, 35, 5.3); 
        mapita.add(35, 36, 5.3); 
        mapita.add(36, 27, 5.3); 
        
        mapita.add(10, 37, 2.1);
        mapita.add(37, 38, 9.5);
        mapita.add(38, 39, 6.2);
        mapita.add(39, 40, 7.8);
        mapita.add(40, 3, 3.6);
        
        mapita.setUbicacionImagen("/ima/imaMapa/cartago.png");
        return mapita;

    }
    
    public static mapa posicionarNodosMapaIII() { /*<Integer, Double>*/
        mapa<Integer, Double> mapita = new mapa();
        
        mapita.add(1, new Point2D.Float(70, 50));
        mapita.add(2, new Point2D.Float(345, 75));
        mapita.add(3, new Point2D.Float(345, 128));
        mapita.add(4, new Point2D.Float(420, 138));
        mapita.add(5, new Point2D.Float(480, 145));
        mapita.add(6, new Point2D.Float(560, 155));

        mapita.add(7, new Point2D.Float(640, 165));
        mapita.add(8, new Point2D.Float(700, 170));
        mapita.add(9, new Point2D.Float(780, 185));
        mapita.add(10, new Point2D.Float(870, 195));
        mapita.add(11, new Point2D.Float(930, 200));
        mapita.add(12, new Point2D.Float(930, 280));
        mapita.add(13, new Point2D.Float(930, 360));

        mapita.add(14, new Point2D.Float(930, 440));
        mapita.add(15, new Point2D.Float(830, 430));
        mapita.add(16, new Point2D.Float(770, 425));
        mapita.add(17, new Point2D.Float(680, 420));
        mapita.add(18, new Point2D.Float(610, 418));
        mapita.add(19, new Point2D.Float(560, 414));
        mapita.add(20, new Point2D.Float(480, 410));

        mapita.add(21, new Point2D.Float(400, 405));
        mapita.add(22, new Point2D.Float(320, 400));
        mapita.add(23, new Point2D.Float(250, 395));
        mapita.add(24, new Point2D.Float(165, 390));
        mapita.add(25, new Point2D.Float(95, 385));
        mapita.add(26, new Point2D.Float(40, 380));

        mapita.add(27, new Point2D.Float(40, 310));
        mapita.add(28, new Point2D.Float(40, 230));
        mapita.add(29, new Point2D.Float(48, 140));
        
        mapita.add(30, new Point2D.Float(870, 275));
        mapita.add(31, new Point2D.Float(870, 355));
        
        mapita.add(32, new Point2D.Float(790, 265));
        mapita.add(33, new Point2D.Float(790, 355));
        
        mapita.add(34, new Point2D.Float(700, 260));
        mapita.add(35, new Point2D.Float(700, 340));
        
        mapita.add(36, new Point2D.Float(635, 245));
        mapita.add(37, new Point2D.Float(630, 335));
//
        mapita.add(38, new Point2D.Float(560, 235));
        mapita.add(39, new Point2D.Float(560, 330));
        
        mapita.add(40, new Point2D.Float(480, 230));
        mapita.add(41, new Point2D.Float(480, 310));
        
        mapita.add(42, new Point2D.Float(420, 215));
        mapita.add(43, new Point2D.Float(420, 300));
        
        mapita.add(44, new Point2D.Float(340, 200));
        mapita.add(45, new Point2D.Float(325, 280));
        
        mapita.add(46, new Point2D.Float(250, 280));

        mapita.add(1, 2, 4.6);
        mapita.add(2, 3, 5.0);
        mapita.add(3, 4, 2.7);
        mapita.add(4, 5, 8.9);
        mapita.add(5, 6, 1.1);
        mapita.add(6, 7, 1.1);
        mapita.add(7, 8, 4.6);
        mapita.add(8, 9, 5.0);
        mapita.add(9, 10, 2.7);
        mapita.add(10, 11, 8.9);
        
        mapita.add(11, 12, 1.1);
        mapita.add(12, 13, 1.1);
        mapita.add(13, 14, 1.1);
//
        mapita.add(14, 15, 4.6);
        mapita.add(15, 16, 5.0);
        mapita.add(16, 17, 2.7);
        mapita.add(17, 18, 2.7);
        mapita.add(18, 19, 8.9);
        mapita.add(19, 20, 1.1);
//
        mapita.add(20, 21, 3.3);
        mapita.add(21, 22, 2.8);
        mapita.add(22, 23, 2.7);
        mapita.add(23, 24, 4.1);
        mapita.add(24, 25, 4.5);
        mapita.add(25, 26, 8.6);
        mapita.add(27, 28, 5.2);
        mapita.add(29, 1, 7.3); 
        // 10 30 31 15
        mapita.add(10, 30, 9.1);
        mapita.add(30, 31, 3.8);
        mapita.add(31, 15, 2.8);
   
        mapita.add(16, 33, 8.3);
        mapita.add(33, 32, 1.1);
        mapita.add(32, 9, 1.1); 
        // 8  34 35 17
        mapita.add(8, 34, 6.9);
        mapita.add(34, 35, 1.7);
        mapita.add(35, 17, 1.1);
        // 18 36 37 7

        mapita.add(18, 37, 1.1);
        mapita.add(37, 36, 6.9);
        mapita.add(36, 7, 1.7);
        //6 38 39 19

        mapita.add(6, 38, 3.8);
        mapita.add(38, 39, 9.1);
        mapita.add(39, 19, 2.2);
        
        //18 41 40 5
        mapita.add(20, 41, 9.3);
        mapita.add(41, 40, 5.5);
        mapita.add(40, 5, 6.2);
        
        //4 42 43 21
        mapita.add(4, 42, 8.8);
        mapita.add(42, 43, 2.7);
        mapita.add(43, 21, 8.1);
        //22 44 45 3
        mapita.add(22, 44, 1.1);
        mapita.add(44, 45, 7.8);
        mapita.add(45, 3, 1.5);

        //44 42 40 38 36 34 32 30 12 
        mapita.add(44, 42, 2.1);
        mapita.add(42, 40, 9.5);
        mapita.add(40, 38, 1.3);
        mapita.add(38, 36, 6.2);
        mapita.add(36, 34, 7.8);
        mapita.add(34, 32, 3.6);
        mapita.add(32, 30, 12.4);
        mapita.add(30, 12, 0.3);
        
       // 23 46 45 43 41 39 37 35 33 31 13 
        mapita.add(13, 31, 2.1);
        mapita.add(31, 33, 9.5);
        mapita.add(33, 35, 1.3);
        mapita.add(35, 37, 6.2);
        mapita.add(37, 39, 7.8);
        mapita.add(39, 41, 2.6);
        mapita.add(41, 43, 3.4);
        mapita.add(43, 45, 0.3);
        mapita.add(45, 46, 3.26);
        mapita.add(46, 23, 1.2);
        //22 45 44 3
        mapita.add(22, 45, 12.4);
        mapita.add(45, 44, 0.3);
        mapita.add(44, 3, 3.6);
       
        mapita.setUbicacionImagen("/ima/imaMapa/san jose.png");
  

        return mapita;

    }

}
