package practica1;

import java.util.LinkedList;
import java.util.List;

public class UtilidadesParaListas {
    public static <E extends tieneLista> LinkedList<E> elementosConListaVacia(LinkedList<E> lista ) {
        LinkedList<E> devolver = new LinkedList<E>();
        for ( E obj : lista ) {
            if ( obj.getLista().isEmpty() ) {
                devolver.add(obj);
            }
        }
        return devolver;
    }

    public static <E extends tieneClave & tieneLista> boolean sePuedeInsertar( E objNormal, E objConLista ) {
        List<E> lista = objConLista.getLista();
        for ( E obj : lista ) {
            if ( obj.getClave().equals(objNormal.getClave())) {
                return false;
            }
        }
        return true;
    }
}
