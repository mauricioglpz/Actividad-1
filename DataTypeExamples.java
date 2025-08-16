package actividad1;
public class DataTypeExamples {

    public static void agregarDatosPrimitivos(LinkedList lista) {
        System.out.println("Agregando tipos de datos primitivos (int, double, boolean)...");
        lista.insertar(100);
        lista.insertar(50.5);
        lista.insertar(true);
        System.out.println("Tipos de datos primitivos agregados.");
    }

    public static void agregarDatosComplejos(LinkedList lista) {
        System.out.println("Agregando tipos de datos complejos (String, Contacto)...");
        lista.insertar("Hola Mundo");
        Contacto nuevoContacto = new Contacto("Juan Perez", "Calle Falsa 123", 555123456);
        lista.insertar(nuevoContacto);
        System.out.println("Tipos de datos complejos agregados.");
    }
}
