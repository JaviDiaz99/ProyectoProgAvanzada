package practica1;

public class NoExisteNombreException extends Exception {
    public NoExisteNombreException(Personas objPersona) {
        super("La persona con nombre " + objPersona.getClave() + " no existe\n");
    }
}
