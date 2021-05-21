package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAñadirPersonaTarea extends JFrame {
    VentanaAñadirPersonaTarea() { super(); }
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
        JLabel texto2 = new JLabel();
        JTextField recuadroPersona = new JTextField(10);
        JTextField recuadroTarea = new JTextField(10);
        JButton boton1 = new JButton("Añadir");
        texto.setText("Nombre persona:");
        texto.setText("Título de tarea:");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        panel.add(texto);
        panel.add(recuadroPersona);
        panel.add(boton1);
        panel.add(texto2);
        panel.add(recuadroTarea);
        panel.add(boton1);
        contenedor.add(panel);
    }

    public static void main( String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaAñadirPersonaTarea().ejecuta();
            }
        });
    }
}
