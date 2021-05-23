package practica1.controlador;

import practica1.PersonaRepetidaException;
import practica1.modelo.Modelo;
import practica1.vista.Vista;

import javax.swing.*;
import java.io.IOException;

public class ImplementacionControlador implements Controlador {
    private Modelo modelo;
    private Vista vista;

    public void setModelo(Modelo modelo) { this.modelo = modelo; }

    public void setVista(Vista vista) { this.vista = vista; }

    @Override
    public void getDatosCrearProyecto(JTextField recuadro) {
        //String nombre = vista.nombreProyecto(recuadro);
        //modelo.crearProyecto(nombre);
    }
    public void getDatosAbrirProyecto() throws IOException, ClassNotFoundException {
        modelo.abrirProyecto(vista.getProyecto());
    }
    public void getDatosAltaPersona() {
        String nombre = vista.getNombrePersonaDarAlta();
        String email = vista.getEmailPersonaDarAlta();
        try {
            modelo.añadirPersona(nombre,email);
        } catch (PersonaRepetidaException e) {
            vista.mensajeError(e.getMessage());
        }

    }
}
