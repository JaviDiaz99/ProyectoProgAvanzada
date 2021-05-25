package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaCambiarCostesTarea extends JPanel {
    private JTextField tarea;
    private JTextField coste;

    VentanaCambiarCostesTarea(Controlador controlador) {
        setLayout(new BorderLayout());

        JPanel datos = new JPanel();
        datos.setLayout(new BoxLayout(datos, BoxLayout.PAGE_AXIS));

        tarea = creaEntrada(datos, "Nombre tarea:");
        coste = creaEntrada(datos, "Coste tarea:");
        add(datos, BorderLayout.PAGE_START);

        JButton boton = new JButton("Cambiar");
        add(boton,BorderLayout.PAGE_END);

        final ActionListener alta = e -> controlador.getDatosCambiarCostesTarea();
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
    public String nombretarea() { return tarea.getText(); }
    public String costetarea() { return coste.getText(); }
}


