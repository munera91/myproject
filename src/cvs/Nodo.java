package cvs;

/**
 * Nodo Generico de la lista principal
 * @author Camilo Munera
 * @param <T> el nodo puede ser de cualquier tipo es decir producto, cliente o propietario
 */

public class Nodo<T> {

    public T info;
    public Nodo<T> sig, ant;
}
