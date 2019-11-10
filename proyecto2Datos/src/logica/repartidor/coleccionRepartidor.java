/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.repartidor;

import lists.List;
import lists.SimpleArray;

/**
 *
 * @author Invitados1
 */
public class coleccionRepartidor {

    List<repartidor> coleccionRepartidor;

    public coleccionRepartidor() {
        coleccionRepartidor = new SimpleArray<>();
    }

    public void add(repartidor repartidor) {
        if (repartidor != null) {
            coleccionRepartidor.addLast(repartidor);
        }
    }

}
