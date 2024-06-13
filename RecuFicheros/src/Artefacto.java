import java.util.ArrayList;
import java.util.List;

public class Artefacto {
	private String artifact;
    private String architecture;
    private int productID;
    private List<Sensor> sensores;

    // Constructor, getters y setters
    public Artefacto(String artifact, String architecture, int productID) {
        this.artifact = artifact;
        this.architecture = architecture;
        this.productID = productID;
        this.sensores = new ArrayList<>();
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

   
    public boolean addSensor(Sensor sensor) {
        for (Sensor s : sensores) {
            if (s.getNum() == sensor.getNum()) {
                return false; 
            }
        }
        return sensores.add(sensor);
    }


    public boolean eliminarSensor(int codigo) {
        for (Sensor i:sensores) {
            if (i.getNum() == codigo) {
                return sensores.remove(i);
            }
        }
        return false;
    }
    
    public Sensor buscarSensor(int codigo) {
        for (Sensor i:sensores) {
            if (i.getNum() == codigo)
            	return i;
        }
        return null;
    }
}

