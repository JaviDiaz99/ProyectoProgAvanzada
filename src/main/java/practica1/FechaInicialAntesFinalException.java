package practica1;

public class FechaInicialAntesFinalException extends Exception {
    public FechaInicialAntesFinalException() {
        super("La fecha final no se puede ser anterior a la fecha inicial\n");
    }
}
