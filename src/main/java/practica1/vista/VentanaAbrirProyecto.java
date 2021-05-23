package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaAbrirProyecto extends JFrame   {
    private Controlador controlador;
    private JTextField recuadro;
    VentanaAbrirProyecto() {
        super();
    }
    public void ejecuta() {
        crearVentana();
        crearComponentes();
    }
    private void crearVentana() {
        setVisible(true);
        setSize(500,80);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void crearComponentes() {
        Container contenedor = getContentPane();
        setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel();
        JLabel texto = new JLabel();
        recuadro = new JTextField(10);
        JButton boton1 = new JButton("Abrir proyecto");
        texto.setText("Nombre proyecto:");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.getDatosAbrirProyecto();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }


            }
        });
        panel.add(texto);
        panel.add(recuadro);
        panel.add(boton1);
        contenedor.add(panel);
    }
    public String nombreProyecto() {
        return recuadro.getText();
    }
}