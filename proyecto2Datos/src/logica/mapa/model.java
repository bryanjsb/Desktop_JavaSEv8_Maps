/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.mapa;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Bryan
 */
public class model<V, E> extends Observable {

    private mapa<V, E> mapa;

    public model(mapa<V, E> mapa) {
        this.mapa = mapa;
    }

    public model() {
        this(new mapa<V, E>());
    }

    public void setMapa(mapa<V, E> mapa){
        this.mapa = mapa;
        refrescar();
    }
    
    private void refrescar() {
        setChanged();
        notifyObservers();
    }

    public void guardarMapa(String s) {
        mapa.guardarMapa(s);
    }

    public void cargarMapa(String s) {
        try {
            mapa=mapa.cargarMapa(s);
        } catch (FileNotFoundException | JAXBException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }
        refrescar();
    }
    
    public void setImagen(String s){
        mapa.setUbicacionImagen(s);
    }
    
    public String getUbicacionImagen(){
        return mapa.getUbicacionImagen();
    }
    
    public void init(){
        mapa.init();
        refrescar();
    }
    
    public void add(String id, V inicio, V destino){
        mapa.add(id, inicio, destino);
    }
    
    public void paint(Graphics bg, Rectangle bounds){
    mapa.paint(bg, bounds);
    }
    
    @Override
    public String toString(){
        return mapa.toString();
    }
}
