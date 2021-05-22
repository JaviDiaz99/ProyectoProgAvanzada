package practica1.controlador;

import practica1.modelo.Modelo;
import practica1.vista.Vista;

import javax.swing.*;

public class ImplementacionControlador implements Controlador {
    private Modelo modelo;
    private Vista vista;

    @Override
    public void getDatosCrearProyecto(JTextField recuadro) {
        String nombre = vista.nombreProyecto(recuadro);
        modelo.crearProyecto(nombre);
    }
    public void getDatosAbrirProyecto(JTextField recuadro) {
        String nombre = vista.nombreProyecto(recuadro);
        modelo.abrirProyecto(nombre);
    }
}
