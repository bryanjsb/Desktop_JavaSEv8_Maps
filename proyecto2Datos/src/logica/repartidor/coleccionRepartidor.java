/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.repartidor;

import java.awt.Graphics;
import java.awt.Rectangle;
import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

/**
 *
 * @author Invitados1
 */
public class coleccionRepartidor<V, E> {

    List<repartidor<V, E>> coleccionRepartidor;

    public List<repartidor<V, E>> getColeccionRepartidor() {
        return coleccionRepartidor;
    }

    public coleccionRepartidor() {
        coleccionRepartidor = new SimpleLinkedList<>();
    }

    public void add(repartidor<V, E> repartidor) {
        if (repartidor != null) {
            coleccionRepartidor.addLast(repartidor);
        }
    }

    public void init() {
        Iterator<repartidor<V, E>> i = coleccionRepartidor.getIterator();
        while (i.hasNext()) {
            i.getNext().init();
        }
    }

    public void paint(Graphics bg, Rectangle bounds) {

        Iterator<repartidor<V, E>> i = coleccionRepartidor.getIterator();
        while (i.hasNext()) {
            i.getNext().paint(bg, bounds);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<repartidor<V, E>> i = coleccionRepartidor.getIterator();
        while (i.hasNext()) {
            s.append(String.format("%s%n", i.getNext().toString()));
        }
        return s.toString();
    }

}
