package pizzeria;

public class Cliente {

	private int id;
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private double dineroDisponible;

	private static int idUlt = 1;


	public Cliente(String nombre, String direccion, String email, String telefono, double dineroDisponible) {
		this.id = idUlt++;
		setNombre(nombre);
		setDireccion(direccion);
		setEmail(email);
		setTelefono(telefono);
		setDinero(dineroDisponible);
	}

	public int getId() {
		return this.id;
	}

	public double getDinero() {
		return dineroDisponible;
	}

	public void setDinero(double dineroDisponible) {
		if (dineroDisponible < 0) {
			throw new IllegalArgumentException("No se puede tener saldo negativo");
		}
		this.dineroDisponible = dineroDisponible;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono.length() != 9) {
			throw new IllegalArgumentException("Teléfono no valido. Debe contener 9 digitos.");
		}
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco.");
		}
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		int arroba = 0;
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("El email no puede ser nulo o en blanco.");
		}
		for (int i = 0; i < email.length(); i++) {
			String caracter = email.substring(i, i + 1);
			if (caracter.matches("@")) {
				arroba++;
			}

		}
		if (arroba != 1) {
			throw new IllegalArgumentException("Email no válido. Debe contener un arroba.");
		}
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion == null || direccion.isBlank()) {
			throw new IllegalArgumentException("La direccion no puede ser nula o en blanco.");
		}
		this.direccion = direccion;
	}

	public void mostrarInfoCliente() {
		System.out.printf("Id: %s%nNombre: %s%nDirección: %s%nEmail: %s%nTelefono: %s%nDinero Disponible: %.2f%n", id, nombre, direccion, email,
				telefono, dineroDisponible);
	}
	
	public void restarSaldoDisponible(double total){
		this.dineroDisponible -= total;
	}
	
	public void aumentarSaldoDisponible(double total){
		this.dineroDisponible += total;
	}
}