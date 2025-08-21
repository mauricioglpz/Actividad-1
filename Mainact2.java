package actividad2;

import java.util.Scanner;

public class Main {
    private Pila historialComandos;
    private Cola programasEjecucion;
    private Scanner scanner;

    public Main() {
        historialComandos = new Pila();
        programasEjecucion = new Cola();
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;
        do {
            System.out.println("\n--- Sistema Operativo Simulado ---");
            System.out.println("1. ejecutar comando (push a pila)");
            System.out.println("2. deshacer último comando (pop de pila)");
            System.out.println("3. ver último comando (peek de pila)");
            System.out.println("4. agregar programa a la cola de ejecución (enqueue)");
            System.out.println("5. ejecutar próximo programa (dequeue de cola)");
            System.out.println("6. ver próximo programa a ejecutar (peek de cola)");
            System.out.println("7. mostrar historial de comandos");
            System.out.println("8. mostrar cola de programas");
            System.out.println("9. ver ejemplo de PILAS (Comandos)");
            System.out.println("10. ver ejemplo de COLAS (Programas)");
            System.out.println("11. salir");
            System.out.print("elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    ejecutarComando();
                    break;
                case 2:
                    deshacerComando();
                    break;
                case 3:
                    verUltimoComando();
                    break;
                case 4:
                    agregarPrograma();
                    break;
                case 5:
                    ejecutarPrograma();
                    break;
                case 6:
                    verProximoPrograma();
                    break;
                case 7:
                    mostrarHistorial();
                    break;
                case 8:
                    mostrarColaProgramas();
                    break;
                case 9:
                    mostrarEjemploPilas();
                    break;
                case 10:
                    mostrarEjemploColas();
                    break;
                case 11:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("opción no válida");
            }
        } while (opcion != 11);
    }

    private void ejecutarComando() {
        System.out.print("Ingresa el comando a ejecutar: ");
        String comando = scanner.nextLine();
        historialComandos.push(comando);
        System.out.println("Comando ejecutado: " + comando);
    }

    private void deshacerComando() {
        Object comando = historialComandos.pop();
        if (comando != null) {
            System.out.println("↩️ Comando deshecho: " + comando);
        } else {
            System.out.println("no hay comandos para deshacer.");
        }
    }

    private void verUltimoComando() {
        Object comando = historialComandos.peek();
        if (comando != null) {
            System.out.println("ultimo comando: " + comando);
        } else {
            System.out.println("no hay comandos en el historial.");
        }
    }

    private void agregarPrograma() {
        System.out.print("Ingresa el nombre del programa: ");
        String programa = scanner.nextLine();
        programasEjecucion.enqueue(programa);
        System.out.println("Programa agregado: " + programa);
    }

    private void ejecutarPrograma() {
        Object programa = programasEjecucion.dequeue();
        if (programa != null) {
            System.out.println("ejecutando programa: " + programa);
        } else {
            System.out.println("no hay programas en la cola.");
        }
    }

    private void verProximoPrograma() {
        Object programa = programasEjecucion.peek();
        if (programa != null) {
            System.out.println("Próximo programa a ejecutar: " + programa);
        } else {
            System.out.println("no hay programas en la cola.");
        }
    }

    private void mostrarHistorial() {
        System.out.println("--- Historial de Comandos ---");
        historialComandos.mostrar();
    }

    private void mostrarColaProgramas() {
        System.out.println("--- Cola de Programas ---");
        programasEjecucion.mostrar();
    }

    private void mostrarEjemploPilas() {
        System.out.println("\n=== EJEMPLO DE PILAS ===");
        System.out.println("Una pila funciona como una pila de platos:");
        System.out.println("• El último en entrar es el primero en salir");
        System.out.println("• Se usa para: Historial de comandos, deshacer acciones, etc.");
        
        System.out.println("\nSimulando historial de comandos:");
        
        Pila ejemploPila = new Pila();
        
        System.out.println("1. Ejecutando comando: 'cd /home'");
        ejemploPila.push("cd /home");
        
        System.out.println("2. Ejecutando comando: 'ls -l'");
        ejemploPila.push("ls -l");
        
        System.out.println("3. Ejecutando comando: 'mkdir proyecto'");
        ejemploPila.push("mkdir proyecto");
        
        System.out.println("\nEstado actual de la pila:");
        ejemploPila.mostrar();
        
        System.out.println("\nDeshaciendo último comando (pop):");
        String comandoDeshecho = (String) ejemploPila.pop();
        System.out.println("Comando deshecho: " + comandoDeshecho);
        
        System.out.println("\nViendo tope actual (peek):");
        String topeActual = (String) ejemploPila.peek();
        System.out.println("Tope actual: " + topeActual);
        
        System.out.println("\nEstado final de la pila:");
        ejemploPila.mostrar();
        
        System.out.println("\npresiona Enter para continuar");
        scanner.nextLine();
    }

    private void mostrarEjemploColas() {
        System.out.println("\n=== EJEMPLO DE COLAS ===");
        System.out.println("Una cola funciona como una fila de personas:");
        System.out.println("• El primero en entrar es el primero en salir");
        System.out.println("• Se usa para: Colas de impresión, procesos en ejecución, etc.");
        
        System.out.println("\nSimulando cola de programas:");
        
        Cola ejemploCola = new Cola();
        
        System.out.println("1. Agregando programa: 'Google Chrome'");
        ejemploCola.enqueue("Google Chrome");
        
        System.out.println("2. Agregando programa: 'Microsoft Word'");
        ejemploCola.enqueue("Microsoft Word");
        
        System.out.println("3. Agregando programa: 'Excel'");
        ejemploCola.enqueue("Excel");
        
        System.out.println("\nEstado actual de la cola:");
        ejemploCola.mostrar();
        
        System.out.println("\nEjecutando primer programa (dequeue):");
        String programaEjecutado = (String) ejemploCola.dequeue();
        System.out.println("Programa ejecutado: " + programaEjecutado);
        
        System.out.println("\nViendo próximo programa (peek):");
        String proximoPrograma = (String) ejemploCola.peek();
        System.out.println("Próximo programa: " + proximoPrograma);
        
        System.out.println("\nEstado final de la cola:");
        ejemploCola.mostrar();
        
        System.out.println("\nresiona Enter para continuar...");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Main so = new Main();
        so.ejecutar();
    }
}



