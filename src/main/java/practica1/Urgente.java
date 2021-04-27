package practica1;

import java.awt.*;
import java.io.Serializable;

public class Urgente implements Facturacion, Serializable {
    private double sobrecoste;

    public Urgente(double sobrecoste) {
        this.sobrecoste = sobrecoste;
    }
    @Override
    public double calcularFacturacion( double cantidad ) {
        return cantidad + sobrecoste;
    }
}
