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
public class coleccionRepartidor {

    List<repartidor> coleccionRepartidor;

    public coleccionRepartidor() {
        coleccionRepartidor = new SimpleLinkedList<>();
    }

    public void add(repartidor repartidor) {
        if (repartidor != null) {
            coleccionRepartidor.addLast(repartidor);
        }
    }

    
    public void paint(Graphics bg, Rectangle bounds) {
         
        Iterator<repartidor> i;
        i = coleccionRepartidor.getIterator();
        while(i.hasNext()){
            repartidor ptr=i.getNext();
            ptr.paint(bg, bounds);
        }}
}
