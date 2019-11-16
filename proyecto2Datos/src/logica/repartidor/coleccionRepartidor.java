/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.repartidor;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Invitados1
 */
public class coleccionRepartidor<V, E> {

    LinkedList<repartidor<V, E>> coleccionRepartidor;

    public LinkedList<repartidor<V, E>> getColeccionRepartidor() {
        return coleccionRepartidor;
    }

    public coleccionRepartidor() {
        coleccionRepartidor = new LinkedList<>();
    }

    public void add(repartidor<V, E> repartidor) {

        if (repartidor != null) {
            coleccionRepartidor.addLast(repartidor);
        } else {
            System.err.printf("Excepción: no se puede agregar");
        }

    }

    public void init() {
        Iterator<repartidor<V, E>> i = coleccionRepartidor.iterator();
        while (i.hasNext()) {
            i.next().init();
        }
    }

    public void paint(Graphics bg, Rectangle bounds) {

        Iterator<repartidor<V, E>> i = coleccionRepartidor.iterator();
        while (i.hasNext()) {
            i.next().paint(bg, bounds);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<repartidor<V, E>> i = coleccionRepartidor.iterator();
        while (i.hasNext()) {
            s.append(String.format("%s%n", i.next().toString()));
        }
        return s.toString();
    }

}
