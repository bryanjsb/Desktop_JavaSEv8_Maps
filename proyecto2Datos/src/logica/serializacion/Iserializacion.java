/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.serializacion;

import logica.mapa.mapa;

/**
 *
 * @author Bryan
 * @param <V>
 * @param <E>
 */
public interface Iserializacion<V, E> {

    public boolean guardar(mapa<V, E> mapa);

    public boolean cargar();

}
