package practica1;

public class Documentación extends Resultado {
    private String formato;
    private int numPáginas;
    private int espacio;

    public Documentación(String formato, int numPáginas, int espacio,
                         String id, int horasInvertidas, String internoOcomercializado) {
        super(id,horasInvertidas,internoOcomercializado);
        this.formato = formato;
        this.numPáginas = numPáginas;
        this.espacio = espacio;
    }

    @Override
    public String toString() {
        return super.toString() +
                "formato='" + formato + '\'' +
                ", numPáginas=" + numPáginas +
                ", espacio=" + espacio;
    }
    /*
    public Documentación() {
        super();
    }
    */
}
