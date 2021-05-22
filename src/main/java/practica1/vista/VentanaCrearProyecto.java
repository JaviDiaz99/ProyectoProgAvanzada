package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearProyecto extends JFrame {
    private Controlador controlador;
    VentanaCrearProyecto() { super(); }
    public void ejecuta() {
        crearVentana();
        crearComponentes();
    }
    private void crearVentana() {
        setVisible(true);
        setSize(500,80);
        setLocationRelativeTo(null);
        setResizable(false);
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
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.getDatosCrearProyecto(recuadro);
                new VentanaMenuOpciones().ejecuta();
                dispose();
            }
        });
        panel.add(texto);
        panel.add(recuadro);
        panel.add(boton1);
        contenedor.add(panel);
    }

    public static void main( String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaCrearProyecto().ejecuta();
            }
        });
    }
}
