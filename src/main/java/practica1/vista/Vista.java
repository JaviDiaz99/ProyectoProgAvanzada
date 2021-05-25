package practica1.vista;

import practica1.Proyecto;
import practica1.controlador.Controlador;
import practica1.modelo.Modelo;

import javax.swing.*;

public interface Vista {
    void setControlador(Controlador controlador);
    void setModelo(Modelo modelo);

    void crearGUI();

    void setProyecto(Proyecto proyecto);

    void mensajeError(String mensaje);

    Proyecto getProyecto();

    String getNombrePersonaDarAlta();
    String getEmailPersonaDarAlta();

    String getTitulo();
    String getDescripcion();
    String getNombrePersonaResponsable();
    String getCoste();
    String getFacturacion();
    String getPrioridad();
    String getDia();
    String getMes();
    String getAño();
    String getResultado();
    String getValorAplicar();

    String nombrePersonaAñadirPersonaTarea();
    String tituloTareaAñadirPersonaTarea();

    String getTituloMarcarTarea();

}
