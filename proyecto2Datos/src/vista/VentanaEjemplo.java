package vista;

import logica.graphs.Graph;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import javax.swing.JFrame;

public final class VentanaEjemplo extends JFrame {
    
    public VentanaEjemplo(String titulo, Graph<Integer, Double> g)
            throws HeadlessException {
        super(titulo);
        this.g = g;
        configurar();
    }
    
     public VentanaEjemplo(String titulo) {
        super(titulo);
        this.g = inicializar();
        configurar();
    }
    
    private void configurar() {
        ajustarComponentes(getContentPane());
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(640, 480));
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                g.setActive(false);
                System.exit(0);
            }
            
        });
    }
    
    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER, panelPrincipal = new GraphPanel(g));
    }
    
    public void init() {
        setVisible(true);
        panelPrincipal.init();
        g.init();
    }
    
    public Graph<Integer, Double> inicializar() {
        Graph<Integer, Double> g0 = new Graph<>();

        int mx = 64;
        int my = 64;
        int sx = 72;
        int sy = 96;

        g0.add(1, new Point2D.Float(400, 100));
        g0.add(2, new Point2D.Float(250, 250));
        g0.add(3, new Point2D.Float(550, 250));
        g0.add(4, new Point2D.Float(250, 400));
        g0.add(5, new Point2D.Float(350, 350));
        g0.add(6, new Point2D.Float(600, 450));

        g0.add(1, 3);
        g0.add(1, 2);
        g0.add(2, 5);
        g0.add(5, 3);
        g0.add(2, 4);
        g0.add(4, 5);
        g0.add(5, 6);
        g0.add(6,3);

//        System.out.printf("%s%n%n", g0);
//        System.out.println();
//        System.out.println(g0.getAdjacencyInfo());
//        System.out.println();

       return g0;
    }
    private GraphPanel panelPrincipal;
    private final Graph<Integer, Double> g;
}
