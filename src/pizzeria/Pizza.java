package pizzeria;

public class Pizza {

	private String nombre;
	private String ingredientes;
	private double precio;
	
	private static Pizza pizzaMasCara;
	private static Pizza pizzaMasBarata;
	
	public Pizza (String nombre, String ingredientes, double precio) {
		setNombre(nombre);
		setIngredientes(ingredientes);
		setPrecio(precio);
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
	
	public void setNombre(String nombre) {
		if(nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco.");
		}
		this.nombre = nombre;
	}
	
	public void setIngredientes(String ingredientes) {
		if(ingredientes == null || ingredientes.isBlank()) {
			throw new IllegalArgumentException("Los ingredientes no pueden ser nulos o en blanco.");
		}
		this.ingredientes = ingredientes;
	}
	
	public void setPrecio(double precio) {
		if(precio < 0) {
			throw new IllegalArgumentException("El precio de la pizza no pude ser menor a 0.");
		}
	}
}
