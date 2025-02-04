package pizzeria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
	
	private List<Cliente> clientes;
	private List<Pizza> pizzas;
	private List<Pedido> pedidos;
	
	public Pizzeria() {
		this.clientes = new ArrayList<Cliente>();
		this.pizzas = new ArrayList<Pizza>();
		this.pedidos = new ArrayList<Pedido>();
	}

	public void registrarPizzas(Pizza pizza) {
		if (pizza == null) {
			throw new IllegalArgumentException("La pizza no puede ser nula.");
		}
		pizzas.add(pizza);
	}

	
	public void registrarClientes(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("El cliente no puede ser nulo.");
		}
		clientes.add(cliente);
	}

	
	public void realizarPedido(Pedido pedido) {
		if (pedido == null) {
			throw new IllegalArgumentException("El pedido no puede ser nulo.");
		}
		pedidos.add(pedido);
	}
	
	public void mostrarPizzas() {
		System.out.println("Lista de pizzas:");
		for (Pizza pizza: this.pizzas) {
			pizza.mostrarInfoPizza();;
		}
	}
	
	public void mostrarPedidos() {
		System.out.println("Lista de pedidos:");
		for (Pedido pedido : this.pedidos) {
			pedido.mostrarInfoPedido();;
		}
	}
	
	public void mostrarClientes() {
		System.out.println("Lista de clientes:");
		for (Cliente cliente: this.clientes) {
			cliente.mostrarInfoCliente();
		}
	}
	

	public void consultarClienteTelefono(String telefono) {
		for (Cliente cliente : this.clientes) {
			if (cliente.getTelefono().equals(cliente.getTelefono())) {
				cliente.mostrarInfoCliente();
			}
		}
	}


	public void pizzasConIngrediente(String ingrediente) {
		if(ingrediente == null || ingrediente.isBlank()) {
			throw new IllegalArgumentException("El ingrediente no puede ser nulo o en blanco.");
		}
		System.out.println("Estas pizzas tienen " + ingrediente);
		for (Pizza pizza: this.pizzas) {
			if(pizza.getIngredientes().contains(ingrediente)) {
				System.out.println(pizza.getNombre());
			}
			else{
				System.out.println("No hay pizzas con este ingrediente.");
			}
		}
	}
	
	public void pizzasSinIngrediente(String ingrediente) {
		if(ingrediente == null || ingrediente.isBlank()) {
			throw new IllegalArgumentException("El ingrediente no puede ser nulo o en blanco.");
		}
		System.out.println("Estas pizzas no tienen " + ingrediente);
		for (Pizza pizza : this.pizzas) {
			if(!(pizza.getIngredientes().contains(ingrediente))) {
				System.out.println(pizza.getNombre());
			}
			else {
				System.out.println("No hay pizzas con estas características.");
			}
		}
	}

	
	public void consultarPedidosLocal() {
		System.out.println("Los pedidos consumidos en local son: ");
		for(Pedido pedido : this.pedidos) {
			if(pedido.getTipo().equals("LOCAL")) {
				pedido.mostrarInfoPedido();
			}
		}
	}
	
	public void consultarPedidosRecoger() {
		System.out.println("Los pedidos para recoger son: ");
		for(Pedido pedido: this.pedidos) {
			if(pedido.getTipo().equals("RECOGER")) {
				pedido.mostrarInfoPedido();
			}
		}
	}
	
	public void consultarPedidosHoy() {
		LocalDateTime inicio = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
		LocalDateTime fin = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT);
		for (Pedido pedido : this.pedidos) {
			if (pedido.getFecha().isAfter(inicio) && pedido.getFecha().isBefore(fin)) {
				pedido.mostrarInfoPedido();
			}

		}
	}
	
	

	
}
