package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenuOpciones extends JFrame {
    VentanaMenuOpciones() { super(); }
    public void ejecuta() {
        crearVentana();
        crearComponentes();
    }
    private void crearVentana() {
        setVisible(true);
        setSize(500,200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void crearComponentes() {
        Container contenedor = getContentPane();
        setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        JPanel panel = new JPanel();
        JButton boton1 = new JButton("Dar alta personas");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaDarAlta().ejecuta();
                dispose();
            }
        });
        JButton boton2 = new JButton("Añadir persona en tarea");
        JButton boton3 = new JButton("Quitar persona de tarea");
        JButton boton4 = new JButton("Listar personas");
        JButton boton5 = new JButton("Dar alta tareas");
        JButton boton6 = new JButton("Marcar tareas");
        JButton boton7 = new JButton("Listar tareas");
        JButton boton8 = new JButton("Listar tareas sin personas");
        JButton boton9 = new JButton("Cambiar coste tarea");
        JButton boton10 = new JButton("Cambiar tipo facturación");
        JButton boton11 = new JButton("Calcular coste proyecto");
        JButton boton12 = new JButton("Guardar proyecto");
        panel.add(boton1); panel.add(boton2); panel.add(boton3); panel.add(boton4); panel.add(boton5);
        panel.add(boton6); panel.add(boton7); panel.add(boton8); panel.add(boton9); panel.add(boton10);
        panel.add(boton11); panel.add(boton12);
        contenedor.add(panel);
    }

    public static void main( String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaMenuOpciones().ejecuta();
            }
        });
    }
}
