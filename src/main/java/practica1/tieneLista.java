package practica1;

import java.util.List;

public interface tieneLista<E extends tieneClave<E> & tieneLista<E>> {
    List<E> getLista();
}
