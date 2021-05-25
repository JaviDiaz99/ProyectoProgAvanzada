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

    private VentanaDarAltaPersona ventanaAltaPersona;
    private VentanaAñadirPersonaTarea ventanaAñadirPersonaTarea;
    private VentanaDarAltaTarea ventanaAltaTarea;
    private VentanaMarcarTarea ventanaMarcarTarea;
    private VentanaBorrarPersonaTarea ventanaBorrarPersonaTarea;
    private VentanaCambiarCostesTarea ventanaCambiarCostesTarea;
    private VentanaListarPersonas ventanaListarPersonas;
    private VentanaListarTareas ventanaListarTareas;

    public void setControlador(Controlador controlador) { this.controlador = controlador; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }
    public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }

    public Proyecto getProyecto() {
        return proyecto;
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
    public String getCoste() { return ventanaAltaTarea.coste(); }

    @Override
    public String getFacturacion() { return ventanaAltaTarea.tipoFacturacion(); }

    @Override
    public String getPrioridad() { return ventanaAltaTarea.prioridad(); }

    @Override
    public String getDia() { return ventanaAltaTarea.dia(); }

    @Override
    public String getMes() { return ventanaAltaTarea.mes(); }

    @Override
    public String getAño() { return ventanaAltaTarea.año(); }

    @Override
    public String getResultado() { return ventanaAltaTarea.resultado(); }

    @Override
    public String getValorAplicar() { return ventanaAltaTarea.valorAplicar(); }

    @Override
    public String nombrePersonaAñadirPersonaTarea() { return ventanaAñadirPersonaTarea.nombrePersona(); }

    @Override
    public String tituloTareaAñadirPersonaTarea() { return ventanaAñadirPersonaTarea.tituloTarea(); }

    @Override
    public String nombrePersonaBorrarPersonaTarea() {
        return ventanaBorrarPersonaTarea.nombrePersona();
    }

    @Override
    public String tituloTareaBorrarPersonaTarea() {
        return ventanaBorrarPersonaTarea.tituloTarea();
    }

    @Override
    public String nombreTareaCoste() {
        return ventanaCambiarCostesTarea.nombretarea();
    }

    @Override
    public String costeDeTarea() {
        return ventanaCambiarCostesTarea.costetarea();
    }

    @Override
    public String nombreListarPersonas() {
        return ventanaListarPersonas.nombrePersona();
    }

    @Override
    public String nombreListarTareas() {
        return ventanaListarTareas.nombreTarea();
    }

    @Override
    public String getTituloMarcarTarea() { return ventanaMarcarTarea.tituloTarea(); }

    public void crearGUI(){
        ventana = new JFrame();
        ventanaAltaPersona = new VentanaDarAltaPersona(controlador);
        ventanaAltaTarea = new VentanaDarAltaTarea(controlador);
        ventanaAñadirPersonaTarea = new VentanaAñadirPersonaTarea(controlador);
        ventanaMarcarTarea = new VentanaMarcarTarea(controlador);
        ventanaBorrarPersonaTarea= new VentanaBorrarPersonaTarea(controlador);
        ventanaCambiarCostesTarea = new VentanaCambiarCostesTarea(controlador);
        ventanaListarPersonas = new VentanaListarPersonas(controlador);
        ventanaListarTareas = new VentanaListarTareas(controlador);


        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Alta Persona", ventanaAltaPersona);
        tabs.add("Alta tarea",ventanaAltaTarea);
        tabs.add("Añadir persona en tarea",ventanaAñadirPersonaTarea);
        tabs.add("Marcar tarea",ventanaMarcarTarea);
        tabs.add("Borrar persona en tarea", ventanaBorrarPersonaTarea);
        tabs.add("Cambiar coste tarea", ventanaCambiarCostesTarea);
        tabs.add("Listar Personas", ventanaListarPersonas);
        tabs.add("Listar Tareas", ventanaListarTareas);



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
