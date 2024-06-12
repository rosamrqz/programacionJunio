import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KGen kgen = null;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Abrir fichero FASTA");
            System.out.println("2. Calcular y mostrar mapa...");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            int opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Introduzcca el nombre del fichero FASTA: ");
                    String rutaArchivo = sc.nextLine();
                    kgen = new KGen(rutaArchivo);
                    System.out.println("Fichero leído correctamente.");
                    break;
                case 2:
                    if (kgen == null) {
                        System.out.println("Primero debe abrir un fichero FASTA.");
                        break;
                    }
                    System.out.print("Introduzca el tamaño de la palabra: ");
                    int tamaño = Integer.valueOf(sc.nextLine());
                    Map<String, Integer> mapaKgen = kgen.obtenerMapaKgen(tamaño);
                    System.out.println("Mapa de palabras de tamaño " + tamaño + ":");
                    for (Map.Entry<String, Integer> entrada : mapaKgen.entrySet()) {
                        System.out.println(entrada.getKey() + ": " + entrada.getValue());
                    }
                    break;
                case 3:
                    System.out.println("Finalizando el programa");
                    sc.close();
                    return;
                default:
                    System.out.println("Elija una opción válida");
            }
        }
    }
}
