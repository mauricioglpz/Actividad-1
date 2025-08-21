package actividad1;

public class LinkedList {
    public Node cabeza;
    public Node cola;
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
                nuevoNodo.setAnterior(cola);
                cola = nuevoNodo;
            } else if (tipoLista.equals("circular")) {
                nuevoNodo.siguiente = cabeza;
                cola.siguiente = nuevoNodo;
                cola = nuevoNodo;
            }
        }
    }

    // NUEVO MÉTODO: Insertar al inicio (eficiente para pilas)
    public void insertarAlInicio(Object datos) {
        Node nuevoNodo = new Node(datos);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            if (tipoLista.equals("circular")) {
                cabeza.siguiente = cabeza;
            }
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
            if (tipoLista.equals("doble")) {
                cabeza.siguiente.anterior = cabeza;
            } else if (tipoLista.equals("circular")) {
                cola.siguiente = cabeza;
            }
        }
    }

    // NUEVO MÉTODO: Eliminar el primer elemento (eficiente para colas)
    public Object eliminarPrimero() {
        if (cabeza == null) {
            return null;
        }
        Object datosEliminados = cabeza.datos;
        
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
            if (tipoLista.equals("doble") && cabeza != null) {
                cabeza.anterior = null;
            } else if (tipoLista.equals("circular")) {
                cola.siguiente = cabeza;
            }
        }
        return datosEliminados;
    }

    // NUEVO MÉTODO: Eliminar el último elemento (eficiente para pilas)
    public Object eliminarUltimo() {
        if (cabeza == null) {
            return null;
        }
        Object datosEliminados = cola.datos;
        
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            if (tipoLista.equals("doble")) {
                cola = cola.anterior;
                cola.siguiente = null;
            } else if (tipoLista.equals("simple")) {
                Node actual = cabeza;
                while (actual.siguiente != cola) {
                    actual = actual.siguiente;
                }
                cola = actual;
                cola.siguiente = null;
            } else if (tipoLista.equals("circular")) {
                Node actual = cabeza;
                while (actual.siguiente != cola) {
                    actual = actual.siguiente;
                }
                cola = actual;
                cola.siguiente = cabeza;
            }
        }
        return datosEliminados;
    }

    // NUEVO MÉTODO: Obtener el primer elemento sin eliminarlo
    public Object obtenerPrimero() {
        return (cabeza != null) ? cabeza.datos : null;
    }

    // NUEVO MÉTODO: Obtener el último elemento sin eliminarlo
    public Object obtenerUltimo() {
        return (cola != null) ? cola.datos : null;
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
                } else if (tipoLista.equals("doble") && cabeza != null) {
                    cabeza.anterior = null;
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
            
            if (tipoLista.equals("circular") && actual.siguiente == null) {
                actual.siguiente = cabeza;
            }
            
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
            if (actual.datos.equals(datos) || actual.datos == datos) {
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

