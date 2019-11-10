/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.graphs.Floyd;

import lists.List;
import lists.SimpleLinkedList;

/**
 *
 * @author Invitados1
 */
public class coleccionCamino {

    private List<camino> caminosPosibles;

    public coleccionCamino(List<camino> caminosPosibles) {
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

    @Override
    public String toString() {
        return caminosPosibles.toString();
    }

}
