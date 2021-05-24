package practica1.vista;

import practica1.Proyecto;
import practica1.controlador.Controlador;
import practica1.modelo.Modelo;

import javax.swing.*;

public class ImplementacionVista implements Vista{
    private Controlador controlador;
    private Modelo modelo;

    private Proyecto proyecto;

    private JFrame ventana;

    private VentanaAbrirProyecto ventanaAbrir;
    private VentanaCrearProyecto ventanaCrear;
    private VentanaDarAltaPersona ventanaAltaPersona;
    private VentanaAñadirPersonaTarea ventanaAñadirPersonaTarea;
    private VentanaDarAltaTarea ventanaAltaTarea;

    public void setControlador(Controlador controlador) { this.controlador = controlador; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }
    public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public String nombreProyecto(){
        return ventanaAbrir.nombreProyecto();
    }

    @Override
    public String getNombrePersonaDarAlta() { return ventanaAltaPersona.nombrePersona(); }

    @Override
    public String getEmailPersonaDarAlta() { return ventanaAltaPersona.emailPersona(); }

    @Override
    public String getTitulo() { return ventanaAltaTarea.nombreTitulo(); }

    @Override
    public String getDescripcion() { return ventanaAltaTarea.descripcion(); }

    @Override
    public String getNombrePersonaResponsable() { return ventanaAltaTarea.nombrePersonaResponsable(); }

    @Override
    public double getCoste() { return ventanaAltaTarea.coste(); }

    @Override
    public String getFacturacion() { return ventanaAltaTarea.tipoFacturacion(); }

    @Override
    public int getPrioridad() { return ventanaAltaTarea.prioridad(); }

    @Override
    public int getDia() { return ventanaAltaTarea.dia(); }

    @Override
    public int getMes() { return ventanaAltaTarea.mes(); }

    @Override
    public int getAño() { return ventanaAltaTarea.año(); }

    @Override
    public String getResultado() { return ventanaAltaTarea.resultado(); }

    @Override
    public String nombrePersonaAñadirPersonaTarea() { return ventanaAñadirPersonaTarea.nombrePersona(); }

    @Override
    public String tituloTareaAñadirPersonaTarea() { return ventanaAñadirPersonaTarea.tituloTarea(); }

    public void crearGUI(){
        ventana = new JFrame();
        ventanaAltaPersona = new VentanaDarAltaPersona(controlador);
        ventanaAltaTarea = new VentanaDarAltaTarea(controlador);
        ventanaAñadirPersonaTarea = new VentanaAñadirPersonaTarea(controlador);
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Alta Persona", ventanaAltaPersona);
        tabs.add("Alta tarea",ventanaAltaTarea);
        tabs.add("Añadir persona en tarea",ventanaAñadirPersonaTarea);

        ventana.add(tabs);
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    @Override
    public void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public String nombreProyecto(JTextField cuadro){
        return cuadro.getText();
    }
}
