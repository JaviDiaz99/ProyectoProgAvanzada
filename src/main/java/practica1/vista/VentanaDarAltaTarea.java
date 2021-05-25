package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaDarAltaTarea extends JPanel {
    private JTextField Titulo;
    private JTextField descripcion;
    private JTextField nombrePersonaResponsable;
    private JTextField costeTarea;
    private JTextField prioridadTarea;
    private JTextField dia;
    private JTextField mes;
    private JTextField año;
    private JTextField resultadoEsperado;
    private JRadioButton botonConsumo;
    private JRadioButton botonDescuento;
    private JRadioButton botonUrgente;
    private ButtonGroup grupo;
    private ButtonGroup grupo2;
    private JRadioButton siPrioridad;
    private JRadioButton noPrioridad;

    // falta tipo facturación

    VentanaDarAltaTarea(Controlador controlador) {
        setLayout(new BorderLayout());

        JPanel datos = new JPanel();
        datos.setLayout(new BoxLayout(datos, BoxLayout.PAGE_AXIS));

        Titulo = creaEntrada(datos, "Nombre titulo:");
        descripcion = creaEntrada(datos, "Descripcion:");
        nombrePersonaResponsable = creaEntrada(datos,"Persona responsable:");
        costeTarea = creaEntrada(datos,"Coste tarea:");

        botonConsumo = new JRadioButton("Consumo interno");
        botonDescuento = new JRadioButton("Descuento");
        botonUrgente = new JRadioButton("Urgente");
        botonConsumo.setActionCommand("consumo");
        botonDescuento.setActionCommand("descuento");
        botonUrgente.setActionCommand("urgente");
        grupo = new ButtonGroup();
        grupo.add(botonConsumo);
        grupo.add(botonDescuento);
        grupo.add(botonUrgente);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Tipo facturación:"), BorderLayout.LINE_START);
        panel.add(botonConsumo);
        panel.add(botonDescuento);
        panel.add(botonUrgente);
        datos.add(panel);

        siPrioridad = new JRadioButton("Si");
        noPrioridad = new JRadioButton("No");
        siPrioridad.setActionCommand("si");
        noPrioridad.setActionCommand("no");
        grupo2 = new ButtonGroup();
        grupo2.add(siPrioridad);
        grupo2.add(noPrioridad);
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Prioridad:"), BorderLayout.LINE_START);
        panel2.add(siPrioridad);
        panel2.add(noPrioridad);
        datos.add(panel2);

        prioridadTarea = creaEntrada(datos,"Prioridad:");

        dia = creaEntrada(datos,"Día:");
        mes = creaEntrada(datos,"Mes:");
        año = creaEntrada(datos,"Año:");

        resultadoEsperado = creaEntrada(datos,"Resultado esperado:");
        add(datos, BorderLayout.PAGE_START);

        JButton boton = new JButton("Dar alta");
        add(boton,BorderLayout.PAGE_END);

        final ActionListener alta = e -> controlador.getDatosAltaPersona();

        /*
        Titulo.addActionListener(e -> descripcion.requestFocusInWindow());
        descripcion.addActionListener(e -> nombrePersonaResponsable.requestFocusInWindow());
        nombrePersonaResponsable.addActionListener(e -> costeTarea.requestFocusInWindow());
        costeTarea.addActionListener(e -> checkBoxConsumo.requestFocusInWindow());
        checkBoxConsumo.addActionListener(e -> checkBoxDescuento.requestFocusInWindow());
        checkBoxDescuento.addActionListener(e -> checkBoxUrgente.requestFocusInWindow());
        checkBoxUrgente.addActionListener(e -> prioridadTarea.requestFocusInWindow());
        prioridadTarea.addActionListener(e -> dia.requestFocusInWindow());
        dia.addActionListener(e -> mes.requestFocusInWindow());
        mes.addActionListener(e -> año.requestFocusInWindow());
        mes.addActionListener(e -> resultadoEsperado.requestFocusInWindow());
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
    public String nombreTitulo() { return Titulo.getText(); }
    public String descripcion() { return descripcion.getText(); }
    public String nombrePersonaResponsable() { return nombrePersonaResponsable.getText(); }
    public double coste() { return Double.parseDouble(costeTarea.getText()); }
    public int prioridad() { return Integer.parseInt(prioridadTarea.getText());}
    public String tipoFacturacion() { return grupo.getSelection().getActionCommand(); }
    public int dia() { return Integer.parseInt(dia.getText());}
    public int mes() { return Integer.parseInt(mes.getText());}
    public int año() { return Integer.parseInt(año.getText());}
    public String resultado() { return resultadoEsperado.getText();}
    public boolean estaFinalizada() { return grupo2.getSelection().getActionCommand().equals("si"); }
}

