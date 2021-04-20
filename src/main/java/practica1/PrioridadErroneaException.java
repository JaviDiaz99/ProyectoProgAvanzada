package practica1;

public class PrioridadErroneaException extends Exception {
    public PrioridadErroneaException() {
        super("La prioridad no es correcta, debe estar entre 1 y 5 inclusive\n");
    }
}
