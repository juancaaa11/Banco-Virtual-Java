
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package Clases;

/*
 * Clase personas, con sus respectivos atributos. La utilizo para poder aplicar el SessionManager sin errores.
 * 
 */

public class personas {
	
	private String nombre;
	private String dni;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private String numcuenta;
	private double dinero_disp;
	private String usuario;
	
	
	
	public personas() {
		super();
	}



	public personas(String nombre, String dni, String apellido1, String apellido2, String telefono, String numcuenta,
			double dinero_disp, String usuario) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.numcuenta = numcuenta;
		this.dinero_disp = dinero_disp;
		this.usuario = usuario;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getApellido1() {
		return apellido1;
	}



	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}



	public String getApellido2() {
		return apellido2;
	}



	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getNumcuenta() {
		return numcuenta;
	}



	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}



	public double getDinero_disp() {
		return dinero_disp;
	}



	public void setDinero_disp(double dinero_disp) {
		this.dinero_disp = dinero_disp;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	

}
