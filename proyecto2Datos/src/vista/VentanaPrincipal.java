/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import logica.controller.controller;
import logica.mapa.crearMapas;
import logica.mapa.mapa;

/**
 *
 * @author Bryan
 */
public class VentanaPrincipal<V, E> extends JFrame implements Observer{

    /**
     * Creates new form ventana1
     *
     * @param titulo
     * @param g
     */
    
    @Override
    public void update(Observable o, Object arg) {
        this.jPanelVistaMapa.repaint();
    }
    
    public VentanaPrincipal(String titulo, controller<V, E> g)
            throws HeadlessException {
        super(titulo);
        control=new controller<>();
        control.setMapa(inicializar());
        initComponents();
        configurar();
    }

    public VentanaPrincipal() throws HeadlessException {
        this("Gestor de rutas minimas, para repartidores", null);
    }

    private void configurar() {
        setResizable(true);

        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);
        setMinimumSize(new Dimension(640, 480));
        setLocationRelativeTo(null);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
//                control.setActive(false);
                System.exit(0);
            }

        });
    }

    public void init() {
        setVisible(true);
        control.registrar(this);
        GraphPanel ptr = (GraphPanel) this.jPanelVistaMapa;
        ptr.init();
        control.init();
        
    }

    public final mapa<V, E> inicializar() {
        return crearMapas.mapaHeredia();
//          return crearMapas.mapaCartago();
//            return crearMapas.mapaSanJose();
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

        jPanelVistaMapa = new GraphPanel(control);
        jPanelVistaOpcion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIdRepatidor = new javax.swing.JTextField();
        jTextFieldPuntoInicio = new javax.swing.JTextField();
        jTextFieldPuntoDestino = new javax.swing.JTextField();
        jButtonEmpezarRuta = new javax.swing.JButton();
        jButtonGuardarMapaHeredia = new javax.swing.JButton();
        jButtonGuardarMapaCartago = new javax.swing.JButton();
        jButtonGuardarMapaSanJose = new javax.swing.JButton();
        jMenuBarraHerramienta = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemMapHeredia = new javax.swing.JMenuItem();
        jMenuItemMapCartago = new javax.swing.JMenuItem();
        jMenuItemMapSanJose = new javax.swing.JMenuItem();
        jMenuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Mapa"); // NOI18N
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Mapa"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanelVistaMapaLayout = new javax.swing.GroupLayout(jPanelVistaMapa);
        jPanelVistaMapa.setLayout(jPanelVistaMapaLayout);
        jPanelVistaMapaLayout.setHorizontalGroup(
            jPanelVistaMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        jPanelVistaMapaLayout.setVerticalGroup(
            jPanelVistaMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        jLabel1.setText("Id Repartidor");

        jLabel2.setText("Inicio");

        jLabel3.setText("Destino");

        jButtonEmpezarRuta.setText("Empezar ruta");
        jButtonEmpezarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpezarRutaActionPerformed(evt);
            }
        });

        jButtonGuardarMapaHeredia.setText("Heredia");
        jButtonGuardarMapaHeredia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarMapaHerediaActionPerformed(evt);
            }
        });

        jButtonGuardarMapaCartago.setText("Cartago");
        jButtonGuardarMapaCartago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarMapaCartagoActionPerformed(evt);
            }
        });

        jButtonGuardarMapaSanJose.setText("San Jose");
        jButtonGuardarMapaSanJose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarMapaSanJoseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVistaOpcionLayout = new javax.swing.GroupLayout(jPanelVistaOpcion);
        jPanelVistaOpcion.setLayout(jPanelVistaOpcionLayout);
        jPanelVistaOpcionLayout.setHorizontalGroup(
            jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVistaOpcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelVistaOpcionLayout.createSequentialGroup()
                        .addGroup(jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEmpezarRuta)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldIdRepatidor)
                            .addComponent(jTextFieldPuntoInicio)
                            .addComponent(jTextFieldPuntoDestino)
                            .addComponent(jButtonGuardarMapaHeredia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGuardarMapaCartago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGuardarMapaSanJose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelVistaOpcionLayout.setVerticalGroup(
            jPanelVistaOpcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVistaOpcionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIdRepatidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jTextFieldPuntoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPuntoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonEmpezarRuta)
                .addGap(90, 90, 90)
                .addComponent(jButtonGuardarMapaHeredia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGuardarMapaCartago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardarMapaSanJose)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jMenuArchivo.setText("Archivo");

        jMenuItemMapHeredia.setText("Cargar Mapa Heredia");
        jMenuItemMapHeredia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMapHerediaActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemMapHeredia);

        jMenuItemMapCartago.setText("Cargar Mapa Cartago");
        jMenuItemMapCartago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMapCartagoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemMapCartago);

        jMenuItemMapSanJose.setText("Cargar Mapa San Jose");
        jMenuItemMapSanJose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMapSanJoseActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemMapSanJose);

        jMenuBarraHerramienta.add(jMenuArchivo);

        jMenuAcercaDe.setText("Acerca De");
        jMenuBarraHerramienta.add(jMenuAcercaDe);

        setJMenuBar(jMenuBarraHerramienta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelVistaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
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

    private void jMenuItemMapHerediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMapHerediaActionPerformed
        control.cargarMapa("heredia");
        control.init();
        
        GraphPanel ptr = (GraphPanel) this.jPanelVistaMapa;
        ptr.insertarImagen(control.getUbicacionImagen());
        
        ptr.init();
     
    }//GEN-LAST:event_jMenuItemMapHerediaActionPerformed

    private void jButtonEmpezarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpezarRutaActionPerformed
        String id = this.jTextFieldIdRepatidor.getText();
        V inicio = (V) this.jTextFieldPuntoInicio.getText();
        V destino = (V) this.jTextFieldPuntoDestino.getText();

        control.add(id, inicio, destino);

        this.jTextFieldIdRepatidor.setName("");
        this.jTextFieldPuntoInicio.setName("");
        this.jTextFieldPuntoDestino.setName("");
    }//GEN-LAST:event_jButtonEmpezarRutaActionPerformed

    private void jButtonGuardarMapaHerediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarMapaHerediaActionPerformed
        control.guardarMapa("heredia");
    }//GEN-LAST:event_jButtonGuardarMapaHerediaActionPerformed

    private void jMenuItemMapCartagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMapCartagoActionPerformed
        control.cargarMapa("cartago");
         control.init();
        
        GraphPanel ptr = (GraphPanel) this.jPanelVistaMapa;
        ptr.insertarImagen(control.getUbicacionImagen());
        
        ptr.init();
    }//GEN-LAST:event_jMenuItemMapCartagoActionPerformed

    private void jMenuItemMapSanJoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMapSanJoseActionPerformed
        control.cargarMapa("sanjose");
         control.init();
        
        GraphPanel ptr = (GraphPanel) this.jPanelVistaMapa;
        ptr.insertarImagen(control.getUbicacionImagen());
        
        ptr.init();
    }//GEN-LAST:event_jMenuItemMapSanJoseActionPerformed

    private void jButtonGuardarMapaSanJoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarMapaSanJoseActionPerformed
//        control.guardarMapa("sanjose");
    }//GEN-LAST:event_jButtonGuardarMapaSanJoseActionPerformed

    private void jButtonGuardarMapaCartagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarMapaCartagoActionPerformed
//        control.guardarMapa("cartago");
    }//GEN-LAST:event_jButtonGuardarMapaCartagoActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEmpezarRuta;
    private javax.swing.JButton jButtonGuardarMapaCartago;
    private javax.swing.JButton jButtonGuardarMapaHeredia;
    private javax.swing.JButton jButtonGuardarMapaSanJose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenuAcercaDe;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBarraHerramienta;
    private javax.swing.JMenuItem jMenuItemMapCartago;
    private javax.swing.JMenuItem jMenuItemMapHeredia;
    private javax.swing.JMenuItem jMenuItemMapSanJose;
    private javax.swing.JPanel jPanelVistaMapa;
    private javax.swing.JPanel jPanelVistaOpcion;
    private javax.swing.JTextField jTextFieldIdRepatidor;
    private javax.swing.JTextField jTextFieldPuntoDestino;
    private javax.swing.JTextField jTextFieldPuntoInicio;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private controller<V,E> control;
}
