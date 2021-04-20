package practica1;

public class Web {
    private String tipo;
    private String lenguaje;
    private BackEnd BackEndUtilizado;

    public Web(String tipo, String lenguaje, BackEnd BackEndUtilizado) {
        this.tipo = tipo;
        this.lenguaje = lenguaje;
        this.BackEndUtilizado = BackEndUtilizado;
    }

    public Web() {
        super();
    }
}
