package practica1;

public class PersonaRepetidaException extends Exception{
    public PersonaRepetidaException(Personas persona ) {
        super("La persona con nombre " + persona.getClave() + " está repetida\n");
    }
}
