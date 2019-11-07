/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import logica.graphs.Graph;

/**
 *
 * @author Bryan
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ventana1
     * @param titulo
     * @param g
     */


    public VentanaPrincipal(String titulo, Graph<Integer, Double> g)
            throws HeadlessException {
        super(titulo);
        this.g = g;
         initComponents();
       configurar();
    }
    
    public VentanaPrincipal(String titulo) {
        super(titulo);
        this.g = inicializar();
         initComponents();
         configurar();
    }
    
     public VentanaPrincipal() {
        this("");
    }
    
     private void configurar() {
//        ajustarComponentes(getContentPane());
//        setResizable(true);
        setSize(1024, 900);
//        setMinimumSize(new Dimension(640, 480));
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

//    private void ajustarComponentes(Container c) {
//        c.setLayout(new BorderLayout());
//        c.add(this.jPanelVistaMapa);
//    }

    public void init() {
        setVisible(true);
        GraphPanel ptr=(GraphPanel)this.jPanelVistaMapa;
        ptr.init();
        g.init();
    }
    
        public final Graph<Integer, Double> inicializar() {
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

        g0.add(1, 3, 4.6);
        g0.add(1, 2, 5.0);
        g0.add(2, 5, 2.7);
        g0.add(5, 3, 8.9);
        g0.add(2, 4, 1.1);
        g0.add(4, 5, 5.3);
        g0.add(5, 6, 2.7);
        g0.add(6, 3, 9.9);

        System.out.printf("%s%n%n", g0);
        System.out.println();
        System.out.println(g0.getAdjacencyInfo());
        System.out.println();

        return g0;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanelVistaMapa = new GraphPanel(g);
        jPanelVistaOpcion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAgregarRepartidor = new javax.swing.JTextField();
        jTextFieldPSalida = new javax.swing.JTextField();
        jTextFieldPLlegada = new javax.swing.JTextField();
        jButtonAgregarRepartidor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemMapHeredia = new javax.swing.JMenuItem();
        jMenuItemMapCartago = new javax.swing.JMenuItem();
        jMenuItemMapSJ = new javax.swing.JMenuItem();
        jMenuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Mapa"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Mapa"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanelVistaMapaLayout = new javax.swing.GroupLayout(jPanelVistaMapa);
        jPanelVistaMapa.setLayout(jPanelVistaMapaLayout);
        jPanelVistaMapaLayout.setHorizontalGroup(
            jPanelVistaMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanelVistaMapaLayout.setVerticalGroup(
            jPanelVistaMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Agregar Repartidor:");

        jLabel2.setText("Punto de salida");

        jLabel3.setText("Punto de llegada");

        jButtonAgregarRepartidor.setText("Agregar");

        javax.swing.GroupLayout jPanelVistaOpcionLayout = new javax.swing.GroupLayout(jPanelVistaOpcion);
        jPanelVistaOpcion.setLayout(jPanelVistaOpcionLayout);
        jPanelVistaOpcionLayout.setHorizontalGroup(
            jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVistaOpcionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addGroup(jPanelVistaOpcionLayout.createSequentialGroup()
                        .addGroup(jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAgregarRepartidor)
                            .addGroup(jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldAgregarRepartidor)
                                .addComponent(jTextFieldPSalida)
                                .addComponent(jTextFieldPLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelVistaOpcionLayout.setVerticalGroup(
            jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVistaOpcionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAgregarRepartidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jTextFieldPSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAgregarRepartidor)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jMenuArchivo.setText("Archivo");

        jMenuItemMapHeredia.setText("Cargar Mapa Heredia");
        jMenuArchivo.add(jMenuItemMapHeredia);

        jMenuItemMapCartago.setText("Cargar Mapa Cartago");
        jMenuArchivo.add(jMenuItemMapCartago);

        jMenuItemMapSJ.setText("Cargar Mapa San Jose");
        jMenuArchivo.add(jMenuItemMapSJ);

        jMenuBar1.add(jMenuArchivo);

        jMenuAcercaDe.setText("Acerca De");
        jMenuBar1.add(jMenuAcercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelVistaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelVistaMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVistaMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelVistaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarRepartidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenuAcercaDe;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemMapCartago;
    private javax.swing.JMenuItem jMenuItemMapHeredia;
    private javax.swing.JMenuItem jMenuItemMapSJ;
    private javax.swing.JPanel jPanelVistaMapa;
    private javax.swing.JPanel jPanelVistaOpcion;
    private javax.swing.JTextField jTextFieldAgregarRepartidor;
    private javax.swing.JTextField jTextFieldPLlegada;
    private javax.swing.JTextField jTextFieldPSalida;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables


    private final Graph<Integer, Double> g;

}
