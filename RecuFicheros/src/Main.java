import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Artefacto> artefactos = new HashMap<>();
    static String fichero;

    public static void main(String[] args) {
        boolean seguir = true;
        int opcion; 
        
        
        do {
            mostrarMenu();
            opcion = leerInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del fichero JSON: ");
                    fichero = leerString();
                    if (GestorJSON.cargarArtefacto(artefactos, fichero)) {
                        System.out.println("Artefacto añadido correctamente");
                    } else {
                        System.out.println("Ha habido un error al añadir el artefacto");
                    }
                    break;
                case 2:
                    if (añadirSensorAlArtefacto()) {
                        System.out.println("Sensor añadido correctamente");
                    } else {
                        System.out.println("Ha habido un error al añadir el sensor");
                    }
                    break;
                case 3:
                    if (borrarSensorDelArtefacto()) {
                        System.out.println("Sensor borrado correctamente");
                    } else {
                        System.out.println("Ha habido un error al borrar el sensor");
                    }
                    break;
                case 4:
                    if (añadirCampoAlSensor()) {
                        System.out.println("Campo añadido correctamente");
                    } else {
                        System.out.println("Ha habido un añadir el campo");
                    }
                    break;
                case 5:
                    if (borrarCampoDelSensor()) {
                        System.out.println("Campo borrado correctamente");
                    } else {
                        System.out.println("Ha habido un error al borrar el campo");
                    }
                    break;
                case 6:
                    if (artifactToJson()) {
                        System.out.println("Artefacto grabado correctamente");
                    } else {
                        System.out.println("Ha habido un error al grabar el artefacto");
                    }
                    break;
                case 7:
                    if (sensorToJson()) {
                        System.out.println("Sensor grabado correctamente");
                    } else {
                        System.out.println("Ha habido un error al grabar el sensor");
                    }
                    break;
                case -1:
                    System.out.println("Elija una opción valida");
                    break;
                default:
                    seguir = false;
            }
        } while (seguir);

        System.out.println("Finalizando el programa");
    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Añadir artefacto");
        System.out.println("2. Añadir sensor al artefacto");
        System.out.println("3. Borrar sensor del artefacto");
        System.out.println("4. Añadir campo al sensor");
        System.out.println("5. Borrar campo del sensor");
        System.out.println("6. Grabar a JSON artefacto");
        System.out.println("7. Grabar a JSON sensor");
        System.out.println("Cualquier otra tecla para salir");
        System.out.println("Elige una opcion: ");
    }
    
    
    private static int leerInt() {
        int opcion;
        try {
            opcion = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            return -1;
        }
        return opcion;
    }

    private static String leerString() {
        String entrada;
        try {
            entrada = sc.nextLine();
        } catch (InputMismatchException e) {
            return "";
        }
        return entrada;
    }
    

    private static boolean añadirSensorAlArtefacto() {
    	System.out.println("Introduce el nombre del fichero JSON: ");
        String fichero = leerString();
        System.out.print("Introduce el codigo del artefacto: ");
        int codigo = leerInt();

        if (artefactos.get(codigo) != null) {
            Artefacto art = artefactos.get(codigo);
            return GestorJSON.cargarSensor(art, fichero);
        }
        return false;
        
    }
    
    
    private static boolean borrarSensorDelArtefacto() {
    	System.out.println("Introduce el codigo del artefacto: ");
        int codArt = leerInt();
        System.out.print("Introduce el codigo del sensor: ");
        int codSen = leerInt();

        if (artefactos.get(codArt) != null) {
            Artefacto art = artefactos.get(codArt);
            return art.eliminarSensor(codSen);
        }
        return false;
    }
    
    
    private static boolean añadirCampoAlSensor() {
    	System.out.println("Introduce el codigo del artefacto: ");
        int codArt = leerInt();
        System.out.println("Introduce el codigo del sensor: ");
        int codSen = leerInt();

        if (artefactos.get(codArt) != null) {
            Artefacto art = artefactos.get(codArt);

            if (art.buscarSensor(codSen) != null) {
                Sensor sen = art.buscarSensor(codSen);

                System.out.print("Introduce el nombre del campo: ");
                String name = leerString();
                System.out.print("Introduce la unidad del campo: ");
                String unit = leerString();
                System.out.print("Introduce la precision del campo: ");
                int precision = leerInt();

                return sen.addField(new Campo(name, unit, precision));
            }
        }
        return false;
    }
    
    
    private static boolean borrarCampoDelSensor() {
    	System.out.println("Introduce el codigo del artefacto: ");
        int codArt = leerInt();
        System.out.println("Introduce el codigo del sensor: ");
        int codSen = leerInt();
        System.out.println("Introduce el nombre del campo: ");
        String name = leerString();

        if (artefactos.get(codArt) != null) {
            Artefacto art = artefactos.get(codArt);

            if (art.buscarSensor(codSen) != null) {
                Sensor sen = art.buscarSensor(codSen);
                return sen.eliminarField(name);
            }
        }
        return false;
    }
    
    public static boolean artifactToJson() {
        System.out.println("Introduce el nombre del fichero JSON: ");
        fichero = leerString();
        System.out.println("Introduce el codigo del artefacto: ");
        int codigo = leerInt();
        if (artefactos.get(codigo) != null) {
            Artefacto art = artefactos.get(codigo);
            return GestorJSON.grabarArtefacto(art, fichero);
        }
        return false;
    }

    public static boolean sensorToJson() {
        System.out.println("Introduce el nombre del fichero JSON: ");
        fichero = leerString();
        System.out.println("Introduce el codigo del artefacto: ");
        int codArt = leerInt();
        System.out.println("Introduce el codigo del sensor: ");
        int codSen = leerInt();

        if (artefactos.get(codArt) != null) {
            Artefacto art = artefactos.get(codArt);
            if (art.buscarSensor(codSen) != null) {
                Sensor sen = art.buscarSensor(codSen);
                return GestorJSON.grabarSensor(sen, fichero);
            }
        }
        return false;
    }
    
}