/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.graphs.Floyd;

import java.util.Arrays;
import logica.graphs.GVertex;
import sun.security.provider.certpath.Vertex;

/**
 *
 * @author Bryan
 */
public class camino<V> {

    GVertex<V> verticeInicio;
    GVertex<V> verticeDestino;
    double peso;
    GVertex<V>[] ruta;

    public camino(GVertex<V> verticeInicio, GVertex<V> verticeDestino, double peso, GVertex<V>[] ruta) {
        this.verticeInicio = verticeInicio;
        this.verticeDestino = verticeDestino;
        this.peso = peso;
        this.ruta = ruta;
    }

    public camino() {
        this(null, null, .0, null);
    }

    public GVertex<V> getVerticeInicio() {
        return verticeInicio;
    }

    public void setVerticeInicio(GVertex<V> verticeInicio) {
        this.verticeInicio = verticeInicio;
    }

    public GVertex<V> getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(GVertex<V> verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public GVertex<V>[] getRuta() {
        return ruta;
    }

    public void setRuta(GVertex<V>[] ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return verticeInicio + "->" + verticeDestino
                + "    " + peso + "       " + Arrays.toString(ruta) + " \n ";
    }
}
