package practica1.controlador;

import practica1.*;
import practica1.modelo.Modelo;
import practica1.vista.Vista;

import javax.swing.*;
import java.io.IOException;

public interface Controlador {
    /*
    void getDatosNombreProyecto();
    void getDatosAltaPersona();
    void getDatosAnyadirPersonaTarea();
    void getDatosAltaTarea();
    void getDatosMarcarTarea();
    void getDatosCambiarCosteTarea();
    void getDatosCambiarTipoFacturacion();
    void altaPersona();
    void altaPersonaEnTarea();
    void altaTarea();
    void marcarTarea();
    void cambiarCosteTarea();
    void cambiarTipoFacturacion();
     */
    void setModelo(Modelo modelo);
    void setVista(Vista vista);
    void getDatosCrearProyecto(JTextField recuadro);
    void getDatosAbrirProyecto() throws IOException, ClassNotFoundException;
    void getDatosAltaPersona();
    void getDatosAltaTarea();
    void getDatosAnyadirPersonaEnTarea();
    void getDatosMarcarTarea();
}
