import java.util.HashMap;
import java.util.Map;

class Component extends SparePart {
    private Map<Integer, SparePart> parts;

    public Component(int code, String text, double price) {
        super(code, text, price);
        this.parts = new HashMap<>();
    }

    public void addPart(SparePart part) {
        parts.put(part.getCode(), part);
    }

    public Map<Integer, SparePart> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Component{" +
                "code=" + getCode() +
                ", text='" + getText() + '\'' +
                ", price=" + getPrice() +
                ", parts=" + parts +
                '}';
    }
}
