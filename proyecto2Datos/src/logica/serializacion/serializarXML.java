/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.serializacion;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Bryan
 */
public class serializarXML implements Iserializacion {

    @Override
    public boolean guardar() {
        boolean exito=false;
//          String archivoPrueba = "../mapa1.xml";
//        try {
//            File f = new File(archivoPrueba);
//            if (f.exists()) {
//                JAXBContext ctx = JAXBContext.newInstance(Graph.class);
//                Unmarshaller mrs = ctx.createUnmarshaller();
//                Graph g = (Graph) mrs.unmarshal(f);
//                System.out.println(g);
//                exito=true;
//            } else {
//                System.err.printf("No existe el archivo de prueba: '%s'%n", archivoPrueba);
//            }
//        } catch (JAXBException ex) {
//            System.err.printf("Excepción: '%s'%n", ex.getMessage());
//        }
        
        return exito;
    }

    @Override
    public boolean cargar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
