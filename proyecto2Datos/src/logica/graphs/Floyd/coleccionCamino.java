/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.graphs.Floyd;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import logica.graphs.GVertex;

/**
 *
 * @author Priscilla
 */
public class coleccionCamino<V, E> {

    private LinkedList<camino<V, E>> caminosPosibles;

    public coleccionCamino(LinkedList<camino<V, E>> caminosPosibles) {
        this.caminosPosibles = caminosPosibles;
    }

    public coleccionCamino() {
        this(new LinkedList<>());
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
            E peso, LinkedList<GVertex<V>> ruta) {
        addLast(new camino<V, E>(verticeInicio, verticeDestino, peso, ruta));

    }

    public LinkedList<camino<V, E>> getCaminosPosibles() {
        return caminosPosibles;
    }

    public camino<V, E> buscarRuta(V inicio, V llegada) {
        camino<V, E> ptr = null;
        boolean exito = false;
        for (camino<V, E> i : caminosPosibles) {

            ptr = i;
            if (ptr.verticeDestino.getInfo().toString().equals(llegada)
                    && ptr.verticeInicio.getInfo().toString().equals(inicio)) {
                exito = true;
                break;
            }
        }

        if (!exito) {
            JOptionPane.showMessageDialog(null, "intente con otro rango");
            ptr = new camino<>();
        }

        return ptr;
    }

    public void limpiarLista(){
        caminosPosibles.clear();
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (camino<V, E> i : caminosPosibles) {
            s.append(String.format("%s%n", i.toString()));
        }

        return s.toString();
    }

}
