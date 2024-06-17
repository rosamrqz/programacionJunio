import java.util.ArrayList;

public class Paquete {
    //Atributos
    private String localizador;
    private String direccionEnvio;
    private String dniCliente;
    private String fechaEnvio;
    private int diasEntregaPrev;
    private int estado;


    protected ArrayList<Producto> misProductos;
    
    //Métodos
    //Constructor
    public Paquete(String localizador, String direccionEnvio, String dniCliente, String fechaEnvio, int diasEntregaPrev, int estado) {
        this.localizador = localizador;
        this.direccionEnvio = direccionEnvio;
        this.dniCliente = dniCliente;
        this.fechaEnvio = fechaEnvio;
        this.diasEntregaPrev = diasEntregaPrev;
        this.estado = estado;

        misProductos = new ArrayList<>();
    }
    
    
  //Getters y Setters
    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public int getDiasEntregaPrev() {
        return diasEntregaPrev;
    }

    public void setDiasEntregaPrev(int diasEntregaPrev) {
        this.diasEntregaPrev = diasEntregaPrev;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    

    //CRUD productos
    public boolean addProducto(String codProducto, String descripcion, int cantidad, double pesoUnidad){
        Producto unProducto = new Producto(codProducto, descripcion, cantidad, pesoUnidad);
        misProductos.add(unProducto);
        return true;
    }

    public boolean eliminarProducto(String codProducto){
        for (Producto prod: misProductos){
            if (codProducto.equals(prod.getCodProducto())){
                misProductos.remove(prod);
                return true;
            }
        }
        return false;
    }

    public String mostrarProducto(String codProducto){
        for (Producto prod: misProductos){
            if (codProducto.equals(prod.getCodProducto())){
                return "Codigo Producto: " + prod.getCodProducto() + "\nDescripcion" + prod.getDescripcion() + "\nCantidad: " + prod.getCantidad() + " \nPeso/u" + prod.getPesoUnidad();
            }
        }
        return "No se ha encontrado el producto en este paquete";
    }

       
}