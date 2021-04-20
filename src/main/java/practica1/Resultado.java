package practica1;

public class Resultado {
    private String id;
    private int horasInvertidas;
    private String internoOcomercializado;

    public Resultado(String id, int horasInvertidas, String internoOcomercializado) {
        this.id = id;
        this.horasInvertidas = horasInvertidas;
        this.internoOcomercializado = internoOcomercializado;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", horasInvertidas=" + horasInvertidas +
                ", internoOcomercializado='" + internoOcomercializado + " ";
    }
}
