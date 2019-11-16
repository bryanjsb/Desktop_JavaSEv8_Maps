/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observer;
import logica.mapa.mapa;
import logica.mapa.model;

/**
 *
 * @author Bryan
 * @param <V>
 * @param <E>
 */
public class controller<V,E> {
    
    
    private model<V, E>  model;

    public controller(model<V, E> model) {
        this.model = model;
    }
    
    public controller() {
       this(new model<V,E>());
    }
    
    public void registrar(Observer o){
        this.model.addObserver(o);
    }
    
     public void setMapa(mapa<V, E> mapa){
        this.model.setMapa(mapa);
    }
     
     public void guardarMapa(String s){
         model.guardarMapa(s);
     }
    
     public void cargarMapa(String s) {
         model.cargarMapa(s);
     }
     
      public void setImagen(String s){
      model.setImagen(s);
      }
      
      public String getUbicacionImagen(){
          return model.getUbicacionImagen();
      }
      
      public void init(){
          model.init();
          System.out.println(this);
      }
      
      public void add(String id, V inicio, V destino){
          model.add(id, inicio, destino);
      }
      
      public void paint(Graphics bg, Rectangle bounds){
          model.paint(bg, bounds);
      }
      
       @Override
    public String toString(){
        return model.toString();
    }
}
