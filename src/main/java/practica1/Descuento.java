package practica1;

import java.io.Serializable;

public class Descuento implements Facturacion, Serializable {
    // poder cambiar coste de la tarea y el tipo de la facturación
    private double cantidadDescuento;

    public Descuento(double cantidadDescuento) {
        this.cantidadDescuento = cantidadDescuento;
    }
    @Override
    public double calcularFacturacion( double cantidad ) {
        return cantidad - ( (cantidad * cantidadDescuento) / 100 );
    }
}
