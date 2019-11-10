/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.mapa;

import java.awt.geom.Point2D;
import lists.List;
import lists.SimpleArray;
import logica.graphs.Floyd.AlgoritmoFloydWarshall;
import logica.graphs.Floyd.camino;
import logica.graphs.Graph;

/**
 *
 * @author Bryan
 */
public class mapa<V, E> {

    Graph<V, E> grafo;
    private List<camino> caminosPosibles;

    public mapa() {
        grafo = new Graph<>();        
        this.caminosPosibles = new SimpleArray<>();
    }



       public mapa(Graph<V, E> grafo) {
        this.grafo=grafo;        
        this.caminosPosibles = new SimpleArray<>();
    }
    public void add(V v, Point2D.Float position) {
        grafo.add(v, position);
    }

    public void add(V v) {
        grafo.add(v);
    }

    public void add(V t, V h, E w) {
        add(t, h, w);
    }

    public void add(V t, V h) {
        add(t, h);
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
