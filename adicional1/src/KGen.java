import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KGen {
    private String rutaArchivo;
    private String datos;

    public KGen(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.datos = leerArchivoFasta(rutaArchivo);
    }

    private String leerArchivoFasta(String rutaArchivo) {
        StringBuilder secuencia = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // saltar la primera línea
            while ((linea = br.readLine()) != null) {
                secuencia.append(linea.trim());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return secuencia.toString();
    }

    public Map<String, Integer> obtenerMapaKgen(int tamaño) {
        Map<String, Integer> mapaKgen = new HashMap<>();
        for (int i = 0; i <= datos.length() - tamaño; i++) {
            String kmer = datos.substring(i, i + tamaño);
            mapaKgen.put(kmer, mapaKgen.getOrDefault(kmer, 0) + 1);
        }
        return mapaKgen;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public String getDatos() {
        return datos;
    }
}
