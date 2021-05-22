package practica1.modelo;

import practica1.*;

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
    Proyecto crearProyecto(String nombre);
    Proyecto abrirProyecto(String nombre);
}
