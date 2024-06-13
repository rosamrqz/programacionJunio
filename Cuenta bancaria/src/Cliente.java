
public class Cliente {
    private String nombre;
    private String apellidos;
    private String email;

    private Documento documento;

    public Cliente(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String mostrarTodo(){
        
        String resultado;
        resultado = getNombre() + ";" + getApellidos() + ";" + getEmail() + "\n" + documento.mostrarTodo();
        return resultado;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", miDoc=" + documento + "]";
    }

    
}
