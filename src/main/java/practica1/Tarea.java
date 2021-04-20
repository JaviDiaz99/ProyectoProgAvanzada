package practica1;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Tarea implements Serializable, tieneLista, tieneClave {
    private String título; // título no se repite, es la clave identificadora de la tarea.
    private String descripción;
    private Personas responsable;
    private int prioridad;
    private Date fechaInicio;
    private Date fechaFinal;
    private boolean estaFinalizada;
    private String resultadoEsperado;
    private LinkedList<Personas> listaPersonas;

    @Override
    public String getClave() {
        return título;
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

    public Tarea(String título, String descripción, Personas responsable, int prioridad,
                 Date fechaFinal, boolean estaFinalizada, String resultadoEsperado){
        this.título = título;
        this.descripción = descripción;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaInicio = new Date();
        this.fechaFinal = fechaFinal;
        this.estaFinalizada = estaFinalizada;
        this.resultadoEsperado = resultadoEsperado;
        this.listaPersonas = new LinkedList<>();
    }

    public String getDescripción() {
        return descripción;
    }

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
