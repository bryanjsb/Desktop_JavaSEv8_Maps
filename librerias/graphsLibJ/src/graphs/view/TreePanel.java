package graphs.view;

import graphs.Vertex;
import graphs.Tree;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import lists.AbstractList;
import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

public class TreePanel<V> extends JPanel implements Observer {

    public TreePanel(boolean showingGuides, Color background, Color foreground, Tree<V> bt) {
        this.showingGuides = showingGuides;
        this.background = background;
        this.foreground = foreground;
        this.scaleFactor = 1f;
        this.verticalSpacing = 24f;
        this.bt = bt;

        setup();
    }

    public TreePanel(Color background, Color foreground, Tree<V> bt) {
        this(false, background, foreground, bt);
    }

    private void setup() {
        setBackground(background);
        setCursor(new Cursor(Cursor.MOVE_CURSOR));

        MouseAdapter m = new MouseAdapter() {
            @Override

            public void mouseDragged(MouseEvent e) {
                if (origin != null) {
                    JViewport viewPort = (JViewport) 
                            SwingUtilities.getAncestorOfClass(JViewport.class, TreePanel.this);
                    if (viewPort != null) {
                        int deltaX = origin.x - e.getX();
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.x += deltaX;
                        view.y += deltaY;

                        scrollRectToVisible(view);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                origin = e.getPoint();
            }

            private Point origin = null;
        };

        addMouseListener(m);
        addMouseMotionListener(m);
    }

    public TreePanel(Tree bt) {
        this(DEFAULT_BACKGROUND, DEFAULT_FOREGROUND, bt);
    }

    @Override
    public void paintComponent(Graphics bg) {
        super.paintComponent(bg);
        Graphics2D g = (Graphics2D) bg;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        double cellWidth = CELL_WIDTH * scaleFactor;
        double cellHeight = CELL_HEIGHT * scaleFactor;

        // Dimensiones del árbol (definido por la cantidad de celdas)
        // bw : número horizontal de celdas (columnas)
        // bh : número vertical de celdas (filas)
        //
        int bw = bt.getWidth();
        int bh = bt.getHeight() + 1;

        // Dimensiones del árbol (área de dibujo)
        //
        int w = (int) (cellWidth * bw);
        int h = (int) (cellHeight * bh + verticalSpacing * scaleFactor * (bh - 1));

        paintGuides(g, bw, bh, (int) cellWidth, (int) cellHeight, w, h);

        int fontSize = (int) (cellHeight * FONT_SIZE_RATIO);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
        FontMetrics fm = g.getFontMetrics();

        // Encuentra la posicion de cada vértice y0 dibuja los arcos
        // entre cada uno.
        //
        AbstractList<PaintableVertex<V>> vertices = new SimpleLinkedList<>();
        locateVertex(g, vertices, (Vertex<V>) bt.getRoot(), fm, cellWidth, cellHeight,
                new Rectangle(MARGIN, MARGIN, w, (int) cellHeight));

        // Recorre la lista de vértice por dibujar según las posiciones
        // calculadas en el método anterior.
        //
        Iterator<PaintableVertex<V>> i = vertices.getIterator();
        while (i.hasNext()) {
            PaintableVertex<V> current = i.getNext();
            paintVertex(g, current.loc, cellWidth, cellHeight, current.v, fm);
        }

        setPreferredSize(new Dimension(w + 2 * MARGIN, h + 2 * MARGIN));
    }

    /**
     *
     * @param g Contexto gráfico
     * @param bw Número de columnas
     * @param bh Número de filas
     * @param cellWidth Ancho de la celda (píxels)
     * @param cellHeight Altura de la celda (píxels)
     * @param w Ancho del área de dibujo
     * @param h Altura del área de dibujo
     */
    private void paintGuides(Graphics2D g, int bw, int bh, int cellWidth, int cellHeight, int w, int h) {
        if (isShowingGuides()) {

            g.setStroke(GUIDE_STROKE);
            g.setColor(GUIDE_COLOR);

            for (int i = 0; i < bh; i++) {
                int y0 = (int) (i * (cellHeight + verticalSpacing * scaleFactor));
                g.drawLine(MARGIN, MARGIN + y0,
                        MARGIN + w, MARGIN + y0
                );
                if ((verticalSpacing > 0) && (i < (bh - 1))) {
                    int y1 = (int) ((i + 1) * cellHeight + i * verticalSpacing * scaleFactor);
                    g.drawLine(MARGIN, MARGIN + y1,
                            MARGIN + w, MARGIN + y1
                    );
                }
            }
            for (int j = 0; j < bw; j++) {
                int x = j * cellWidth;
                g.drawLine(
                        MARGIN + x, MARGIN,
                        MARGIN + x, (int) (MARGIN + h + verticalSpacing * (bh - 2))
                );
            }
            g.drawRect(MARGIN, MARGIN, w, (int) (h + verticalSpacing * scaleFactor * (bh - 2)));
        }
    }

    /**
     *
     * @param g Contexto gráfico
     * @param vertices Lista de vértices (para indicar sus posiciones)
     * @param current Vértice actual examinado
     * @param fm Métrica para el cálculo de las dimensiones del texto
     * @param cellWidth Ancho de la celda
     * @param cellHeight Altura de la celda
     * @param vb Rectángulo que inscribe al vértice
     */
    private void locateVertex(Graphics2D g, AbstractList<PaintableVertex<V>> vertices, Vertex<V> current, FontMetrics fm,
            double cellWidth, double cellHeight, Rectangle vb) {
        int cx = vb.x + vb.width / 2;
        int cy = vb.y + vb.height / 2;

        if (isShowingGuides()) {
            g.setStroke(GUIDE_STROKE);
            g.setColor(Color.RED);

            g.drawRect(vb.x, vb.y, vb.width, vb.height);
            g.drawLine(cx - 4, cy, cx + 4, cy);
            g.drawLine(cx, cy - 4, cx, cy + 4);
        }

        vertices.addLast(new PaintableVertex<>(current, new Point2D.Float(cx, cy)));

        // Obtiene la lista de sucesores del vértice y0
        // calcula el ancho relativo de cada subárbol para ajustar el
        // área de dibujo para cada uno.
        //
        if (!current.getChildren().isEmpty()) {
            List<Vertex<V>> succv = current.getChildren();

            double[] r = new double[succv.count()];
            double tw = 0.0;
            int k = 0;

            // System.out.println("Calculando anchos relativos..");
            Iterator<Vertex<V>> i;
            i = succv.getIterator();
            while (i.hasNext()) {
                tw += r[k++] = i.getNext().getWidth();
            }
            for (int j = 0; j < r.length; j++) {
                r[j] /= tw;
            }

            // Dibuja cada uno de los subárboles comenzando en el
            // área inmediata inferior.
            //
            i = succv.getIterator();
            int j = 0;
            double dx = 0;
            while (i.hasNext()) {
                Rectangle nr = new Rectangle(
                        (int) (vb.x + dx * vb.width),
                        (int) (vb.y + vb.height + verticalSpacing * scaleFactor),
                        (int) (r[j] * vb.width),
                        vb.height);

                if (isShowingGuides()) {
                    Font bf = g.getFont();

                    int fontSize = (int) (cellHeight * FONT_SIZE_RATIO * 0.7);
                    g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
                    FontMetrics fm2 = g.getFontMetrics();

                    String tr = String.format("%5.3f", r[j]);
                    float tx = nr.x + (nr.width - fm2.stringWidth(tr)) * 0.5f;
                    float ty = nr.y - 4;
                    g.drawString(tr, tx, ty);
                    g.setFont(bf);
                }

                g.setStroke(new BasicStroke(Math.max(1f, LINK_STROKE_WEIGHT * scaleFactor)));
                g.setColor(background.darker().darker());
                g.drawLine(
                        cx, cy,
                        nr.x + nr.width / 2,
                        nr.y + nr.height / 2
                );

                locateVertex(g, vertices, (Vertex<V>) i.getNext(), fm, cellWidth, cellHeight, nr);
                dx += r[j];
                j++;
            }
        }
    }

    /**
     *
     * @param g Contexto gráfico
     * @param loc Posición (centro) del vértice actual
     * @param cellWidth Ancho de la celda
     * @param cellHeight Altura de la celda
     * @param current Vértice actual por dibujar
     * @param fm Métrica para el cálculo de las dimensiones del texto
     */
    private void paintVertex(Graphics2D g, Point2D.Float loc, double cellWidth, double cellHeight, Vertex<V> current, FontMetrics fm) {
        g.setStroke(new BasicStroke(Math.max(1f, SHAPE_STROKE * scaleFactor)));
        g.setColor(background.darker());
        g.fillRoundRect(
                (int) (loc.x - 0.5 * (VERTEX_WIDTH_RATIO * cellWidth) + SHADOW_OFFSET * scaleFactor),
                (int) (loc.y - 0.5 * (VERTEX_HEIGHT_RATIO * cellHeight) + SHADOW_OFFSET * scaleFactor),
                (int) (VERTEX_WIDTH_RATIO * cellWidth), (int) (VERTEX_HEIGHT_RATIO * cellHeight),
                CORNER_RADIUS, CORNER_RADIUS);
        g.setColor(foreground);
        g.fillRoundRect(
                (int) (loc.x - 0.5 * (VERTEX_WIDTH_RATIO * cellWidth)),
                (int) (loc.y - 0.5 * (VERTEX_HEIGHT_RATIO * cellHeight)),
                (int) (VERTEX_WIDTH_RATIO * cellWidth), (int) (VERTEX_HEIGHT_RATIO * cellHeight),
                CORNER_RADIUS, CORNER_RADIUS);
        g.setColor(Color.BLACK);
        g.drawRoundRect(
                (int) (loc.x - 0.5 * (VERTEX_WIDTH_RATIO * cellWidth)),
                (int) (loc.y - 0.5 * (VERTEX_HEIGHT_RATIO * cellHeight)),
                (int) (VERTEX_WIDTH_RATIO * cellWidth), (int) (VERTEX_HEIGHT_RATIO * cellHeight),
                CORNER_RADIUS, CORNER_RADIUS);

        g.setColor(Color.BLACK);
        String e = current.getInfo().toString();
        if (e.length() > MAX_STRING_LENGTH) {
            e = e.substring(0, MAX_STRING_LENGTH - 3) + "...";
        }
        g.drawString(e,
                loc.x - 0.5f * fm.stringWidth(e),
                loc.y + 0.5f * fm.getAscent());
    }

    @Override
    public void update(Observable obs, Object evt) {
        repaint();
        revalidate();
    }

    public boolean isShowingGuides() {
        return showingGuides;
    }

    public void setShowingGuides(boolean showingGuides) {
        this.showingGuides = showingGuides;
        repaint();
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
        repaint();
        revalidate();
    }

    public float getSpacing() {
        return verticalSpacing;
    }

    public void setSpacing(float verticalSpacing) {
        this.verticalSpacing = verticalSpacing;
        repaint();
        revalidate();
    }

    private static final int CELL_WIDTH = 96;
    private static final int CELL_HEIGHT = 72;
    private static final Color DEFAULT_BACKGROUND = new Color(236, 236, 255);
    private static final Color DEFAULT_FOREGROUND = new Color(255, 236, 128);

    private static final int MARGIN = 24;
    private static final int SHADOW_OFFSET = 4;
    private static final int CORNER_RADIUS = 12;
    private static final double FONT_SIZE_RATIO = 0.25;
    private static final int MAX_STRING_LENGTH = 8;
    private static final double VERTEX_WIDTH_RATIO = 0.80;
    private static final double VERTEX_HEIGHT_RATIO = 0.50;

    private static final Color GUIDE_COLOR = Color.GRAY;
    private static final float[] DASHES = {4f, 4f};
    private static final Stroke GUIDE_STROKE = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, DASHES, 0f);
    private static final float LINK_STROKE_WEIGHT = 2.0f;
    private static final float SHAPE_STROKE = 1.5f;

    private boolean showingGuides;
    private Color background;
    private Color foreground;
    private float scaleFactor;
    private float verticalSpacing;

    private Tree<V> bt;

    class PaintableVertex<V> {

        public PaintableVertex(Vertex<V> v, Point2D.Float loc) {
            this.v = v;
            this.loc = loc;
        }

        Vertex<V> v;
        Point2D.Float loc;

    }
}
