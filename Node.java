package actividad1;

public class Node {
    public Object datos;
    public Node siguiente;
    Node anterior;
    public Node next;
    public String data;

    public Node(Object datos) {
        this.datos = datos;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getDatos() { return datos; }
    public void setDatos(Object datos) { this.datos = datos; }

    public Node getSiguiente() { return siguiente; }
    public void setSiguiente(Node siguiente) { this.siguiente = siguiente; }

    public Node getAnterior() { return anterior; }
    public void setAnterior(Node anterior) { this.anterior = anterior; }
}
