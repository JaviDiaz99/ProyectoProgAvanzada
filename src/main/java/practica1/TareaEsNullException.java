package practica1;

public class TareaEsNullException extends Exception {
    public TareaEsNullException() {
        super("La tarea no existe\n");
    }
}
