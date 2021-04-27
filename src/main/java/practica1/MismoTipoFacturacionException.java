package practica1;

public class MismoTipoFacturacionException extends Exception {
    public MismoTipoFacturacionException() { super("El tipo de facturación inicial no puede ser igual que el inicial");
    }
}
