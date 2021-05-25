package practica1.modelo;

import practica1.*;
import practica1.vista.Vista;

import javax.swing.*;
import java.io.*;
import java.sql.Date;

import static javax.swing.JFileChooser.*;

public class ImplementacionModelo implements Modelo {
    private Vista vista;

    @Override
    public void setVista(Vista vista) { this.vista = vista; }

    @Override
    public Proyecto crearProyecto(String nombre) {
        return new Proyecto(nombre);
    }

    @Override
    public void abrirProyecto() throws IOException, ClassNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);
        Proyecto proyecto;
        switch (resultado) {
            case CANCEL_OPTION: // iría crear proyecto aqui??
                proyecto = new Proyecto("PROYECTO_SIN_NOMBRE");
                vista.setProyecto(proyecto);
                break;
            case APPROVE_OPTION:
                File f = fileChooser.getSelectedFile();
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                proyecto = (Proyecto)ois.readObject();
                vista.setProyecto(proyecto);
                ois.close();
                break;
            case ERROR_OPTION:
                break;
        }
    }

    @Override
    public void añadirPersona(String nombre, String email) throws PersonaRepetidaException {
        if ( nombre.isEmpty() || email.isEmpty() ) {
            throw new IllegalArgumentException("Los recuadros no tienen que estar vacios");
        }
        vista.getProyecto().añadirPersona(new Personas(nombre,email));
    }

    @Override
    public void añadirTarea(String titulo, String descripcion, String nombreResponsable,String prioridad,
                            String dia, String mes, String año, String resultado,
                            Facturacion facturacion, String coste) throws PersonaEsNullException,
            NoExisteNombreException, FechaInicialAntesFinalException, TareaRepetidaException,
            PrioridadErroneaException, CosteNegativoException {
        if ( titulo.isEmpty() || descripcion.isEmpty() || nombreResponsable.isEmpty() || prioridad.isEmpty()
        || dia.isEmpty() || mes.isEmpty() || año.isEmpty() || resultado.isEmpty() || coste.isEmpty()) {
            throw new IllegalArgumentException("Los recuadros no tienen que estar vacios");
        }
        vista.getProyecto().añadirTarea(new Tarea(titulo,descripcion,vista.getProyecto().devolverPersona(nombreResponsable)
        ,Integer.parseInt(prioridad),new Date(Integer.parseInt(año), Integer.parseInt(mes), Integer.parseInt(dia)),
                false,resultado,facturacion,Double.parseDouble(coste)));
    }

    @Override
    public void añadirPersonaEnTarea(String nombrePersona, String titulo) throws PersonaEsNullException,
            NoExisteNombreException, ExistePersonaInscritaEnTareaException, TareaEsNullException, NoExisteTareaException {
        if ( nombrePersona.isEmpty() || titulo.isEmpty() ) {
            throw new IllegalArgumentException("Los recuadros no tienen que estar vacios");
        }
        vista.getProyecto().introducirPersonaEnTarea(vista.getProyecto().devolverPersona(nombrePersona)
        ,vista.getProyecto().devolverTarea(titulo));
    }
    @Override
    public void marcarTarea( String tituloTarea) throws TareaEsNullException {
        if ( tituloTarea.isEmpty() ) {
            throw new IllegalArgumentException("Los recuadros no tienen que estar vacios");
        }
        vista.getProyecto().marcarFinalizada(vista.getProyecto().devolverTarea(tituloTarea));
    }

    @Override
    public void borrarPersonaTarea(String nombrePersona, String titulo) throws PersonaEsNullException,
            NoExisteNombreException, TareaEsNullException,
            NoExisteTareaException, NoExistePersonaInscritaEnTareaException {
        if ( nombrePersona.isEmpty() || titulo.isEmpty() ) {
            throw new IllegalArgumentException("Los recuadros no tienen que estar vacios");
        }
        vista.getProyecto().eliminarPersonaEnTarea(vista.getProyecto().devolverPersona(nombrePersona),
        vista.getProyecto().devolverTarea(titulo));
    }

}
