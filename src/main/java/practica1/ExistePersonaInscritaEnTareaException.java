package practica1;

public class ExistePersonaInscritaEnTareaException extends Exception {
    public ExistePersonaInscritaEnTareaException ( Personas objPersona, Tarea objTarea ) {
        super( "La persona con nombre " + objPersona.getClave() + " ya está inscrita en la tarea con título " +
                objTarea.getClave() + "\n");
    }
}
