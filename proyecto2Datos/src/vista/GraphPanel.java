package vista;

import logica.graphs.Graph;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GraphPanel<V, E> extends JPanel {

    public GraphPanel(Graph<V, E> g) {
        this.g = g;
        configurar();
    }

    private void configurar() {
        setBackground(Color.LIGHT_GRAY);
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
    }

    private static final int MAX_WAIT = 35;
    private Thread runner;
    private Graph<V, E> g;
}
