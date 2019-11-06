/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.graphs.Floyd;

import java.util.Arrays;
import logica.graphs.GVertex;

/**
 *
 * @author Bryan
 */
public class camino {

    int verticeInicio;
    int verticeDestino;
    double peso;
    int[] ruta;

    public camino(int verticeInicio, int verticeDestino, double peso, int[] ruta) {
        this.verticeInicio = verticeInicio;
        this.verticeDestino = verticeDestino;
        this.peso = peso;
        this.ruta = ruta;
    }

    public camino() {
        this(0, 0, 0.0, null);
    }

    public int getVerticeInicio() {
        return verticeInicio;
    }

    public void setVerticeInicio(int verticeInicio) {
        this.verticeInicio = verticeInicio;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(int verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int[] getRuta() {
        return ruta;
    }

    public void setRuta(int[] ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return verticeInicio + "->" + verticeDestino
                + "    " + peso + "       " + Arrays.toString(ruta) + " \n ";
    }
}
