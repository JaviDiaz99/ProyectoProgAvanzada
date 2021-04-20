package practica1;

public class ConsumoInterno implements Facturacion {
    @Override
    public double calcularCoste( double cantidad) {
        return cantidad;
    }
}
