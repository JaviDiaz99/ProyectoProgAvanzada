package practica1;

public class NoExistePersonaInscritaEnTareaException extends Exception {
    public NoExistePersonaInscritaEnTareaException ( Personas objPersona, Tarea objTarea ) {
        super( "La persona con nombre " + objPersona.getClave() +
                " no está inscrita en la tarea con título " + objTarea.getClave() +"\n");
    }
}
