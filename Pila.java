package actividad2;

import actividad1.LinkedList;

public class Pila {
    private LinkedList lista;

    public Pila() {
        lista = new LinkedList("simple");
    }

    public void push(Object comando) {
        lista.insertarAlInicio(comando);
    }

    public Object pop() {
        return lista.eliminarPrimero();
    }

    // Peek: obtener el tope sin eliminarlo
    public Object peek() {
        return lista.obtenerPrimero();
    }

    public boolean estaVacia() {
        return lista.cabeza == null;
    }

    public void mostrar() {
        System.out.println("=== PILA DE COMANDOS ===");
        lista.mostrar();
    }
}


