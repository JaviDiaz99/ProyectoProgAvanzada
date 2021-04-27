package practica1;

public class Urgente implements Facturacion {
    private double sobrecoste;

    public Urgente(double sobrecoste) {
        this.sobrecoste = sobrecoste;
    }
    @Override
    public double calcularFacturacion( double cantidad ) {
        return cantidad + sobrecoste;
    }
}
