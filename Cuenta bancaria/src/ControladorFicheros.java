import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ControladorFicheros {

    public static boolean writeText(String filename, String data, boolean sobreescribir) {
        FileWriter fw = null;
        PrintWriter pw = null;
        boolean resultado = false;

        try {
            if (sobreescribir) {
                fw = new FileWriter(filename);
            } else {
                fw = new FileWriter(filename, true);
            }

            pw = new PrintWriter(fw);
            pw.print(data);
            pw.flush();

            pw.close();
            fw = null;
            resultado = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return resultado;
    }

    public static String readText(String filename) {
        Scanner sc = null;
        FileReader fr = null;
        String texto = "";

        try {
            fr = new FileReader(filename);
            sc = new Scanner(fr);

            while (sc.hasNext()) {
                texto += sc.nextLine() + "\n";
            }
            fr = null;
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return texto;
    }
}
