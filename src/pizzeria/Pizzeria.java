package pizzeria;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class Pizzeria {
	
	private List<Cliente> clientes = new ArrayList<>();
	private List<Pizza> pizzas = new ArrayList<>();
	private List<Pedido> pedidos = new ArrayList<>();

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
		for (Pizza pizza: pizzas) {
			System.out.println("Pizza: " + pizza.getNombre());
		}
	}
	
	public void mostrarPedidos() {
		System.out.println("Lista de pedidos:");
		for (Pedido pedido : pedidos) {
			System.out.println("Pedido " + pedido.getIdPedido());
		}
	}
	
	public void mostrarClientes() {
		System.out.println("Lista de clientes:");
		for (Cliente cliente: clientes) {
			System.out.println("Cliente " + cliente.getNombre());
		}
	}
	

	public void consultarClienteTelefono(String telefono) {
		for (Cliente cliente : clientes) {
			if (cliente.getTelefono().equals(cliente.getTelefono())) {
				cliente.mostrarInformacion();
			}
		}
	}


	public void pizzasConIngrediente(String ingrediente) {
		if(ingrediente == null || ingrediente.isBlank()) {
			throw new IllegalArgumentException("El ingrediente no puede ser nulo o en blanco.");
		}
		System.out.println("Estas pizzas tienen " + ingrediente);
		for (Pizza pizza: pizzas) {
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
		for (Pizza pizza : pizzas) {
			if(!(pizza.getIngredientes().contains(ingrediente))) {
				System.out.println(pizza.getNombre());
			}
			else {
				System.out.println("No hay pizzas con estas características.");
			}
		}
	}
	
	public void consultarPedidosHoy() {
		for(Pedido pedido : pedidos) {
			if(pedido.getFecha().equals(LocalDateTime.now())) {
				pedido.mostrarPedido();
			}
		}
	}
	
	
}
