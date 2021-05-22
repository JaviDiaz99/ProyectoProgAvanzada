package practica1.vista;

import practica1.controlador.Controlador;
import practica1.modelo.Modelo;

import javax.swing.*;

public class ImplementacionVista implements Vista{
    private Controlador controlador;
    private Modelo modelo;
    /*
    public String nombreProyecto(JTextField cuadro){
        return cuadro.getText();
    }
     */
    public String nombreProyecto(JTextField cuadro){
        return cuadro.getText();
    }
}
