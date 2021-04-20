package practica1;

public class Programa extends Resultado{
    private String lenguaje;
    private String numLíneas;
    private int numMódulos;

    public Programa(String lenguaje, String numLíneas, int numMódulos,
                    String id, int horasInvertidas, String internoOcomercializado) {
        super(id,horasInvertidas,internoOcomercializado);
        this.lenguaje = lenguaje;
        this.numLíneas = numLíneas;
        this.numMódulos = numMódulos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "lenguaje='" + lenguaje + '\'' +
                ", numLíneas='" + numLíneas + '\'' +
                ", numMódulos=" + numMódulos;
    }
    /*
    public Programa() {
        super();
    }
    */
}
