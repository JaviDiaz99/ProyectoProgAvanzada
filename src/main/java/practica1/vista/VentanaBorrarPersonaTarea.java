package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBorrarPersonaTarea extends JPanel {
    private JTextField nombre;
    private JTextField titulo;

    VentanaBorrarPersonaTarea(Controlador controlador) {
        setLayout(new BorderLayout());

        JPanel datos = new JPanel();
        datos.setLayout(new BoxLayout(datos, BoxLayout.PAGE_AXIS));

        nombre = creaEntrada(datos, "Nombre persona:");
        titulo = creaEntrada(datos, "Titulo tarea:");
        add(datos, BorderLayout.PAGE_START);

        JButton boton = new JButton("Borrar");
        add(boton,BorderLayout.PAGE_END);

        final ActionListener alta = e -> controlador.getDatosBorrarPersonaTarea();
        /*
         nombre.addActionListener(e -> concepto.requestFocusInWindow()); ??
        nombre.addActionListener(e -> email.requestFocusInWindow());
        email.addActionListener(alta); // ???
         */
        boton.addActionListener(alta);
    }
    private JTextField creaEntrada(JPanel datos, String mensaje) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(4, 0));
        panel.add(new JLabel(mensaje), BorderLayout.LINE_START);
        JTextField entrada = new JTextField();
        panel.add(entrada, BorderLayout.CENTER);
        datos.add(panel);
        return entrada;
    }
    public String nombrePersona() { return nombre.getText(); }
    public String tituloTarea() { return titulo.getText(); }
}