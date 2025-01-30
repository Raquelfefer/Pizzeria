package pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
	private static List<Cliente> clientes = new ArrayList<>();
	private static List<Pizza> pizzas = new ArrayList<>();
	private static List<Pedido> pedidos = new ArrayList<>();

	public static void registrarPizzas(Pizza pizza) {
		pizzas.add(pizza);
	}

	public static void registrarClientes(Cliente cliente) {
		clientes.add(cliente);
	}

	public static void realizarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void mostrarPizzas() {
		System.out.println("Lista de pizzas:");
		for (Pizza pizza: pizzas) {
			System.out.println(pizza.getNombre());
		}
	}
}
