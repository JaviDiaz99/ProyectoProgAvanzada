package practica1;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Tarea implements Serializable, tieneLista, tieneClave {
    private String titulo; // título no se repite, es la clave identificadora de la tarea.
    private String descripción;
    private Personas responsable;
    private int prioridad;
    private Date fechaInicio;
    private Date fechaFinal;
    private boolean estaFinalizada;
    private String resultadoEsperado;
    private LinkedList<Personas> listaPersonas;
    private double coste;
    private Facturacion tipoFacturacion;

    public Tarea(String titulo, String descripción, Personas responsable, int prioridad,
                 Date fechaFinal, boolean estaFinalizada, String resultadoEsperado, Facturacion tipoFacturacion,
                 double coste){
        this.titulo = titulo;
        this.descripción = descripción;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaInicio = new Date();
        this.fechaFinal = fechaFinal;
        this.estaFinalizada = estaFinalizada;
        this.resultadoEsperado = resultadoEsperado;
        this.listaPersonas = new LinkedList<>();
        this.tipoFacturacion = tipoFacturacion;
        this.coste = coste;
    }
    @Override
    public String getClave() {
        return titulo;
    }
    @Override
    public List getLista() {
        return listaPersonas;
    }

    private LinkedList<Etiqueta> listaEtiquetas;

    public Tarea() { super(); }

    public void marcarFinalizada() {
        this.estaFinalizada = true;
    }

    public String getDescripción() {
        return descripción;
    }

    public double getCoste() { return coste; }

    public int getPrioridad() {
        return prioridad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public Personas getResponsable() {
        return responsable;
    }

    public boolean getEstaFinalizada() {
        return estaFinalizada;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setFacturacion(Facturacion tipoFacturacion ) {
        this.tipoFacturacion = tipoFacturacion;
    }

    public void setCoste( double cambiarCoste ) {
        this.coste = cambiarCoste;
    }

    public double calcularCoste() {
        return tipoFacturacion.calcularCoste(coste);
    }

    public String toString() {
        String devolver = "-Título: " + getClave() + "\n" + "-Descripción: " + getDescripción() + "\n" +
                "-Prioridad: " + getPrioridad() + "\n" + "-Fecha inicio: " + getFechaInicio().toString() + "\n" +
                "-Fecha final: " + getFechaFinal().toString() + "\n" + "-Personas inscritas: ";
        for ( Personas objPersona : listaPersonas ) {
            devolver += objPersona.getClave() + " ";
        }
        devolver += "\n" + "-Persona responsable: " + getResponsable().getClave() + "\n" +
                ( (getEstaFinalizada()) ? "-Está finalizada" : "-No está finalizada")  + "\n" +
                "-Resultado esperado: " + getResultadoEsperado() + "\n";
        return devolver;
    }
}
