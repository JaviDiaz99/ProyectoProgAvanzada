package practica1;

public class NoExisteTareaException extends Exception {
    public NoExisteTareaException(Tarea objTarea ) {
        super("La tarea con título " + objTarea.getClave() + " no existe\n");
    }
}
