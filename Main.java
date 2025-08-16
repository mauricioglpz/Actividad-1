package actividad1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList listaActual;

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
    public static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. seleccionar tipo de lista");
            System.out.println("2. operaciones con la lista actual");
            System.out.println("3. ver ejemplos de tipos de datos");
            System.out.println("4. salir");
            System.out.print("elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    seleccionarTipoLista();
                    break;
                case 2:
                    if (listaActual == null) {
                        System.out.println("primero debes seleccionar un tipo de lista.");
                    } else {
                        mostrarMenuOperaciones();
                    }
                    break;
                case 3:
                    verEjemplosTiposDatos();
                    break;
                case 4:
                    System.out.println("saliendo del programa... bye !");
                    break;
                default:
                    System.out.println("opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 4);
    }
    public static void seleccionarTipoLista() {
        int opcion;
        System.out.println("\n--- Seleccionar Tipo de Lista ---");
        System.out.println("1. Lista Simplemente Enlazada");
        System.out.println("2. Lista Doblemente Enlazada");
        System.out.println("3. Lista Circular");
        System.out.print("Elige un tipo: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                listaActual = new LinkedList("simple");
                System.out.println("Lista Simplemente Enlazada seleccionada.");
                break;
            case 2:
                listaActual = new LinkedList("doble");
                System.out.println("Lista Doblemente Enlazada seleccionada.");
                break;
            case 3:
                listaActual = new LinkedList("circular");
                System.out.println("Lista Circular seleccionada.");
                break;
            default:
                System.out.println("Opción no válida. Volviendo al menú principal.");
        }
    }
    public static void mostrarMenuOperaciones() {
        int opcion;
        do {
            System.out.println("\n--- Operaciones en Lista " + listaActual.tipoLista.toUpperCase() + " ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarElemento();
                    break;
                case 2:
                    eliminarElemento();
                    break;
                case 3:
                    buscarElemento();
                    break;
                case 4:
                    listaActual.mostrar();
                    break;
                case 5:
                    System.out.println("volviendo al menú principal");
                    break;
                default:
                    System.out.println("opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);
    }

    public static void insertarElemento() {
        System.out.println("que tipo de dato deseas insertar?");
        System.out.println("1. número entero (int)");
        System.out.println("2. texto (String)");
        System.out.println("3. contacto (Objeto)");
        System.out.print("elige una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Ingresa el número entero: ");
                int num = scanner.nextInt();
                scanner.nextLine();
                listaActual.insertar(num);
                System.out.println("número insertado.");
                break;
            case 2:
                System.out.print("Ingresa el texto: ");
                String texto = scanner.nextLine();
                listaActual.insertar(texto);
                System.out.println("texto insertado.");
                break;
            case 3:
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();
                System.out.print("Teléfono: ");
                int telefono = scanner.nextInt();
                scanner.nextLine();
                Contacto contacto = new Contacto(nombre, direccion, telefono);
                listaActual.insertar(contacto);
                System.out.println("Contacto insertado.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void eliminarElemento() {
        System.out.print("Ingresa el elemento a eliminar: ");
        String elemento = scanner.nextLine();
        
        Object datoAEliminar = null;
        try {
            datoAEliminar = Integer.parseInt(elemento);
        } catch (NumberFormatException e) {
            datoAEliminar = elemento;
        }

        if (listaActual.eliminar(datoAEliminar)) {
            System.out.println("elemento eliminado exitosamente.");
        } else {
            System.out.println("elemento no encontrado.");
        }
    }

    public static void buscarElemento() {
        System.out.print("ingresa el elemento a buscar: ");
        String elemento = scanner.nextLine();
        
        Object datoABuscar = null;
        try {
            datoABuscar = Integer.parseInt(elemento);
        } catch (NumberFormatException e) {
            datoABuscar = elemento;
        }

        Node resultado = listaActual.buscar(datoABuscar);
        if (resultado != null) {
            System.out.println("elemento encontrado: " + resultado.datos.toString());
        } else {
            System.out.println("elemento no encontrado.");
        }
    }

    public static void verEjemplosTiposDatos() {
        if (listaActual == null) {
            System.out.println("primero debes seleccionar un tipo de lista.");
            return;
        }
        DataTypeExamples.agregarDatosPrimitivos(listaActual);
        DataTypeExamples.agregarDatosComplejos(listaActual);
        listaActual.mostrar();
    }
}