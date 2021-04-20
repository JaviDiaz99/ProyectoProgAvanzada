package practica1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Personas implements Serializable,tieneLista, tieneClave { // lista tareas de las que es responsable y deben existir en la lista de tareas
    private String nombre; // nombre no se repite, es la clave identificativa, no se repite
    private String correo;
    private LinkedList<Tarea> tareasResponsable;

    public Personas() {
        super();
    }
    public Personas(String nombre, String correo ) {
        this.nombre=nombre;
        this.correo=correo;
        this.tareasResponsable = new LinkedList<>();
    }

    @Override
    public List getLista() { return tareasResponsable; }

    @Override
    public String getClave() {
        return nombre;
    }

    @Override
    public String toString() {
        String devolver = "-Nombre= " + nombre + "\n" +
                "-Correo= " + correo + "\n" +
                "-TareasResponsable= ";
        for ( Tarea i : tareasResponsable ) {
            devolver += i.getClave() + ", ";
        }
        devolver += "\n";
        return devolver;
    }
}
