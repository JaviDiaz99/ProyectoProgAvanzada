package practica1.controlador;

import practica1.*;
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

    public void getDatosAltaTarea() {

        String Titulo = vista.getTitulo();
        String descripcion = vista.getDescripcion();
        String nombreResponsable = vista.getNombrePersonaResponsable();
        double coste = vista.getCoste();
        String nombreFacturacion = vista.getFacturacion();
        int prioridad = vista.getPrioridad();
        int dia = vista.getDia();
        int mes = vista.getMes();
        int año = vista.getAño();
        Facturacion facturacion = null;

        switch ( nombreFacturacion ){
            case "consumo":
                facturacion = new ConsumoInterno();
                break;
            case "urgente":

        }
        /*
        try {
            modelo.añadir
        }
         */

    }

    @Override
    public void getDatosAñadirPersonaTarea() throws NoExisteNombreException,
            NoExisteTareaException {
        String nombre = vista.nombrePersonaAñadirPersonaTarea();
        String titulo = vista.tituloTareaAñadirPersonaTarea();
        try {
            modelo.añadirPersonaEnTarea(nombre, titulo);
        } catch ( PersonaEsNullException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( ExistePersonaInscritaEnTareaException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( TareaEsNullException e ) {
            vista.mensajeError(e.getMessage());
        }
    }

}
