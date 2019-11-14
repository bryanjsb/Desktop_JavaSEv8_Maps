/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.serializacion;

import java.io.File;
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

    public boolean guardar(mapa<V, E> mapa) {
        boolean exito = false;
        String archivoPrueba = "/archivoXML/mapa1.xml";
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
//            jaxbMarshaller.marshal(mapa, new File(archivoPrueba));
        } catch (JAXBException ex) {
            Logger.getLogger(serializarXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exito;
    }

    public boolean cargar() {
        boolean exito = false;
        String archivoPrueba = "/archivoXML/mapa1.xml";
        try {
            File f = new File(archivoPrueba);
            if (f.exists()) {
                JAXBContext ctx = JAXBContext.newInstance(mapa.class);
                Unmarshaller mrs = ctx.createUnmarshaller();
                mapa map = (mapa) mrs.unmarshal(f);
                System.out.println(map);
                exito = true;
            } else {
                System.err.printf("No existe el archivo de prueba: '%s'%n", archivoPrueba);
            }
        } catch (JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        return exito;
    }

}
