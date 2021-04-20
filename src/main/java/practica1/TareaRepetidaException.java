package practica1;

public class TareaRepetidaException extends Exception {
    public TareaRepetidaException(Tarea objTarea ) {
        super("La tarea con título " + objTarea.getClave() + " está repetida\n");
    }
}
