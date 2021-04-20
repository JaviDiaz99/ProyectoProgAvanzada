package practica1;

public class CosteNegativoException extends Exception {
    public CosteNegativoException() {
        super("El coste no puede ser negativo");
    }
}
