
public class Documento {
    private String tipo;
    private int numero;

    public Documento(String tipo, int numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String mostrarTodo(){
        String resultado;
        resultado = getTipo() + ";" + String.valueOf(getNumero());
        return resultado;
    }

    @Override
    public String toString() {
        return "Documento [tipo=" + tipo + ", numero=" + numero + "]";
    }
}
