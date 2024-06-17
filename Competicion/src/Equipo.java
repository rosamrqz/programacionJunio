import java.util.HashMap;

public class Equipo {
	//Atributos
    private String codigo;
    private String descripcion;
    private String nombreRepresentante;
    private String ciudad;
    private String email;
    private String telefono;

    private HashMap<String, Jugador> misJugadores;
    private Jugador miJugador;

    //Métodos
    //Constructor
    public Equipo(String codigo, String descripcion, String nombreRepresentante, String ciudad, String email,
            String telefono) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombreRepresentante = nombreRepresentante;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
        misJugadores = new HashMap<>();
    }

    //Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRepresentante() {
        return nombreRepresentante;
    }

    public void setNombreRepresentante(String nombreRepresentante) {
        this.nombreRepresentante = nombreRepresentante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    //CRUD jugadores
    public boolean addJugador (String nombre, String apellidos, int dorsal, String dni, String email, String telefono){
        if (misJugadores.containsKey(dni)){
            return false;
        } else {
            miJugador = new Jugador(nombre, apellidos, dorsal, dni, email, telefono);
            misJugadores.put(dni, miJugador);
            return true;
        }
    }

    
    public boolean borrarJugador (String dni){
        if (misJugadores.containsKey(dni)){
            misJugadores.remove(dni);
            return true;
        }
        return false;
        
    }
    
    
    //Otros métodos
    public boolean comprobarJugadores(){
        if (misJugadores.isEmpty()){
            return true;
        }
        return false;
    }

    
    public boolean cambiarDisponibilidad(String dniJugador, boolean disponibilidad){
        if (misJugadores.containsKey(dniJugador)){
            misJugadores.get(dniJugador).setDisponibilidad(disponibilidad);
            return true;
        } else {
            return false;
        }
    }

    

       

    
}