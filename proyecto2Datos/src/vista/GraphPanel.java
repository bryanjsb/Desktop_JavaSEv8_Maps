package vista;

import logica.graphs.Graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphPanel<V, E> extends JPanel {

    public GraphPanel(Graph<V, E> g) {
        this.g = g;
        configurar();
    }

    private void configurar() {
        setBackground(new Color(64, 120, 48));
        insertarImagen("mapas/heredia.png");
//          insertarImagen("mapas/mapa2 (1).jpg");
    }

    public void insertarImagen(String nombreImagen) {
        try {
            bkgnd = ImageIO.read(getClass().getResourceAsStream(nombreImagen));
        } catch (IOException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void init() {
        runner = new Thread() {
            @Override
            public void run() {
                while (runner == Thread.currentThread()) {
                    repaint();
                    try {
                        Thread.sleep(MAX_WAIT);
                    } catch (InterruptedException ex) {
                    }
                }
            }

        };
        runner.start();
    }

    @Override
    public void paintComponent(Graphics bg) {
        super.paintComponent(bg);

        g.paint(bg, getBounds());
        paintImage(bg);
    }

    private void paintImage(Graphics bg) {
        if (bkgnd != null) {
            bg.drawImage(bkgnd, 0, 0, this);
        }
        g.paint(bg, getBounds());
    }

    private static final int MAX_WAIT = 35;
    private Thread runner;
    private final Graph<V, E> g;
    private Image bkgnd = null;
}
