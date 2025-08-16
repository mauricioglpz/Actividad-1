package actividad1;

public class LinkedList {
    Node cabeza;
    Node cola;
    String tipoLista; 

    public LinkedList(String tipoLista) {
        this.cabeza = null;
        this.cola = null;
        this.tipoLista = tipoLista.toLowerCase();
    }

    public void insertar(Object datos) {
        Node nuevoNodo = new Node(datos);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            if (tipoLista.equals("circular")) {
                cabeza.siguiente = cabeza;
            }
        } else {
            if (tipoLista.equals("simple")) {
                cola.siguiente = nuevoNodo;
                cola = nuevoNodo;
            } else if (tipoLista.equals("doble")) {
                cola.siguiente = nuevoNodo;
                nuevoNodo.anterior = cola;
                cola = nuevoNodo;
            } else if (tipoLista.equals("circular")) {
                nuevoNodo.siguiente = cabeza;
                cola.siguiente = nuevoNodo;
                cola = nuevoNodo;
            }
        }
    }

    public boolean eliminar(Object datos) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.datos.equals(datos)) {
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                if (tipoLista.equals("circular")) {
                    cola.siguiente = cabeza;
                }
            }
            return true;
        }

        Node actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.datos.equals(datos)) {
            actual = actual.siguiente;
            if (tipoLista.equals("circular") && actual.siguiente == cabeza) {
                return false;
            }
        }

        if (actual.siguiente != null) {
            if (actual.siguiente == cola) {
                cola = actual;
            }
            if (tipoLista.equals("doble")) {
                if (actual.siguiente.siguiente != null) {
                    actual.siguiente.siguiente.anterior = actual;
                }
            }
            actual.siguiente = actual.siguiente.siguiente;
            return true;
        }

        return false;
    }

    public Node buscar(Object datos) {
        Node actual = cabeza;
        if (actual == null) {
            return null;
        }
        do {
            if (actual.datos.equals(datos)) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != null && actual != cabeza);
        return null;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node actual = cabeza;
        System.out.println("Elementos de la lista (" + tipoLista + "):");
        do {
            System.out.println("-> " + actual.datos.toString());
            actual = actual.siguiente;
        } while (actual != null && actual != cabeza);
    }
}

