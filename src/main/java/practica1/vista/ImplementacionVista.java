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
    private VentanaDarAlta ventanaAlta;
    private VentanaAñadirPersonaTarea ventanaAñadirPersonaTarea;

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
    public String getNombrePersonaDarAlta() { return ventanaAlta.nombrePersona(); }

    @Override
    public String getEmailPersonaDarAlta() { return ventanaAlta.emailPersona(); }

    public void crearGUI(){
        ventana = new JFrame();
        ventanaAlta = new VentanaDarAlta(controlador);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Alta Persona",ventanaAlta);

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
