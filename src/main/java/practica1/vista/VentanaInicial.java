package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicial extends JFrame {
    private VentanaInicial() {
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
        JButton boton1 = new JButton("Crear proyecto");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaCrearProyecto ventanaNueva = new VentanaCrearProyecto();
                // ventanaNueva.eje

            }
        });
        panel.add(boton1);
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
                new VentanaInicial().ejecuta();
            }
        });
    }

}
