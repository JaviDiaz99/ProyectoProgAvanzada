package practica1.vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private Ventana() {
        super();
    }
    private void ejecuta() {
        crearVentana();
    }

    private void crearVentana() {
        CentrarFrame();
        Container contenedor = getContentPane();
        JPanel panel = new JPanel();//Este panel contiene los componentes.
        panel.setLayout(new GridLayout(0,1,1,10));
        panel.add(new JButton("Crear proyecto"));
        panel.add(new JButton("Abrir proyecto"));
        contenedor.add(panel);
    }

    private void CentrarFrame() {
        setLocationRelativeTo(null);
        setVisible(true);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);
    }

    public static void main( String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().ejecuta();
            }
        });
    }

}
