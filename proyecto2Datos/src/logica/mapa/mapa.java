/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.mapa;

import java.awt.geom.Point2D;
import logica.graphs.Floyd.AlgoritmoFloydWarshall;
import logica.graphs.Floyd.coleccionCamino;
import logica.graphs.Graph;
import logica.repartidor.coleccionRepartidor;
import logica.repartidor.repartidor;

/**
 *
 * @author Bryan
 */
public class mapa<V, E> {

    private final Graph<V, E> grafo;
    private coleccionCamino caminosPosibles;
    private coleccionRepartidor colRepartidor;

    public mapa() {
        grafo = new Graph<>();
        this.caminosPosibles = new coleccionCamino();
        colRepartidor = new coleccionRepartidor();
    }

    public mapa(Graph<V, E> grafo) {
        this.grafo = grafo;
        this.caminosPosibles = new coleccionCamino();
        colRepartidor = new coleccionRepartidor();
    }

    public void add(V v, Point2D.Float position) {
        grafo.add(v, position);
    }

    public void add(V v) {
        grafo.add(v);
    }

    public void add(V t, V h, E w) {
        grafo.add(t, h, w);
    }

    public void add(V t, V h) {
        grafo.add(t, h);
    }

    public void add(repartidor repartidor) {
        if (repartidor != null) {
            colRepartidor.add(repartidor);
        }
    }

    private void crearRepartidores() {
        repartidor ptr = new repartidor();
    }

    public Graph<V, E> getGrafo() {
        return grafo;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        return s.toString();
    }

    public void calcularRutasMinimas() {
        AlgoritmoFloydWarshall floyd = new AlgoritmoFloydWarshall();
        this.caminosPosibles = floyd.algoritmoFloydWarshall(grafo);
    }
}
