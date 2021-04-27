package practica1;

import java.io.Serializable;

public class ConsumoInterno implements Facturacion, Serializable {
    @Override
    public double calcularFacturacion(double cantidad) {
        return cantidad;
    }
}
