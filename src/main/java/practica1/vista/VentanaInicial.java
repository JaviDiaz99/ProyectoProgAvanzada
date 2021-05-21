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
        JPanel panel = new JPanel();//Este panel contiene los componentes.
        panel.setLayout(new GridLayout(0,1,1,10));
        JButton boton1 = new JButton("Crear proyecto");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaCrearProyecto().ejecuta();
                dispose();
            }
        });
        panel.add(boton1);
        JButton boton2 = new JButton("Abrir proyecto");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaAbrirProyecto().ejecuta();
                dispose();
            }
        });
        panel.add(boton2);
        contenedor.add(panel);
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
