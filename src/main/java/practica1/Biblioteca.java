package practica1;

public class Biblioteca extends Resultado {
    private String lenguaje;
    private String numLíneas;
    private int numMódulos;

    public Biblioteca(String lenguaje, String numLíneas, int numMódulos,
                      String id, int horasInvertidas, String internoOcomercializado) {
        super(id,horasInvertidas,internoOcomercializado);
        this.lenguaje = lenguaje;
        this.numLíneas = numLíneas;
        this.numMódulos = numMódulos;
    }
    /*
    public Biblioteca() {

    }
    */

    @Override
    public String toString() {
        return super.toString() +
                "lenguaje='" + lenguaje + '\'' +
                ", numLíneas='" + numLíneas + '\'' +
                ", numMódulos=" + numMódulos;
    }
}
