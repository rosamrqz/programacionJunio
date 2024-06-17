public class Producto {
    //Atributos 
    private String codProducto;
    private String descripcion;
    private int cantidad;
    private double pesoUnidad;

    //Constructor
    public Producto(String codProducto, String descripcion, int cantidad, double pesoUnidad) {
        this.codProducto = codProducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.pesoUnidad = pesoUnidad;
    }

    //Metodo
    
    //Getters y Setters
    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPesoUnidad() {
        return pesoUnidad;
    }

    public void setPesoUnidad(double pesoUnidad) {
        this.pesoUnidad = pesoUnidad;
    }

    
}