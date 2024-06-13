
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Cuenta {
	
	private String ccc;
	private float saldo;
	private String fechaApertura;

	private Cliente miCliente;
	private List<Operacion> misOperaciones;
	
	
	public Cuenta(String ccc, float saldo, String fechaApertura) {
		super();
		this.ccc = ccc;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
		misOperaciones = new ArrayList<>();
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public float getSaldo() {
		return saldo;
	}


	public String getFechaApertura() {
		return fechaApertura;
	}


	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
	public boolean isActiva() {
		return saldo>0;
	}
	
	public boolean retirarEfectivo(float cantidad, String fecha) {
		
		if (cantidad <= 0.0) return false;
		if (cantidad <= saldo) {
			
			long codOp = Math.round((Math.random()) * 100000);
			for (Operacion o : misOperaciones){
				
				if (Long.valueOf(codOp).equals(o.getCodOp())){
					return false;
					
				}
			}
			

			saldo -= cantidad;

			Operacion miOperacion = new Operacion(codOp, fecha, cantidad);
			misOperaciones.add(miOperacion);
			return true;
		}
		return false;
	}

	public boolean ingresarEfectivo(float cantidad, String fecha) {
		if (cantidad <= 0.0) return false;
		saldo += cantidad;
		
		long codOp = Math.round((Math.random()) * 100000);
		for (Operacion o : misOperaciones){
			
			if (Long.valueOf(codOp).equals(o.getCodOp())){
				return false;
			}
		}
		
		Operacion miOperacion = new Operacion(codOp, fecha, cantidad);
		misOperaciones.add(miOperacion);
		return true;
	}

	public void loadCliente(String ruta){

        BufferedReader br = null;
        FileReader fr = null;
        String linea, resultado="";

        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null){
                resultado += linea;
            }


        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if (br != null){
                try{
                    br.close();
                    fr.close();
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }

		Gson gson = new Gson();
		miCliente = gson.fromJson(resultado, Cliente.class);
	}

	public String mostrarTodo(){
		String resultado;

		resultado = getCcc() + ";" + String.valueOf(getSaldo()) + ";" + getFechaApertura() + "\n";
		resultado += miCliente.mostrarTodo() + "\n";

		for (Operacion o:misOperaciones){
			resultado += String.valueOf(o.getCodOp()) + ";" + o.getFechaOp() + ";" + String.valueOf(o.getCantidad()) + "\n";

		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Cuenta [ccc=" + ccc + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + ", miCliente="
				+ miCliente + ", misOperaciones=" + misOperaciones + "]";
	}

}
