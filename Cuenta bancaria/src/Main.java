import java.util.Scanner;
import com.google.gson.Gson;

public class Main {
    private static Cuenta miCuenta = new Cuenta("0000", 0, "nada");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
                case 1:
                    darDatos(sc);
                    break;
                case 2:
                    loadCliente(sc);
                    break;
                case 3:
                    realizarIngreso(sc);
                    break;
                case 4:
                    realizarRetirada(sc);
                    break;
                case 5:
                    saveCuenta(sc);
                    break;
                case 6:
                    loadCuenta(sc);
                    break;
                case 7:
                    exportarDatos(sc);
                    break;
                case 8:
                    System.out.println("Finalizando el programa...");
                    break;
                default:
                    System.out.println("Elija una opción válida");
                    break;
            }
        } while (opcion != 8);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("Menú de opciones Cuenta Bancaria");
        System.out.println("1. Dar datos de la cuenta");
        System.out.println("2. Cargar cliente de la cuenta desde JSON");
        System.out.println("3. Realizar ingreso");
        System.out.println("4. Realizar retirada");
        System.out.println("5. Grabar cuenta en fichero JSON");
        System.out.println("6. Cargar cuenta de fichero JSON");
        System.out.println("7. Exportar datos a texto hacia pantalla y fichero");
        System.out.println("Cualquier tecla para salir");
    }

    public static void darDatos(Scanner sc) {
        System.out.println("Introduzca su CCC");
        String ccc = String.valueOf(sc.nextLine());
        System.out.println("Introduzca la fecha de apertura");
        String fechaApertura = String.valueOf(sc.nextLine());

        miCuenta.setCcc(ccc);
        miCuenta.setFechaApertura(fechaApertura);
    }

    public static void loadCliente(Scanner sc) {
        if (miCuenta.getCcc().equals("0000")) {
            System.out.println("Primero debe dar los datos de la cuenta");
        } else {
            System.out.println("Introduzca la ruta del archivo JSON");
            String ruta = String.valueOf(sc.nextLine());

            miCuenta.loadCliente(ruta + ".json");
        }
    }

    public static void realizarIngreso(Scanner sc) {
        if (miCuenta.getCcc().equals("0000")) {
            System.out.println("Primero debe dar los datos de la cuenta");
        } else {
            String fecha;
            float cantidad;
            System.out.println("Introduzca la fecha");
            fecha = String.valueOf(sc.nextLine());
            System.out.println("Introduzca la cantidad");
            cantidad = Float.valueOf(sc.nextLine());

            if (miCuenta.ingresarEfectivo(cantidad, fecha)) {
                System.out.println("Ingreso realizado");
            } else {
                System.out.println("Error al realizar el ingreso");
            }
        }
    }

    public static void realizarRetirada(Scanner sc) {
        if (miCuenta.getCcc().equals("0000")) {
            System.out.println("Primero debe dar los datos de la cuenta");
        } else {
            String fecha;
            float cantidad;
            System.out.println("Introduzca la fecha");
            fecha = String.valueOf(sc.nextLine());
            System.out.println("Introduzca la cantidad");
            cantidad = Float.valueOf(sc.nextLine());

            if (miCuenta.retirarEfectivo(cantidad, fecha)) {
                System.out.println("Retirada realizada");
            } else {
                System.out.println("Error al realizar la retirada");
            }
        }
    }

    public static void saveCuenta(Scanner sc) {
        if (miCuenta.getCcc().equals("0000")) {
            System.out.println("Primero debe dar los datos de la cuenta");
        } else {
            String filename;
            System.out.println("Introduzca el nombre del archivo");
            filename = sc.nextLine();

            Gson gson = new Gson();
            String datos = gson.toJson(miCuenta);
            ControladorFicheros.writeText(filename + ".json", datos, true);
        }
    }

    public static void loadCuenta(Scanner sc) {
        System.out.println("Introduzca el nombre del fichero");
        String fileNamen = sc.nextLine();

        if (!fileNamen.isBlank()) {
            String json = ControladorFicheros.readText(fileNamen + ".json");

            Gson gson2 = new Gson();
            miCuenta = gson2.fromJson(json, Cuenta.class);
        }
    }

    public static void exportarDatos(Scanner sc) {
        String datosCuenta = miCuenta.mostrarTodo();
        System.out.println(datosCuenta);

        System.out.println("¿Desea guardar los datos?");
        System.out.println("Escriba 'si' para guardar o 'no' para mostrar solo en pantalla");
        
        String respuesta = sc.nextLine().trim().toLowerCase();

        if (respuesta.equals("si")) {
            System.out.println("Introduzca el nombre del archivo:");
            String filename = sc.nextLine();
            ControladorFicheros.writeText(filename, datosCuenta, true);
            System.out.println("Datos guardados en el archivo: " + filename);
        }
    }

}
