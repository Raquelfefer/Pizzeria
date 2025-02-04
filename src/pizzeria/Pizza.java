package pizzeria;

public class Pizza {

	private String nombre;
	private String ingredientes;
	private double precio;
	private int id;
	private static int idUlt = 1;
	private static Pizza pizzaMasCara;
	private static double precioMasCara = 0;
	private static Pizza pizzaMasBarata;
	private static double precioMasBarata = 0;

	public Pizza(String nombre, String ingredientes, double precio) {
		this.id = idUlt++;
		setNombre(nombre);
		setIngredientes(ingredientes);
		setPrecio(precio);
		if (precio > precioMasCara) {
			pizzaMasCara = this;
		} else if (precio < precioMasBarata) {
			pizzaMasBarata = this;
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getIngredientes() {
		return this.ingredientes;
	}

	public double getPrecio() {
		return this.precio;
	}

	public int getId() {
		return this.id;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco.");
		}
		this.nombre = nombre;
	}

	public void setIngredientes(String ingredientes) {
		if (ingredientes == null || ingredientes.isBlank()) {
			throw new IllegalArgumentException("Los ingredientes no pueden ser nulos o en blanco.");
		}
		this.ingredientes = ingredientes;
	}

	public void setPrecio(double precio) {
		if (precio < 0) {
			throw new IllegalArgumentException("El precio de la pizza no pude ser menor a 0.");
		}
		this.precio = precio;
	}
	
	
	public void mostrarInfoPizza() {
		System.out.printf("Nombre: %s%nIngredientes: %s%nPrecio: %.2f €.%n", nombre, ingredientes, precio);
	}
	

}
