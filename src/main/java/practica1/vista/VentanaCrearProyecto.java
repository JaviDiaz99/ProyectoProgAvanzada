package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearProyecto extends JFrame {
    VentanaCrearProyecto() { super(); }
    private void ejecuta() {
        crearVentana();
        crearComponentes();
    }
    private void crearVentana() {
        setVisible(true);
        setSize(500,300);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void crearComponentes() {
        Container contenedor = getContentPane();
        setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel();
        JLabel texto = new JLabel();
        JTextField recuadro = new JTextField(10);
        JButton boton1 = new JButton("Crear proyecto");
        texto.setText("Nombre proyecto:");
        texto.setBounds(50, 25, 200, 25);
        recuadro.setBounds(50, 50, 200, 25);
        boton1.setBounds(50, 75, 200, 30);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Codigo de  la ventana
            }
        });
        panel.add(texto);
        panel.add(boton1);
        panel.add(recuadro);
        contenedor.add(panel);
    }
    /*
    private void CentrarFrame() {
        setLocationRelativeTo(null);
        setVisible(true);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);
    }
    */

    public static void main( String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaCrearProyecto().ejecuta();
            }
        });
    }
}
