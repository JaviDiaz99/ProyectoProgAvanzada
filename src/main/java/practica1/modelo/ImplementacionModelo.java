package practica1.modelo;

import practica1.*;
import practica1.vista.Vista;

import javax.swing.*;
import java.io.*;

import static javax.swing.JFileChooser.*;

public class ImplementacionModelo implements Modelo {
    private Vista vista;

    @Override
    public void setVista(Vista vista) { this.vista = vista; }

    @Override
    public Proyecto crearProyecto(String nombre) {
        return new Proyecto(nombre);
    }

    @Override
    public void abrirProyecto(Proyecto proyecto) throws IOException, ClassNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);
        switch (resultado) {
            case CANCEL_OPTION:
                break;
            case APPROVE_OPTION:
                File f = fileChooser.getSelectedFile();
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                proyecto = (Proyecto)ois.readObject();
                vista.setProyecto(proyecto);
                ois.close();
                break;
            case ERROR_OPTION:
                break;
        }
    }

    @Override
    public void añadirPersona(String nombre, String email) throws PersonaRepetidaException {
        vista.getProyecto().añadirPersona(new Personas(nombre,email));
    }

    @Override
    public void añadirTarea(String titulo, String descripcion, String nombreResponsable, double Coste,
                            Facturacion facturacion, int prioridad, int dia, int mes, int año, String resultado) {
        //vista.getProyecto().añadirTarea(new Tarea(titulo,descripcion,));
    }

    @Override
    public void añadirPersonaEnTarea(String nombrePersona, String titulo) throws PersonaEsNullException,
            NoExisteNombreException, ExistePersonaInscritaEnTareaException, TareaEsNullException, NoExisteTareaException {
        vista.getProyecto().introducirPersonaEnTarea(vista.getProyecto().devolverPersona(nombrePersona)
        ,vista.getProyecto().devolverTarea(titulo));
    }
}
