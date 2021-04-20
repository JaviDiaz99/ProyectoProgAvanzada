package practica1;

public class Descuento implements Facturacion {
    // poder cambiar coste de la tarea y el tipo de la facturación
    private double cantidadDescuento;

    public Descuento(double cantidadDescuento) {
        this.cantidadDescuento = cantidadDescuento;
    }
    @Override
    public double calcularCoste( double cantidad ) {
        return cantidad - ( (cantidad * cantidadDescuento) / 100 );
    }
}
