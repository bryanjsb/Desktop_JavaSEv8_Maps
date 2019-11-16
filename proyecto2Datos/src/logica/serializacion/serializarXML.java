/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.serializacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import logica.mapa.mapa;

/**
 *
 * @author Bryan
 * @param <V>
 * @param <E>
 */
public class serializarXML<V, E> {

    public boolean guardar(mapa<V, E> mapa, String s) {
        boolean exito = false;
        String r = "./" + s + ".xml";
        try {
            // Instanciamos el contexto, indicando la clase que será el RootElement.
            JAXBContext jaxbContext = JAXBContext.newInstance(mapa.class);
            // Creamos un Marshaller, que es la clase capaz de convertir nuestro java bean
            // en una cadena XML
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // Indicamos que vamos a querer el XML con un formato amigable (saltos de linea,
            // sangrado, etc)
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Hacemos la conversión llamando al método marshal, pasando una instancia del java
            // bean que quermos convertir a XML y un OutpuStream donde queramos que salga el XML,
            // en esta caso, la salida estándar. Podría ser un fichero o cualquier otro Stream.
            jaxbMarshaller.marshal(mapa, System.out);

            OutputStream salida = null;
            try {
                salida = new FileOutputStream(r);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(serializarXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            jaxbMarshaller.marshal(mapa, salida);
        } catch (JAXBException ex) {
            Logger.getLogger(serializarXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exito;
    }

    public mapa<V, E> cargar(mapa<V, E> mapa, String s) throws FileNotFoundException, JAXBException {
        
        String archivoPrueba = "./" + s + ".xml";

        InputStream entrada =  new FileInputStream(archivoPrueba);
        JAXBContext context = JAXBContext.newInstance(mapa.class);
        Unmarshaller mar = context.createUnmarshaller();
        mapa map = (mapa) mar.unmarshal(entrada);
        
        return map;
    }

}
