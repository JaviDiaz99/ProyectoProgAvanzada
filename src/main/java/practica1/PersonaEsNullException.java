package practica1;

public class PersonaEsNullException extends Exception {
    public PersonaEsNullException() {
        super("La persona no existe\n");
    }
}
