package principal;

import vista.VentanaEjemplo;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class principal {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        principal p=new principal();
        p.inicializar();
    }

    public void inicializar() {
        SwingUtilities.invokeLater(() -> {
            new VentanaEjemplo("Ejemplo G0").init();
        });
    }

}
