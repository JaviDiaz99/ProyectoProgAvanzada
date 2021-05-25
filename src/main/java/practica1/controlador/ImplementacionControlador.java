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
    public void getDatosCrearProyecto(JTextField recuadro) { // ***************** !!!!!!
        //String nombre = vista.nombreProyecto(recuadro);
        //modelo.crearProyecto(nombre);
    }
    public void getDatosAbrirProyecto() throws IOException, ClassNotFoundException {
        //modelo.abrirProyecto(vista.getProyecto());
    }
    public void getDatosAltaPersona() {
        String nombre = vista.getNombrePersonaDarAlta();
        String email = vista.getEmailPersonaDarAlta();
        try {
            modelo.añadirPersona(nombre,email);
        } catch (PersonaRepetidaException e) {
            vista.mensajeError(e.getMessage());
        } catch ( IllegalArgumentException e ) {
            vista.mensajeError(e.getMessage());
        }
    }
    public void getDatosAltaTarea() {
        String Titulo = vista.getTitulo();
        String descripcion = vista.getDescripcion();
        String nombreResponsable = vista.getNombrePersonaResponsable();
        String coste = vista.getCoste();
        String nombreFacturacion = vista.getFacturacion();
        String prioridad = vista.getPrioridad();
        String dia = vista.getDia();
        String mes = vista.getMes();
        String año = vista.getAño();
        String resultado = vista.getResultado();
        double valor = 0;
        Facturacion facturacion = null;
        boolean seguir = false;

        try {
            valor = Double.parseDouble(vista.getValorAplicar());
            switch ( nombreFacturacion ){ // facturacion sea null??
                case "consumo":
                    facturacion = new ConsumoInterno();
                    seguir = true;
                    break;
                case "descuento":
                    if ( valor < 0 ) {
                        vista.mensajeError(" El " + nombreFacturacion + "no puede ser menor que 0");
                    } else {
                        facturacion = new Descuento(valor);
                        seguir = true;
                    }
                    break;
                case "urgente":
                    if ( valor < 0 ) {
                        vista.mensajeError(" El " + nombreFacturacion + "no puede ser menor que 0");
                    } else {
                        facturacion = new Urgente(valor);
                        seguir = true;
                    }
                    break;
            }
        } catch ( IllegalArgumentException e ) {
            vista.mensajeError("El valor tiene que ser un número");
        }

        if ( seguir ) {
            try {
                modelo.añadirTarea(Titulo,descripcion,nombreResponsable,prioridad,dia,mes,año,resultado,
                        facturacion,coste);
            }  catch (PersonaEsNullException | NoExisteNombreException e) {
                vista.mensajeError(e.getMessage());
            } catch (FechaInicialAntesFinalException e) {
                vista.mensajeError(e.getMessage());
            } catch (TareaRepetidaException e) {
                vista.mensajeError(e.getMessage());
            } catch (CosteNegativoException e) {
                vista.mensajeError(e.getMessage());
            } catch ( PrioridadErroneaException e ) {
                vista.mensajeError(e.getMessage());
            } catch ( IllegalArgumentException e ) {
                vista.mensajeError(e.getMessage());
            }
        }
    }
    @Override
    public void getDatosAnyadirPersonaEnTarea() {
        String nombre = vista.nombrePersonaAñadirPersonaTarea();
        String titulo = vista.tituloTareaAñadirPersonaTarea();
        try {
            modelo.añadirPersonaEnTarea(nombre, titulo);
        } catch ( PersonaEsNullException | NoExisteNombreException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( ExistePersonaInscritaEnTareaException e ) {
            vista.mensajeError(e.getMessage());
        } catch (TareaEsNullException | NoExisteTareaException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( IllegalArgumentException e ) {
            vista.mensajeError(e.getMessage());
        }
    }

    @Override
    public void getDatosMarcarTarea() {
        String tituloTarea = vista.getTituloMarcarTarea();
        try {
            modelo.marcarTarea(tituloTarea);
        } catch ( TareaEsNullException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( IllegalArgumentException e ) {
            vista.mensajeError(e.getMessage());
        }
    }

    @Override
    public void getDatosBorrarPersonaTarea() {
        String nombre = vista.nombrePersonaBorrarPersonaTarea();
        String titulo = vista.tituloTareaBorrarPersonaTarea();
        try {
            modelo.borrarPersonaTarea(nombre,titulo);
        } catch ( PersonaEsNullException | NoExisteNombreException e ) {
            vista.mensajeError(e.getMessage());
        } catch (TareaEsNullException | NoExisteTareaException e ) {
            vista.mensajeError(e.getMessage());
        } catch (NoExistePersonaInscritaEnTareaException e) {
            vista.mensajeError(e.getMessage());
        } catch ( ExistePersonaInscritaEnTareaException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( IllegalArgumentException e ) {
            vista.mensajeError(e.getMessage());
        }

    }

    @Override
    public void getDatosCambiarCostesTarea() {
        String tarea = vista.nombreTareaCoste();
        String coste = vista.costeDeTarea();
        try {
            modelo.cambiarCosteTarea(tarea, coste);
        } catch (TareaEsNullException | NoExisteTareaException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( IllegalArgumentException e ) {
            vista.mensajeError(e.getMessage());
        } catch ( CosteNegativoException e ) {
            vista.mensajeError(e.getMessage());
        }

    }

    @Override
    public void getDatosListarPersonas() {
        String persona = vista.nombreListarPersonas();
        try {
            modelo.listarPersonas(persona);
        } catch (PersonaEsNullException | NoExisteNombreException e) {
            vista.mensajeError(e.getMessage());

        }

    }

    @Override
    public void getDatosListarTareas() {
        String tarea = vista.nombreListarTareas();
        try {
            modelo.listarTareas(tarea);
        } catch (TareaEsNullException | NoExisteTareaException e) {
            vista.mensajeError(e.getMessage());

        }

    }
}
