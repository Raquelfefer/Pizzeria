package pizzeria;

public class Cliente {
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private double dineroDisponible;

	public Cliente(String nombre, String direccion, String email, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.dineroDisponible = 0.0;
	}

	public Cliente(String nombre, String direccion, String email, String telefono, double dineroDisponible) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.dineroDisponible = getDinero();
	}
	
	public double getDinero() {
		return dineroDisponible;
	}
	
	public void setDinero(double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}
}
