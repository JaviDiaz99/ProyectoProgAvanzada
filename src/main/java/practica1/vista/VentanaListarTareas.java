package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaListarTareas extends JPanel{
    private JTextField tarea;

    VentanaListarTareas(Controlador controlador) {
        setLayout(new BorderLayout());

        JPanel datos = new JPanel();
        datos.setLayout(new BoxLayout(datos, BoxLayout.PAGE_AXIS));

        tarea = creaEntrada(datos, "Nombre tarea:");
        add(datos, BorderLayout.PAGE_START);

        JButton boton = new JButton("Buscar");
        add(boton,BorderLayout.PAGE_END);

        final ActionListener alta = e -> controlador.getDatosListarTareas();

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
    public String nombreTarea() { return tarea.getText(); }
}

