package practica1.modelo;

import practica1.*;
import practica1.vista.Vista;

import java.io.IOException;

public interface Modelo {
    /*
    void marcarFinalizada ( Tarea titulo ) throws TareaEsNullException;
    void añadirPersona( Personas objPersona ) throws PersonaRepetidaException;
    void añadirTarea( Tarea objTarea ) throws TareaRepetidaException, NoExisteNombreException,
            PersonaEsNullException, PrioridadErroneaException, FechaInicialAntesFinalException, CosteNegativoException;
    void introducirPersonaEnTarea( Personas objPersona, Tarea objTarea ) throws NoExisteNombreException,
            NoExisteTareaException, ExistePersonaInscritaEnTareaException, TareaEsNullException, PersonaEsNullException;
    void eliminarPersonaEnTarea( Personas objPersona, Tarea objTarea ) throws NoExisteNombreException,
            NoExisteTareaException, NoExistePersonaInscritaEnTareaException, TareaEsNullException,
            PersonaEsNullException;
    void cambiarCosteTarea( Tarea objTarea, double coste ) throws TareaEsNullException,
            CosteNegativoException;
    void cambiarTipoFacturacionTarea( Tarea objTarea, Facturacion objFacturacion )
            throws MismoTipoFacturacionException, TareaEsNullException, NoExisteTareaException;
    double calcularCosteTotalProyecto();
     */
    // listar tareas??
    void setVista(Vista vista);
    Proyecto crearProyecto(String nombre);
    void abrirProyecto(Proyecto proyecto) throws IOException, ClassNotFoundException;
    void añadirPersona( String nombre, String email ) throws PersonaRepetidaException;
    void añadirTarea(String titulo, String descripcion, String nombreResponsable , double Coste, Facturacion facturacion,
    int prioridad, int dia, int mes, int año, String resultado);
    void añadirPersonaEnTarea( String nombrePersona, String titulo) throws PersonaEsNullException, NoExisteNombreException, ExistePersonaInscritaEnTareaException, TareaEsNullException, NoExisteTareaException;
}
