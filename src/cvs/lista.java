package cvs;

public class lista<T> {

    public Nodo<T> cab, cola, actual;

    public Nodo fijarAlInicioApuntadorActual() {
        actual = cab;
        return actual;
    }

    public Nodo sigNodo() {
        actual = actual.sig;
        return actual;
    }

    public void add(T e) {
        Nodo p = new Nodo();
        p.info = e;
        p.sig = null;

        if (cab == null && cola == null) {
            // insertar primer nodo de la lista
            cab = p;
            cola = p;
            p.ant = null;
            cola = p;
        } else {
            // la  lista tiene almenos un nodo
            p.ant = cola;
            cola.sig = p;
            cola = p;
        }
    }

    public void imprimirDeIzqAder() {
        for (Nodo t = cab; t != null; t = t.sig) {
            System.out.println(t.info);
        }
    }

    public void imprimirDeDerAizq() {
        for (Nodo t = cola; t != null; t = t.ant) {
            System.out.println(t.info);
        }
    }

    public int size() {
        Nodo t = cab;
        int cont = 0;

        while (t != null) {

            cont = cont + 1;
            t = t.sig;

        }

        return cont;
    }

    public Nodo<T> get(int i) {
        Nodo t = cab;
        int cont = 0;

        while (t != null) {
            if (cont == i) {
                return t;
            }
            cont = cont + 1;
            t = t.sig;

        }

        return null;
    }

    public void borrarNodo(T e) {
        Nodo t = cab;
        while (t != null) {
            if (cab == e) {
                if (cab == cola) {
                    // Borrar unico nodo de la lista
                    cab = cola = null;
                } else {
                    if (cab == t) {
                        // Borrar el primer nodo de la lista
                        cab = cab.sig;
                        cab.ant = null;
                    } else {
                        if (cola == t) {
                            // Borrar el último nodo de la lista
                            cola = cola.ant;
                            cola.sig = null;
                        } else {
                            // Borrar nodo intermedio
                            (t.ant).sig = t.sig;
                            (t.sig).ant = t.ant;
                        }
                    }
                }
            }
            t = t.sig;

        }
       
    }

    public Nodo<T> borrar(int i) {
        Nodo t = cab;
        int cont = 0;

        while (t != null) {
            if (cont == i) {
                if (cab == cola) {
                    // Borrar unico nodo de la lista
                    cab = cola = null;
                } else {
                    if (cab == t) {
                        // Borrar el primer nodo de la lista
                        cab = cab.sig;
                        cab.ant = null;
                    } else {
                        if (cola == t) {
                            // Borrar el último nodo de la lista
                            cola = cola.ant;
                            cola.sig = null;
                        } else {
                            // Borrar nodo intermedio
                            (t.ant).sig = t.sig;
                            (t.sig).ant = t.ant;
                        }
                    }
                }
            }
            cont = cont + 1;
            t = t.sig;

        }

        return null;
    }

}
