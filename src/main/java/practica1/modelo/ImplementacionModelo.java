package practica1.modelo;

import practica1.Proyecto;
import practica1.vista.Vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ImplementacionModelo implements Modelo {
    private Vista vista;
    @Override
    public Proyecto crearProyecto(String nombre) {
        return new Proyecto(nombre);
    }

    @Override
    public Proyecto abrirProyecto(String nombre) {
        Proyecto objProyecto = null;
        try {
            FileInputStream fis = new FileInputStream(nombre + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            objProyecto = (Proyecto) ois.readObject();
            ois.close();
        } catch ( FileNotFoundException e ) {
            System.out.println("No existe el nombre del fichero, vuelvalo a escribir:");
            nombre = vista.next();
        } catch (IOException | ClassNotFoundException e ){
            e.printStackTrace();
        }
        return objProyecto;
    }
}
