package pizzeria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pizzeria.enums.EnumTipo;

public class Pedido {
	private static int contadorIdPedido = 0;
	private int idPedido;
	private int idCliente;
	private LocalDateTime fecha;
	private double total;
	private EnumTipo tipo;
	private List<Pizza> pizzasPedido;
	private static Pedido ultimoPedido;
	


	public Pedido(int cliente, String tipo) {
		contadorIdPedido++;
		this.idPedido = contadorIdPedido;
		setCliente(cliente);
		this.fecha = LocalDateTime.now();
		setTipo(tipo);
		this.pizzasPedido = new ArrayList<Pizza>();
		this.total = 0.0;
		ultimoPedido = this;
	}
	
	
	public Pedido getUltimoPedido() {
		return ultimoPedido;
	}

	public void setCliente(int idCliente) {
		if (idCliente <= 0) {
			throw new IllegalArgumentException("El id del cliente no puede ser nulo. ");
		}
		this.idCliente = idCliente;
	}
	
	public void setTipo(String tipo) {
		this.tipo = EnumTipo.valueOf(tipo);
	}

	public int getCliente() {
		return idCliente;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public double getTotal() {
		return total;
	}

	public String getTipo() {
		return tipo.toString();
	}

	public List<Pizza> getPizza() {
		return pizzasPedido;
	}

	public void addPizzaPedido(String nombrePizza) {
		if (nombrePizza == null || nombrePizza.isBlank()) {
			throw new IllegalArgumentException("El campo no puede ser nulo o en blanco.");
		}
		boolean esta = false;
		for(Pizza p : Pizzeria.getPizzas()){
			if(p.getNombre().equals(nombrePizza)) {
				pizzasPedido.add(p);
				this.total += p.getPrecio();
				esta = true;
			}
		}
		if(esta == false) {
			throw new IllegalArgumentException("Esta pizza no se encuentra en el sistema.");
		}
	}

	
	public void mostrarInfoPedido() {
		System.out.printf("ID: %s%nCliente: %s%nFecha: %s%nTotal: %.2f%nTipo: %s%n", idPedido, idCliente , fecha, total, tipo);
		System.out.println("Pizzas: ");
		for (Pizza pizza : pizzasPedido) {
			System.out.println("- " + pizza.getNombre());
		}
	}
	
	public static void mostrarUltimoPedido() {
		if (ultimoPedido != null) {
            System.out.println("Último pedido: ");
            ultimoPedido.mostrarInfoPedido(); 
        }
	}
	
	
}
