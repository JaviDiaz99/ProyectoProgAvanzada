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
    private JTextField valorAplicar;
    private JRadioButton botonConsumo;
    private JRadioButton botonDescuento;
    private JRadioButton botonUrgente;
    private ButtonGroup grupo;

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
        botonUrgente.setSelected(true);
        panel.add(new JLabel("Valor aplicar:"), BorderLayout.LINE_START);
        valorAplicar = new JTextField(6);
        valorAplicar.setText("0");
        panel.add(valorAplicar);
        datos.add(panel);

        prioridadTarea = creaEntrada(datos,"Prioridad:");

        dia = creaEntrada(datos,"Día:");
        mes = creaEntrada(datos,"Mes:");
        año = creaEntrada(datos,"Año:");

        resultadoEsperado = creaEntrada(datos,"Resultado esperado:");
        add(datos, BorderLayout.PAGE_START);

        JButton boton = new JButton("Dar alta");
        add(boton,BorderLayout.PAGE_END);

        final ActionListener alta = e -> controlador.getDatosAltaTarea();

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
    public String coste() { return costeTarea.getText(); }
    public String prioridad() { return prioridadTarea.getText() ;}
    public String tipoFacturacion() { return grupo.getSelection().getActionCommand(); }
    public String dia() { return dia.getText();}
    public String mes() { return mes.getText();}
    public String año() { return año.getText();}
    public String resultado() { return resultadoEsperado.getText();}
    public String valorAplicar() { return valorAplicar.getText(); }
}

