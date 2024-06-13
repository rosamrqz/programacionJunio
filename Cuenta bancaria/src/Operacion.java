
public class Operacion {
    private long codOp;
    private String fechaOp;
    private float cantidad;

    public Operacion(long codOp, String fechaOp, float cantidad) {
        this.codOp = codOp;
        this.fechaOp = fechaOp;
        this.cantidad = cantidad;
    }

    public long getCodOp() {
        return codOp;
    }

    public String getFechaOp() {
        return fechaOp;
    }

    public void setFechaOp(String fechaOp) {
        this.fechaOp = fechaOp;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Operacion [codOp=" + codOp + ", fechaOp=" + fechaOp + ", cantidad=" + cantidad + "]";
    }

    

    
}
