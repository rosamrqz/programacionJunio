import java.util.ArrayList;
import java.util.List;

public class Sensor {
	private int type;
    private int num;
    private List<Campo> fields;

    // Constructor, getters y setters
    public Sensor(int type, int num) {
        this.type = type;
        this.num = num;
        this.fields = new ArrayList<>();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Campo> getFields() {
        return fields;
    }

    public void setFields(List<Campo> fields) {
        this.fields = fields;
    }

    // CRUD Campo
    public boolean addField(Campo campo) {
        for (Campo f : fields) {
            if (f.getName().equals(campo.getName())) {
                return false;
            }
        }
        fields.add(campo);
        return true;
    }

    public boolean eliminarField(String name) {
        for (Campo f : fields) {
            if (f.getName().equals(name)) {
                fields.remove(f);
                return true;
            }
        }
        return false;
    }
	
	
}
