package practica1;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void existePersona() throws PersonaRepetidaException {
        Proyecto objProyecto = new Proyecto("Nintendo Switch");
        Personas objPersona = new Personas("Pepe","pepe@gmail.com");
        objProyecto.añadirPersona(objPersona);
        assertTrue( objProyecto.existePersona("Pepe"));
        assertFalse( objProyecto.existePersona("Mariló"));
    }

    @Test
    void añadirPersona() throws PersonaRepetidaException {
        Proyecto objProyecto = new Proyecto("PSP");
        Personas objPersona = new Personas("Jose","Jose@gmail.com");
        objProyecto.añadirPersona(objPersona);
        assertTrue( objProyecto.existePersona("Jose"));
        assertFalse( objProyecto.existePersona("Mariló"));
    }

    @Test
    void existeTarea() throws TareaRepetidaException, NoExisteNombreException, PersonaRepetidaException,
            PersonaEsNullException, PrioridadErroneaException, FechaInicialAntesFinalException, CosteNegativoException {
        Proyecto objProyecto = new Proyecto("PC Gaming");
        Personas objResponsable = new Personas("Manuel","Manuel@gmail.com");
        objProyecto.añadirPersona(objResponsable);
        Facturacion objFacturacion = new ConsumoInterno();
        Tarea objTarea = new Tarea("Reparar placa base","No tocar ventilador",
                objResponsable,5,new Date(2022 - 1900,6 - 1
                ,10),false,"Crear PC Gaming marca Razer",new ConsumoInterno(),0);
        objProyecto.añadirTarea(objTarea);
        assertTrue( objProyecto.existeTarea("Reparar placa base"));
        assertFalse( objProyecto.existeTarea("Limpiar ventiladores"));
    }

    @Test
    void añadirTarea() throws TareaRepetidaException, NoExisteNombreException, PersonaRepetidaException,
            PersonaEsNullException, PrioridadErroneaException, FechaInicialAntesFinalException, CosteNegativoException {
        Proyecto objProyecto = new Proyecto("PC Gaming");
        Personas objResponsable = new Personas("Manuel","Manuel@gmail.com");
        Tarea objTarea = new Tarea("Reparar placa base","No tocar ventilador",
                objResponsable,5,new Date(2022 - 1900,6 - 1,10),false,
                "Crear PC Gaming marca Razer",new ConsumoInterno(),0);
        objProyecto.añadirPersona(objResponsable);
        objProyecto.añadirTarea(objTarea);
        assertTrue( objProyecto.existeTarea("Reparar placa base"));
        assertFalse( objProyecto.existeTarea("Limpiar ventiladores"));
    }

    @Test
    void marcarFinalizada() throws TareaRepetidaException, NoExisteNombreException, PersonaRepetidaException,
            PersonaEsNullException, PrioridadErroneaException, FechaInicialAntesFinalException, TareaEsNullException,
            CosteNegativoException {
        Proyecto objProyecto = new Proyecto("PC Gaming");
        Personas objResponsable = new Personas("Manuel","Manuel@gmail.com");
        objProyecto.añadirPersona(objResponsable);
        Tarea objTarea = new Tarea("Reparar placa base","No tocar ventilador",
                objResponsable,5,new Date(2024 - 1900,4 - 1,
                10),false,"Crear PC Gaming marca Razer",new ConsumoInterno(),0);
        objProyecto.añadirTarea(objTarea);
        objProyecto.marcarFinalizada(objTarea);
        Tarea objTareaAñadida = objProyecto.getListaTareas().get("Reparar placa base");
        objTareaAñadida.marcarFinalizada();
        assertTrue( objTareaAñadida.getEstaFinalizada() );
    }

    @Test
    void introducirPersonaEnTarea() throws ExistePersonaInscritaEnTareaException, NoExisteTareaException,
            NoExisteNombreException, TareaRepetidaException, PersonaRepetidaException, PersonaEsNullException,
            PrioridadErroneaException, FechaInicialAntesFinalException, TareaEsNullException, CosteNegativoException {
        Proyecto objProyecto = new Proyecto("PC Gaming");
        Personas objResponsable = new Personas("Manuel","Manuel@gmail.com");
        objProyecto.añadirPersona(objResponsable);
        Personas objResponsable2 = new Personas("Maria","Maria@gmail.com");
        Tarea objTarea = new Tarea("Reparar placa base","No tocar ventilador",
                objResponsable,5,new Date(2022 - 1900,6 - 1,
                10),false,"Crear PC Gaming marca Razer",new ConsumoInterno(),0);
        objProyecto.añadirTarea(objTarea);
        objProyecto.introducirPersonaEnTarea(objResponsable,objTarea);
        assertTrue( objTarea.getLista().contains(objResponsable));
        assertFalse( objTarea.getLista().contains(objResponsable2));
    }

    @Test
    void eliminarPersonaEnTarea() throws TareaRepetidaException, PersonaRepetidaException,
            NoExistePersonaInscritaEnTareaException, NoExisteTareaException, NoExisteNombreException,
            ExistePersonaInscritaEnTareaException, PersonaEsNullException, PrioridadErroneaException,
            FechaInicialAntesFinalException, TareaEsNullException, CosteNegativoException {
        Proyecto objProyecto = new Proyecto("PC Gaming");
        Personas objResponsable = new Personas("Manuel","Manuel@gmail.com");
        Personas objResponsable2 = new Personas("Maria","Maria@gmail.com");
        objProyecto.añadirPersona(objResponsable);
        objProyecto.añadirPersona(objResponsable2);
        Tarea objTarea = new Tarea("Reparar placa base","No tocar ventilador",
                objResponsable,5,new Date(2023 - 1900,6 - 1,
                10),false,"Crear PC Gaming marca Razer",new ConsumoInterno(),0);
        objProyecto.añadirTarea(objTarea);
        objProyecto.introducirPersonaEnTarea(objResponsable,objTarea);
        objProyecto.introducirPersonaEnTarea(objResponsable2,objTarea);
        objProyecto.eliminarPersonaEnTarea(objResponsable,objTarea);
        assertFalse( objTarea.getLista().contains(objResponsable));
        assertTrue( objTarea.getLista().contains(objResponsable2));
    }
    @Test
    void elementosConListaVacia() throws PersonaRepetidaException, PersonaEsNullException,
            TareaRepetidaException, NoExisteNombreException, PrioridadErroneaException,
            FechaInicialAntesFinalException, CosteNegativoException {
        Proyecto objProyecto = new Proyecto("PC Gaming");
        Personas objResponsable = new Personas("Manuel","Manuel@gmail.com");
        Personas objResponsable2 = new Personas("Maria","Maria@gmail.com");
        objProyecto.añadirPersona(objResponsable);
        objProyecto.añadirPersona(objResponsable2);
        Tarea objTarea = new Tarea("Reparar placa base","No tocar ventilador",
                objResponsable,5,new Date(2024 - 1900,6 - 1,
                10),false,"Crear PC Gaming marca Razer",new ConsumoInterno(),0);
        Tarea objTarea2 = new Tarea("Reparar ventiladores","RAM quemada",
                objResponsable,5,new Date(2024 - 1900,6 - 1
                ,10),false,"Crear PC Asus",new ConsumoInterno(),0);
        objProyecto.añadirTarea(objTarea);
        objProyecto.añadirTarea(objTarea2);
        LinkedList<Personas> listaAux = new LinkedList<>();
        listaAux.add(objResponsable);
        listaAux.add(objResponsable2);
        LinkedList<Personas> listaPrueba = UtilidadesParaListas.elementosConListaVacia(listaAux);
        assertTrue( listaPrueba.contains(objResponsable2));
        assertFalse( listaPrueba.contains(objResponsable));
    }
    @Test
    void tieneClave() throws PersonaRepetidaException, PersonaEsNullException,
            TareaRepetidaException, NoExisteNombreException, NoExisteTareaException,
            ExistePersonaInscritaEnTareaException, PrioridadErroneaException,
            FechaInicialAntesFinalException, TareaEsNullException, CosteNegativoException {
        Proyecto objProyecto = new Proyecto("PC Gaming");
        Personas objResponsable = new Personas("Manuel","Manuel@gmail.com");
        Personas objResponsable2 = new Personas("Maria","Maria@gmail.com");
        Personas objResponsable3 = new Personas("Miguel","Miguel@gmail.com");
        objProyecto.añadirPersona(objResponsable);
        objProyecto.añadirPersona(objResponsable2);
        objProyecto.añadirPersona(objResponsable3);
        Tarea objTarea = new Tarea("Reparar placa base","No tocar ventilador",
                objResponsable,5,new Date(2024 - 1900,6 - 1
                ,10),false,"Crear PC Gaming marca Razer",new ConsumoInterno(),0);
        objProyecto.añadirTarea(objTarea);
        objProyecto.introducirPersonaEnTarea(objResponsable,objTarea);
        objProyecto.introducirPersonaEnTarea(objResponsable2,objTarea);
        assertTrue( UtilidadesParaListas.sePuedeInsertar(objResponsable3,objTarea));
        assertFalse( UtilidadesParaListas.sePuedeInsertar(objResponsable,objTarea));
    }
}