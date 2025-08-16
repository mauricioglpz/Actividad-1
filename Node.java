package actividad1;

public class Node {
    Object datos;
    Node siguiente;
    Node anterior; 

    public Node(Object datos) {
        this.datos = datos;
        this.siguiente = null;
        this.anterior = null;
    }
}

