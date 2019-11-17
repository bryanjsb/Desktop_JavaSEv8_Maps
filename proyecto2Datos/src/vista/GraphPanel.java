package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logica.controller.controller;

public class GraphPanel<V, E> extends JPanel {

    private static final int MAX_WAIT = 35;
    private Thread runner;
    private Image bkgnd = null;

    private final controller<V, E> g;

    /**
     *
     * @param g
     */
    public GraphPanel(controller<V, E> g) {
        this.g = g;
        configurar();
    }

    private void configurar() {
        setBackground(new Color(64, 120, 48));
        insertarImagen(g.getUbicacionImagen());
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

        g.paint(bg, null);
        paintImage(bg);
    }

    private void paintImage(Graphics bg) {
        if (bkgnd != null) {
            bg.drawImage(bkgnd, 0, 0, this);
        }
        g.paint(bg, null);
    }

}
