package actividad2;

import actividad1.LinkedList;

public class Cola {
    private LinkedList lista;

    public Cola() {
        lista = new LinkedList("simple");
    }
    public void enqueue(Object programa) {
        lista.insertar(programa);
    }
    public Object dequeue() {
        return lista.eliminarPrimero();
    }

    public Object peek() {
        return lista.obtenerPrimero();
    }

    public boolean estaVacia() {
        return lista.cabeza == null;
    }

    public void mostrar() {
        System.out.println("=== COLA DE PROGRAMAS ===");
        lista.mostrar();
    }
}



