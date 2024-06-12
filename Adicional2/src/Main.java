import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Component componente;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Dar de alta una SparePart");
            System.out.println("2. Dar de alta un Component");
            System.out.println("3. Buscar una pieza y mostrarla en pantalla");
            System.out.println("4. Generar JSON y grabarlo a fichero de texto");
            System.out.println("5. Importar una pieza desde JSON al sistema");
            System.out.println("Cualquier otra tecla para salir");
            opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
                case 1:
                    altaSparePart();
                    break;
                case 2:
                    altaComponent();
                    break;
                case 3:
                    buscarPieza();
                    break;
                case 4:
                    generarJSON();
                    break;
                case 5:
                    importarDesdeJSON();
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Elija una opción válida.");
            }
        } while (opcion != 0);
    }

    private static void altaSparePart() {
        int codigo = getIntInput("Introduzca el código de la SparePart: ");
        String descripcion = getStringInput("Introduzca la descripción de la SparePart: ");
        double precio = getDoubleInput("Introduzca el precio de la SparePart: ");
        SparePart sparePart = new SparePart(codigo, descripcion, precio);
        System.out.println("SparePart dada de alta correctamente:");
        System.out.println(sparePart);
    }

    private static void altaComponent() {
        int codigo = getIntInput("Ingrese el código del Component: ");
        String descripcion = getStringInput("Introduzca la descripción del Component: ");
        double precio = getDoubleInput("Introduzca el precio del Component: ");
        componente = new Component(codigo, descripcion, precio);
        System.out.println("Componente dado de alta correctamente:");
        System.out.println(componente);
    }

    private static void buscarPieza() {
        int codigo = getIntInput("Introduzca el código de la pieza que desea buscar: ");
        if (componente != null && componente.getCode() == codigo) {
            System.out.println("Pieza encontrada:");
            System.out.println(componente);
        } else {
            System.out.println("Pieza no encontrada.");
        }
    }

    private static void generarJSON() {
        if (componente == null) {
            System.out.println("Debes dar de alta un componente primero");
            return;
        }

        JSONObject jsonComponente = new JSONObject();
        jsonComponente.put("code", componente.getCode());
        jsonComponente.put("text", componente.getText());
        jsonComponente.put("price", componente.getPrice());

        JSONArray jsonParts = new JSONArray();
        for (SparePart part : componente.getParts().values()) {
            JSONObject jsonPart = new JSONObject();
            jsonPart.put("code", part.getCode());
            jsonPart.put("text", part.getText());
            jsonPart.put("price", part.getPrice());
            jsonParts.put(jsonPart);
        }
        jsonComponente.put("parts", jsonParts);

        try (FileWriter file = new FileWriter("componente.json")) {
            file.write(jsonComponente.toString());
            System.out.println("JSON generado y guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void importarDesdeJSON() {
        try (FileReader reader = new FileReader("componente.json")) {
            JSONObject jsonImportado = new JSONObject(new org.json.JSONTokener(reader));
            componente = new Component(
                    jsonImportado.getInt("code"),
                    jsonImportado.getString("text"),
                    jsonImportado.getDouble("price")
            );

            JSONArray jsonPartsImportado = jsonImportado.getJSONArray("parts");
            for (int i = 0; i < jsonPartsImportado.length(); i++) {
                JSONObject jsonPartImportado = jsonPartsImportado.getJSONObject(i);
                SparePart parte = new SparePart(
                        jsonPartImportado.getInt("code"),
                        jsonPartImportado.getString("text"),
                        jsonPartImportado.getDouble("price")
                );
                componente.addPart(parte);
            }

            System.out.println("Componente importado desde JSON: " + componente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getIntInput(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    private static double getDoubleInput(String message) {
        System.out.print(message);
        return sc.nextDouble();
    }

    private static String getStringInput(String message) {
        System.out.println(message);
        sc.nextLine();
        return sc.nextLine();
    }
}
