package logica.repartidor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import logica.graphs.Edge;
import logica.graphs.floyd.camino;
import logica.graphs.GVertex;
import logica.graphs.Graph;

public class repartidor<V, E> {

    private String identificador;
    private camino<V, E> caminoRepartidor;
    private String ubicacionParcialImagen;
    private final int cantidadImagen = 4;
    private Color color;
    Image bkgnd = null;
    Image ini;
    Image fin;

    public repartidor(String identificador, camino<V, E> caminoRepartidor) {
        this.identificador = identificador;
        this.caminoRepartidor = caminoRepartidor;
        Random r = new Random();
        int valorDado = r.nextInt(cantidadImagen) + 1;
        ubicacionParcialImagen = "/ima/imaRepartidor/repartidor" + valorDado + ".png";
        iniciarImagen();
        color = colorRepartidor();
    }

    public void aumentarPesos(Graph<V, E> grafo) {

        if (this.caminoRepartidor.getRuta() != null) {
            Iterator<GVertex<V>> i = this.caminoRepartidor.getRuta().iterator();
            GVertex<V> primero = i.next();
            GVertex<V> siguiente = null;
            while (i.hasNext()) {
                siguiente = i.next();

                Edge ed = grafo.getEdge(primero.getInfo(), siguiente.getInfo());

                if (ed != null) {
                    double peso = 
                            new Random().nextInt(100) +1+
                            Double.parseDouble(ed.getInfo().toString());
                    peso += new Random().nextDouble();
                    String num = String.format("%.2f", peso);
                    ed.setInfo((num));
                    System.out.println(ed);
                }
//            if(siguiente!=null){
                primero = siguiente;
//            }else{break;}
            }
        }
    }

    private void iniciarImagen() {

        try {
            bkgnd = ImageIO.read(getClass().getResourceAsStream(ubicacionParcialImagen));
            ini = ImageIO.read(getClass().getResourceAsStream("/ima/inicio.png"));
            fin = ImageIO.read(getClass().getResourceAsStream("/ima/final.png"));
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Color colorRepartidor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    public repartidor() {
        this("", new camino());
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public camino<V, E> getCaminoRepartidor() {
        return caminoRepartidor;
    }

    public void setCaminoRepartidor(camino<V, E> caminoRepartidor) {
        this.caminoRepartidor = caminoRepartidor;
    }

    @Override
    public String toString() {
        return "repartidor" + " id: " + identificador + " camino establecido " + caminoRepartidor;
    }

    public void init() {

        if (caminoRepartidor.getRuta() != null) {
            init(caminoRepartidor.getVerticeInicio());
        }
    }

    public void init(GVertex<V> pathStart) {

        new Thread() {
            @Override
            public void run() {
                GVertex<V> v0 = pathStart;
                LinkedList<GVertex<V>> vs = caminoRepartidor.getRuta();

                for (GVertex<V> i : vs) {

                    p0 = v0.getPosition();

                    // Se define el criterio para seleccionar
                    // el siguiente vértice.
                    GVertex<V> v1 = i;
                    p1 = v1.getPosition();

//                    System.out.printf("v(%s): %s%n", v0.getInfo(), p0);
//                    System.out.printf("v(%s): %s%n", v1.getInfo(), p1);
                    t = 0.0;

                    float dx = p1.x - p0.x;
                    float dy = p1.y - p0.y;
                    double dm = Math.sqrt(dx * dx + dy * dy);
                    double dt = DR / dm;

                    while (t <= 1.0) {
                        t += dt;
                        try {
                            Thread.sleep(MAX_WAIT);
                        } catch (InterruptedException ex) {
                        }
                    }
                    v0 = v1;
                }
            }

        }.start();

    }

    public void paint(Graphics bg, Rectangle bounds) {

        Graphics2D g = (Graphics2D) bg;

        if (this.caminoRepartidor.getRuta() != null) {
            Iterator<GVertex<V>> i = this.caminoRepartidor.getRuta().iterator();
            GVertex<V> tail = i.next();
            while (i.hasNext()) {

                GVertex<V> head = i.next();
                /*dibuja el trazo que une cada vertice*/
                g.setStroke(TRAZO_BASE);
                g.setColor(color.brighter());
                g.drawLine(
                        (int) tail.getPosition().x,
                        (int) tail.getPosition().y,
                        (int) head.getPosition().x,
                        (int) head.getPosition().y
                );

                /*Dibuja una linea al centro del trazo que une cada vertice*/
//            g.setStroke(new BasicStroke(1f));
//            g.setColor(Color.BLACK);
//           g.drawLine(
//                    (int) tail.getPosition().x,
//                    (int) tail.getPosition().y,
//                    (int) head.getPosition().x,
//                    (int) head.getPosition().y
//            );
//           
                tail = head;
            }
            if (p0 != null) {
                g.setStroke(TRAZO_MARCADOR);
                g.setColor(color);

                g.drawString(this.identificador, (int) ((p0.x + t * (p1.x - p0.x)) - S1 / 2),
                        (int) ((p0.y + t * (p1.y - p0.y)) - S1 / 2));
                g.drawImage(bkgnd, (int) ((p0.x + t * (p1.x - p0.x)) - S1 / 2),
                        (int) ((p0.y + t * (p1.y - p0.y)) - S1 / 2), null);

            }

            g.drawImage(ini, (int) caminoRepartidor.getVerticeInicio().getPosition().x,
                    (int) caminoRepartidor.getVerticeInicio().getPosition().y, null);

            g.drawImage(fin, (int) caminoRepartidor.getVerticeDestino().getPosition().x,
                    (int) caminoRepartidor.getVerticeDestino().getPosition().y, null);
        }
    }

    public void update(Observable obs, Object evt) {
        throw new UnsupportedOperationException();
    }

    private static final Stroke TRAZO_BASE
            = new BasicStroke(12f,
                    BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0f, null, 0f);
    private static final Stroke TRAZO_MARCADOR = new BasicStroke(8f);
    private Point2D.Float p0;
    private Point2D.Float p1;
    private double t = 0.0;
    private static final int S1 = 56;
    private static final int MAX_WAIT = 25;
    private static final double DT = 0.035;

    private static final double DR = 4.0;
}
