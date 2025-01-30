package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {

	private List<Cliente> clientes = new ArrayList<>();
	private static List<Pizza> pizzas = new ArrayList<>();
	private List<Pedido> pedidos = new ArrayList<>();

	public static void registrarPizzas(Pizza pizza) {
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
		System.out.println(pizzas.toArray());
	}
}
