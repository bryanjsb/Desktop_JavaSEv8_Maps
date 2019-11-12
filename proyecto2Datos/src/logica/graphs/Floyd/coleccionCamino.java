/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.graphs.Floyd;

import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

/**
 *
 * @author Priscilla
 */
public class coleccionCamino<V,E> {

    private List<camino<V,E>> caminosPosibles;

    public coleccionCamino(List<camino<V,E>> caminosPosibles) {
        this.caminosPosibles = caminosPosibles;
    }

    public coleccionCamino() {
        this(new SimpleLinkedList<>());
    }

    public void addFirst(camino camino) {
        if (camino != null) {
            caminosPosibles.addFirst(camino);
        }
    }

    public void addLast(camino camino) {
        if (camino != null) {
            caminosPosibles.addLast(camino);
        }
    }

    public List<camino<V,E>> getCaminosPosibles() {
        return caminosPosibles;
    }

    public camino<V,E> buscarRuta(V inicio, V llegada) {
        camino ptr = null;
        Iterator<camino<V,E>> i = caminosPosibles.getIterator();
        while (i.hasNext()) {
            ptr = i.getNext();
            if (ptr.verticeDestino.getInfo().toString().equals(llegada)
                    && ptr.verticeInicio.getInfo().toString().equals(inicio)) {
                System.out.println(ptr);
                break;
            }
        }
        return ptr;
    }

    @Override
    public String toString() {
        return caminosPosibles.toString();
    }

}
