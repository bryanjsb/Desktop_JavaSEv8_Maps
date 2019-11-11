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
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import lists.Iterator;
import logica.graphs.Floyd.camino;
import logica.graphs.GVertex;
import logica.graphs.Graph;

public class repartidor {

    private String identificador;
    private camino caminoRepartidor;

    public repartidor(String identificador, camino caminoRepartidor) {
        this.identificador = identificador;
        this.caminoRepartidor = caminoRepartidor;
    }

    public repartidor() {
        this.identificador = "";
        this.caminoRepartidor = new camino();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public camino getCaminoRepartidor() {
        return caminoRepartidor;
    }

    public void setCaminoRepartidor(camino caminoRepartidor) {
        this.caminoRepartidor = caminoRepartidor;
    }

    @Override
    public String toString() {
        return "repartidor{" + "identificador=" + identificador + ", caminoRepartidor=" + caminoRepartidor + '}';
    }

    public void init() {

        new Thread() {

            @Override
            public void run() {
                GVertex v0 = caminoRepartidor.getVerticeInicio();
                Iterator<GVertex> i = caminoRepartidor.getRuta().getIterator();

                while (i.hasNext()) {
                    p0 = v0.getPosition();

                    GVertex v1 = i.getNext();
                    p1 = v1.getPosition();
                    t = 0.0;
                    while (t <= 1.0) {
                        t += DT;
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
        
        if (p0 != null) {
            g.setStroke(TRAZO_MARCADOR);
            g.setColor(Color.RED);

            Image bkgnd = null;
            try {
                bkgnd = ImageIO.read(getClass().getResourceAsStream("imaRepartidor/repartidor2.png"));
            } catch (IOException ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            }

            g.drawString(this.identificador, (int) ((p0.x + t * (p1.x - p0.x)) - S1 / 2),
                    (int) ((p0.y + t * (p1.y - p0.y)) - S1 / 2));
            g.drawImage(bkgnd, (int) ((p0.x + t * (p1.x - p0.x)) - S1 / 2),
                    (int) ((p0.y + t * (p1.y - p0.y)) - S1 / 2), null);

        }
    }

    public void update(Observable obs, Object evt) {
        throw new UnsupportedOperationException();
    }

    private static final Stroke TRAZO_MARCADOR = new BasicStroke(8f);
    private Point2D.Float p0;
    private Point2D.Float p1;
    private double t = 0.0;
    private static final int S1 = 56;
    private static final int MAX_WAIT = 25;
    private static final double DT = 0.035;
}
