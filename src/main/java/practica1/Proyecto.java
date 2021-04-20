package practica1;

import java.io.Serializable;
import java.util.HashMap;

public class Proyecto implements Serializable {
    private String nombre;
    private HashMap<String,Personas> listaPersonas; // Clave: nombre
    private HashMap<String,Tarea> listaTareas; // Clave: título

    public Proyecto() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Tarea> getListaTareas() { return listaTareas; }

    public HashMap<String, Personas> getListaPersonas() { return listaPersonas; }

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.listaPersonas = new HashMap<>();
        this.listaTareas = new HashMap<>();
    }
    public Personas devolverPersona(String nombre ) { return getListaPersonas().get(nombre);}

    public Tarea devolverTarea(String titulo ) { return getListaTareas().get(titulo);}

    public boolean existePersona( String nombre ) {
        return listaPersonas.containsKey(nombre);
    }

    public boolean existeTarea( String titulo ) { return listaTareas.containsKey(titulo); }

    public void marcarFinalizada ( Tarea titulo ) throws TareaEsNullException {
        if ( titulo == null ) {
            throw new TareaEsNullException();
        }
        listaTareas.get(titulo.getClave()).marcarFinalizada();
    }

    public void añadirPersona( Personas objPersona ) throws PersonaRepetidaException {
        if ( existePersona(objPersona.getClave() )) {
            throw new PersonaRepetidaException(objPersona);
        }
        listaPersonas.put(objPersona.getClave(),objPersona);
    }
    public void añadirTarea( Tarea objTarea ) throws TareaRepetidaException, NoExisteNombreException,
            PersonaEsNullException, PrioridadErroneaException, FechaInicialAntesFinalException {
        if (existeTarea(objTarea.getClave())) {
            throw new TareaRepetidaException(objTarea);
        }
        if ( objTarea.getResponsable() == null ) {
            throw new PersonaEsNullException();
        }
        if ( !existePersona(objTarea.getResponsable().getClave())) {
            throw new NoExisteNombreException(objTarea.getResponsable());
        }
        if ( objTarea.getPrioridad() < 1 || objTarea.getPrioridad() > 5 ) {
            throw new PrioridadErroneaException();
        }
        if ( objTarea.getFechaFinal().before(objTarea.getFechaInicio())) {
            throw new FechaInicialAntesFinalException();
        }
        Personas responsableLista = listaPersonas.get(objTarea.getResponsable().getClave());
        responsableLista.getLista().add(objTarea);
        listaTareas.put(objTarea.getClave(),objTarea);
    }
    public void introducirPersonaEnTarea( Personas objPersona, Tarea objTarea ) throws NoExisteNombreException,
            NoExisteTareaException, ExistePersonaInscritaEnTareaException, TareaEsNullException, PersonaEsNullException {
        if ( objTarea == null ) {
            throw new TareaEsNullException();
        }
        if ( objPersona == null ) {
            throw new PersonaEsNullException();
        }
        if ( ! existeTarea(objTarea.getClave() )) {
            throw new NoExisteTareaException(objTarea);
        }
        if ( ! existePersona(objPersona.getClave() )) {
            throw new NoExisteNombreException(objPersona);
        }
        if ( ! UtilidadesParaListas.sePuedeInsertar(objPersona,objTarea)) {
            throw new ExistePersonaInscritaEnTareaException(objPersona, objTarea);
        }
        objTarea.getLista().add(objPersona);
    }
    public void eliminarPersonaEnTarea( Personas objPersona, Tarea objTarea ) throws NoExisteNombreException,
            NoExisteTareaException, NoExistePersonaInscritaEnTareaException, TareaEsNullException,
            PersonaEsNullException {
        if ( objTarea == null ) {
            throw new TareaEsNullException();
        }
        if ( objPersona == null ) {
            throw new PersonaEsNullException();
        }
        if ( ! existeTarea(objTarea.getClave() )) {
            throw new NoExisteTareaException(objTarea);
        }
        if ( ! existePersona(objPersona.getClave() )) {
            throw new NoExisteNombreException(objPersona);
        }
        if ( UtilidadesParaListas.sePuedeInsertar(objPersona,objTarea) ) {
            throw new NoExistePersonaInscritaEnTareaException(objPersona, objTarea);
        }
        objTarea.getLista().remove(objPersona);
    }
}