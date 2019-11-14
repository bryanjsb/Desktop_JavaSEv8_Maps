/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.graphs.Floyd;

import lists.Iterator;
import lists.SimpleLinkedList;
import logica.graphs.GVertex;

/**
 *
 * @author Priscilla
 */
public class coleccionCamino<V, E> {

    private SimpleLinkedList<camino<V, E>> caminosPosibles;

    public coleccionCamino(SimpleLinkedList<camino<V, E>> caminosPosibles) {
        this.caminosPosibles = caminosPosibles;
    }

    public coleccionCamino() {
        this(new SimpleLinkedList<>());
    }

    public void addFirst(camino<V, E> camino) {
        if (camino != null) {
            caminosPosibles.addFirst(camino);
        }
    }

    public void addLast(camino<V, E> camino) {
        if (camino != null) {
            caminosPosibles.addLast(camino);
        }
    }

    public void addLast(GVertex<V> verticeInicio, GVertex<V> verticeDestino,
            E peso, SimpleLinkedList<GVertex<V>> ruta) {
        addLast(new camino<V, E>(verticeInicio, verticeDestino, peso, ruta));

    }

    public SimpleLinkedList<camino<V, E>> getCaminosPosibles() {
        return caminosPosibles;
    }

    public camino<V, E> buscarRuta(V inicio, V llegada) {
        camino ptr = null;
        Iterator<camino<V, E>> i = caminosPosibles.getIterator();
        while (i.hasNext()) {
            ptr = i.getNext();
            if (ptr.verticeDestino.getInfo().toString().equals(llegada)
                    && ptr.verticeInicio.getInfo().toString().equals(inicio)) {
                break;
            }
        }
        return ptr;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<camino<V, E>> i = caminosPosibles.getIterator();

        while (i.hasNext()) {
            camino<V, E> ptr = i.getNext();

            s.append(String.format("%s%n", ptr.toString()));
        }

        return s.toString();
    }

}
