package practica1;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class    Principal implements Serializable {
    private static final long serialVersionUID = -1065341850225848464L;

    public static void main( String[] args ) throws PersonaRepetidaException, ExistePersonaInscritaEnTareaException,
            TareaRepetidaException, NoExisteNombreException, NoExisteTareaException,
            NoExistePersonaInscritaEnTareaException {
        Proyecto objProyecto = crearProyecto();
        boolean salir = false;
        int opcion;
        while(!salir){
            opcion = elegirOption();
            switch(opcion){
                case 1: darAltaPersonas(objProyecto); break;
                case 2: darAltaTareas(objProyecto); break;
                case 3: marcarTarea(objProyecto); break;
                case 4: addPersonaEnTarea(objProyecto); break;
                case 5: removePersonaEnTarea(objProyecto); break;
                case 6: listarPersonas(objProyecto); break;
                case 7: listarTareas(objProyecto); break;
                case 8: listarTareasSinPersonas(objProyecto); break;
                case 9: cambiarCosteTarea(objProyecto); break;
                case 10: cambiarTipoFacturacion(objProyecto); break;
                case 11: calcularCosteProyecto(objProyecto); break;
                case 12: almacenarDatos(objProyecto); salir=true; break;
                default: System.out.println("Solo pueden ser números entre 1 y 9");
            }
        }
    }
    public static int elegirOption () {
        System.out.println("1. Dar alta personas");
        System.out.println("2. Dar alta tareas");
        System.out.println("3. Marcar tarea como finalizada");
        System.out.println("4. Introducir persona en una tarea");
        System.out.println("5. Eliminar persona de una tarea");
        System.out.println("6. Listar personas");
        System.out.println("7. Listar tareas");
        System.out.println("8. Listar tareas sin personas asignadas");
        System.out.println("9. Cambiar coste de una tarea");
        System.out.println("10. Cambiar tipo de facturación de una tarea");
        System.out.println("11. Calcular coste total del proyecto");
        System.out.println("12. Salir\n");
        System.out.println("Escribe una de las opciones: ");
        Scanner sn = new Scanner(System.in);
        return sn.nextInt();
    }
    public static Proyecto crearProyecto() {
        System.out.println("Elija una opción para crear proyecto:\n\n1. Crear nuevo proyecto\n2. Abrir proyecto\n");
        Proyecto objProyecto = null;
        boolean salir = false;
        boolean condicion = false;
        Scanner sn = new Scanner(System.in);
        while(!salir){
            int opcion = sn.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Introduce el nombre de proyecto: ");
                    objProyecto = new Proyecto(sn.next());
                    salir = true;
                    break;
                case 2:
                    System.out.println("Introduce el nombre de proyecto a abrir: ");
                    String nombre = sn.next();
                    while ( ! condicion ) {
                        try {
                            FileInputStream fis = new FileInputStream(nombre + ".bin");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            objProyecto = (Proyecto) ois.readObject();
                            ois.close();
                            condicion = true;
                        } catch ( FileNotFoundException e ) {
                            System.out.println("No existe el nombre del fichero, vuelvalo a escribir:");
                            nombre = sn.next();
                        } catch (IOException | ClassNotFoundException e ){
                            e.printStackTrace();
                        }
                    }
                    salir = true;
                    break;
                default:
                    System.out.println("Solo pueden ser números entre 1 y 2\n");
                    System.out.println("Introduce una nueva opción:");
            }
        }
        return objProyecto;
    }
    public static void darAltaPersonas(Proyecto objProyecto) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opcion 1\n");
        System.out.println("Introduce nombre de la persona: ");
        String nombre = sn.next();
        boolean condicion = true;
        while ( condicion ) {
            try {
                objProyecto.añadirPersona(new Personas(nombre,nombre+"@gmail.com"));
                condicion = false;
            } catch ( PersonaRepetidaException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo nombre de persona: ");
                nombre = sn.next();
            }
        }
    }
    public static void darAltaTareas( Proyecto objProyecto ) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opcion 2\n");
        System.out.println("Introduce el nombre del título: ");
        String titulo = sn.next();
        System.out.println("Introduce una descripción: ");
        String descripcion = sn.next();
        System.out.println("Introduce el nombre de la persona responsable: ");
        double coste = sn.nextDouble();
        System.out.println("Introduce el coste de la tarea: ");
        String nombrePersona = sn.next();
        System.out.println("Introduce un número para elegir el tipo de facturación:\n1. Consumo interno\n2. Descuento" +
                "\n3. Urgente ");
        boolean salir = false;
        Facturacion objFacturacion = null;
        while ( ! salir ) {
            int opcion = sn.nextInt();
            switch ( opcion ) {
                case 1:
                    objFacturacion = new ConsumoInterno();
                    salir = true;
                    break;
                case 2:
                    objFacturacion = new Descuento(coste);
                    salir = true;
                    break;
                case 3:
                    objFacturacion = new Urgente(coste);
                    salir=true;
                    break;
                default: System.out.println("Solo pueden ser números entre 1 y 3: ");
            }
        }
        System.out.println("Introduce la prioridad de la tarea: ");
        int prioridad = sn.nextInt();
        System.out.println("Introduce el año de la finalización de la tarea: ");
        int año = sn.nextInt();
        System.out.println("Introduce el mes de la finalización de la tarea: ");
        int mes = sn.nextInt();
        System.out.println("Introduce el día de la finalización de la tarea: ");
        int dia = sn.nextInt();
        System.out.println("Introduce el resultado esperado: ");
        String resultado = sn.next();
        boolean condicion = true;
        while ( condicion ) {
            try {
                objProyecto.añadirTarea(new Tarea(titulo, descripcion, objProyecto.devolverPersona(nombrePersona),
                        prioridad,new Date(año-1900,mes-1,dia),false,resultado,objFacturacion,
                        coste));
                condicion = false;
            } catch ( TareaRepetidaException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo título de la tarea: ");
                titulo = sn.next();
            } catch ( NoExisteNombreException | PersonaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo nombre de persona: ");
                nombrePersona = sn.next();
            } catch ( PrioridadErroneaException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce una nueva prioridad: ");
                prioridad = sn.nextInt();
            } catch ( FechaInicialAntesFinalException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce el nuevo año de la finalización de la tarea: ");
                año = sn.nextInt();
                System.out.println("Introduce el nuevo mes de la finalización de la tarea: ");
                mes = sn.nextInt();
                System.out.println("Introduce el nuevo día de la finalización de la tarea: ");
                dia = sn.nextInt();
            } catch (CosteNegativoException e) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo coste: ");
                coste = sn.nextDouble();
            }
        }
    }
    public static void marcarTarea( Proyecto objProyecto ) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opcion 3\n");
        System.out.println("Introduce título de la tarea: ");
        String titulo = sn.next();
        boolean condicion = true;
        while ( condicion ) {
            try {
                objProyecto.marcarFinalizada(objProyecto.getListaTareas().get(titulo));
                condicion = false;
            } catch ( TareaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo título de la tarea: ");
                titulo = sn.next();
            }
        }
    }
    public static void addPersonaEnTarea( Proyecto objProyecto ) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opcion 4\n");
        System.out.println("Introduce nombre de la persona: ");
        String nombre = sn.next();
        System.out.println("Introduce título de la tarea: ");
        String titulo = sn.next();
        boolean condicion = true;
        while ( condicion ) {
            try {
                objProyecto.introducirPersonaEnTarea(objProyecto.devolverPersona(nombre),
                        objProyecto.devolverTarea(titulo));
                condicion = false;
            } catch ( NoExisteTareaException | TareaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo título de la tarea: ");
                titulo = sn.next();
            } catch ( NoExisteNombreException | PersonaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo nombre de persona: ");
                nombre = sn.next();
            } catch ( ExistePersonaInscritaEnTareaException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo nombre de persona: ");
                nombre = sn.next();
            }
        }
    }
    public static void removePersonaEnTarea( Proyecto objProyecto ) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opcion 5\n");
        System.out.println("Introduce nombre de la persona: ");
        String nombre = sn.next();
        System.out.println("Introduce título de la tarea: ");
        String titulo = sn.next();
        boolean condicion = true;
        while ( condicion ) {
            try {
                objProyecto.eliminarPersonaEnTarea(objProyecto.getListaPersonas().get(nombre),
                        objProyecto.devolverTarea(titulo));
                condicion = false;
            } catch ( NoExisteTareaException | TareaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo título de la tarea: ");
                titulo = sn.next();
            } catch ( NoExisteNombreException | PersonaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo nombre de persona: ");
                nombre = sn.next();
            } catch ( NoExistePersonaInscritaEnTareaException e ) {
                // puedo añadir función para que cree la tarea y añada
                System.out.println(e.getMessage());
                condicion = false;
            }
        }
    }
    public static void listarPersonas( Proyecto objProyecto ) {
        System.out.println("Has seleccionado la opcion 6\n");
        if ( objProyecto.getListaPersonas().keySet().isEmpty() ) {
            System.out.println("No existe ninguna persona dada de alta");
        } else {
            for ( String i : objProyecto.getListaPersonas().keySet() ) {
                System.out.println(objProyecto.getListaPersonas().get(i).toString());
            }
        }
    }
    public static void listarTareas( Proyecto objProyecto ) {
        System.out.println("Has seleccionado la opcion 7\n");
        if ( objProyecto.getListaTareas().keySet().isEmpty() ) {
            System.out.println("No existe ninguna tarea dada de alta\n");
        } else {
            for ( String i : objProyecto.getListaTareas().keySet() ) {
                System.out.println(objProyecto.getListaTareas().get(i).toString());
            }
        }
    }
    public static void listarTareasSinPersonas( Proyecto objProyecto ) {
        System.out.println("Has seleccionado la opcion 8\n");
        LinkedList<Tarea> lista = new LinkedList<>();
        lista.addAll(objProyecto.getListaTareas().values());
        if ( UtilidadesParaListas.elementosConListaVacia(lista).isEmpty() ) {
            System.out.println("No existe ninguna tarea sin personas asignadas\n");
        } else {
            for ( Tarea i : UtilidadesParaListas.elementosConListaVacia(lista) ) {
                System.out.println(i.toString());
            }
        }
    }
    public static void cambiarCosteTarea( Proyecto objProyecto ) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opcion 9\n");
        System.out.println("Introduce título de la tarea: ");
        String titulo = sn.next();
        System.out.println("Introduce coste de la tarea: ");
        double coste = sn.nextDouble();
        boolean condicion = true;
        while ( condicion ) {
            try {
                objProyecto.cambiarCosteTarea(objProyecto.devolverTarea(titulo),coste);
                condicion = false;
            } catch ( TareaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo título de la tarea: ");
                titulo = sn.next();
            } catch (CosteNegativoException e) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo coste: ");
                coste = sn.nextDouble();
            }
        }
    }
    public static void cambiarTipoFacturacion( Proyecto objProyecto ) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Has seleccionado la opcion 10\n");
        System.out.println("Introduce título de la tarea: ");
        String titulo = sn.next();
        Facturacion objFacturacion = elegirFacturacion();
        boolean salir=false;
        while ( ! salir ) {
            try {
                objProyecto.cambiarTipoFacturacionTarea(objProyecto.devolverTarea(titulo),objFacturacion);
                salir = true;
            } catch ( NoExisteTareaException | TareaEsNullException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo título de la tarea: ");
                titulo = sn.next();
            } catch ( MismoTipoFacturacionException e ) {
                System.out.println(e.getMessage());
                System.out.println("Introduce un nuevo tipo de facturación: ");
                objFacturacion = elegirFacturacion();
            }
        }
    }
    public static void calcularCosteProyecto( Proyecto objProyecto ) {
        System.out.println("Has seleccionado la opcion 11\n");
        System.out.println("El coste total del proyecto es " + objProyecto.calcularCosteTotalProyecto() + "€");
    }
    public static void almacenarDatos(Proyecto objProyecto) {
        try {
            FileOutputStream fos = new FileOutputStream(objProyecto.getNombre() + ".bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objProyecto);
            oos.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        System.out.println("¡Hasta luego!");
    }
    // Funciones Auxiliares
    public static Facturacion elegirFacturacion() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Introduce un número para elegir el tipo de facturación a cambiar:" +
                "\n1. Consumo interno" + "\n2. Descuento" + "\n3. Urgente ");
        boolean salir = false;
        Facturacion objFacturacion = null;
        while (!salir) {
            int opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    objFacturacion = new ConsumoInterno();
                    salir = true;
                    break;
                case 2:
                    objFacturacion = new Descuento(introducirDescuentoOsobrecoste(opcion));
                    salir = true;
                    break;
                case 3:
                    objFacturacion = new Urgente(introducirDescuentoOsobrecoste(opcion));
                    salir = true;
                    break;
                default:
                    System.out.println("Solo pueden ser números entre 1 y 3: ");
            }
        }
        return objFacturacion;
    }
    public static double introducirDescuentoOsobrecoste(int opcion) {
        Scanner sn = new Scanner(System.in);
        boolean condicion = false;
        String nombre = ( opcion == 2 ) ? "descuento":"sobrecoste";
        System.out.println("Introduce un nuevo " + nombre + ": ");
        double parametro = sn.nextDouble();
        while ( ! condicion ) {
            if ( parametro < 0 ) {
                System.out.println("El " + nombre + " no puede ser menor que 0");
                System.out.println("Introduce un nuevo " + nombre + ": ");
                parametro = sn.nextDouble();
            } else {
                condicion = true;
            }
        }
        return parametro;
    }
}