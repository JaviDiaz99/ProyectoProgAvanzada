package practica1;

public class PersonaRepetidaEnTareaException extends Exception {
    public PersonaRepetidaEnTareaException ( Personas objPersona ) {
        super("La persona con nombre " + objPersona.getClave() + " ya existe en la tarea\n");
    }
}
