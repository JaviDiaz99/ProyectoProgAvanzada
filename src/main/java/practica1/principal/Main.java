package practica1.principal;

import practica1.controlador.Controlador;
import practica1.controlador.ImplementacionControlador;
import practica1.modelo.ImplementacionModelo;
import practica1.modelo.Modelo;
import practica1.vista.ImplementacionVista;
import practica1.vista.Vista;

public class Main {
    public static void main(String[] args ) {
        Vista vista = new ImplementacionVista();
        Modelo modelo = new ImplementacionModelo();
        Controlador controlador = new ImplementacionControlador();

        vista.setControlador(controlador);
        vista.setModelo(modelo);

        modelo.setVista(vista);

        controlador.setModelo(modelo);
        controlador.setVista(vista);

        vista.crearGUI();
    }
}
