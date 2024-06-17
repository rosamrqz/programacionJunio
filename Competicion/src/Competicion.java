import java.util.ArrayList;

public class Competicion {
	//Atributos
    private String codigoComp;
    private String descripcion;
    private String provincia;

    private ArrayList<Equipo> misEquipos;
    private Equipo miEquipo;

    //Métodos
    //Constructor
    public Competicion(String codigoComp, String descripcion, String provincia) {
        this.codigoComp = codigoComp;
        this.descripcion = descripcion;
        this.provincia = provincia;
        misEquipos = new ArrayList<>();
    }
    
    //Getters y setters
    public String getCodigoComp() {
        return codigoComp;
    }

    public void setCodigoComp(String codigoComp) {
        this.codigoComp = codigoComp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    

    //CRUD equipos
    public boolean addEquipo(String codigoEq, String descripcionEq, String nombreRepresentanteEq, String ciudadEq, String emailEq, String telefonoEq){
        for (Equipo e:misEquipos){
            if (codigoEq.equals(e.getCodigo())){
                return false;
            } 
        }
        miEquipo = new Equipo(codigoEq, descripcionEq, nombreRepresentanteEq, ciudadEq, emailEq, telefonoEq);
        misEquipos.add(miEquipo);
        return true;
    }

    public boolean removeEquipo(String codigoEq){
        for (Equipo e:misEquipos){
            if (codigoEq.equals(e.getCodigo())){
                if (e.comprobarJugadores()){
                    misEquipos.remove(e);
                    return true;
                } else {
                    return false;
                }
            } 
        }
        return false;
    }

    public String buscarEquipos(String ciudad){
        String resultado = "Los equipos son: ";
        for (Equipo e:misEquipos){
            if (ciudad.equals(e.getCiudad())){
                resultado +=  e.getCodigo() + " | ";
            } 
        }
        
        if (resultado.compareTo("Los equipos son: ")==0){
            return "No se encontraron Equipos en esta Localidad";
        }
        
        return resultado;
    }

    //Listar equipos
    public String listEquipos(){
        String resultado = "";

        for (Equipo e:misEquipos){
            resultado += "| " + e.getCodigo() + " |";
        }

        if (misEquipos.isEmpty()){
            return "No hay ningun equipo inscrito todavía";
        }

        return resultado;
    }

    
   //Metodos jugador
    public boolean addJugador(String codigoEq, String nombre, String apellidos, int dorsal, String dni, String email, String telefono){
        for (Equipo e:misEquipos){
            if (codigoEq.equals(e.getCodigo())){
                if (e.addJugador(nombre, apellidos, dorsal, dni, email, telefono)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    
    public boolean eliminarJugador(String codigoEq, String dni){
        for (Equipo e:misEquipos){
            if (codigoEq.equals(e.getCodigo())){
                if (e.borrarJugador(dni)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean cambiarDisponibilidad(String codigoEq, String dniJug, int disponibilidad){
        boolean dispo;
        if (disponibilidad == 1){
            dispo = true;
        } else {
            dispo = false;
        }

        for (Equipo e:misEquipos){
            if (codigoEq.equals(e.getCodigo())){
                if (e.cambiarDisponibilidad(dniJug, dispo)){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    

    
}