package pizzeria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzeria {
	private List<Cliente> clientes;
	private List<Pizza> pizzas;
	private List<Pedido> pedidos;


	public Pizzeria() {

		this.clientes = new ArrayList<Cliente>();
		this.pizzas = new ArrayList<Pizza>();
		this.pedidos = new ArrayList<Pedido>();
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}
	
	public List<Pedido> getPedido(){
		return pedidos;
	}
	
	public void addPizzas(Pizza pizza) {
		if (pizza == null) {
			throw new IllegalArgumentException("La pizza no puede ser nula.");
		}
		pizzas.add(pizza);
	}

	public void addClientes(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("El cliente no puede ser nulo.");
		}
		clientes.add(cliente);
	}

	public void addPedido(Pedido pedido) {
		if (pedido == null) {
			throw new IllegalArgumentException("El pedido no puede ser nulo.");
		}
		pedidos.add(pedido);
	}

	public void mostrarPizzas() {
		if (pizzas == null || pizzas.size() == 0) {
			System.out.println("No hay pizzas en la lista.");
		} else {
			System.out.println();
			System.out.println("--- Lista de pizzas ---");
			for (Pizza pizza : this.pizzas) {
				pizza.mostrarInfoPizza();
				System.out.println();
			}
		}
	}

	public void mostrarPedidos() {
		if (pedidos == null || pedidos.size() == 0) {
			System.out.println("No hay pedidos en la lista.");
		} else {
			System.out.println("--- Lista de pedidos ---");
			for (Pedido pedido : this.pedidos) {
				pedido.mostrarInfoPedido();
				System.out.println();
			}
		}
	}

	public void mostrarClientes() {
		if (clientes == null || clientes.size() == 0) {
			System.out.println("No hay clientes en la lista.");
		} else {
			System.out.println("--- Lista de clientes ---");
			for (Cliente cliente : this.clientes) {
				cliente.mostrarInfoCliente();
				System.out.println();
			}
		}
	}

	public void consultarClienteTelefono(String telefono) {
		boolean esta = false;
		for (Cliente cliente : this.clientes) {
			if (cliente.getTelefono().equals(telefono)) {
				cliente.mostrarInfoCliente();
				esta = true;
			}
		}
		if (esta == false) {
			System.out.println("El número no corresponde a ningún cliente.");
		}
	}

	public void pizzasConIngrediente(String ingrediente) {
		if (ingrediente == null || ingrediente.isBlank()) {
			throw new IllegalArgumentException("El ingrediente no puede ser nulo o en blanco.");
		}
		System.out.println("Estas pizzas tienen " + ingrediente + ":");
		boolean esta = false;
		for (Pizza pizza : this.pizzas) {
			if (pizza.getIngredientes().contains(ingrediente)) {
				System.out.println(pizza.getNombre());
				esta = true;

			}
		}
		if(esta == false) {
				System.out.println("No hay pizzas con este ingrediente.");
			}
		}
	

	public void pizzasSinIngrediente(String ingrediente) {
		if (ingrediente == null || ingrediente.isBlank()) {
			throw new IllegalArgumentException("El ingrediente no puede ser nulo o en blanco.");
		}

		System.out.println("Estas pizzas no tienen " + ingrediente + ":");
		boolean esta = false;
		for (Pizza pizza : this.pizzas) {
			if (!(pizza.getIngredientes().contains(ingrediente))) {
				System.out.println(pizza.getNombre());
				esta = true;

			} 
		}
		if(esta == false) {
				System.out.println("No hay pizzas con estas características.");
			}
		}
	

	public void consultarPedidosLocal() {
		boolean esta = false;
		System.out.println("Los pedidos consumidos en local son: ");
		for (Pedido pedido : this.pedidos) {
			if (pedido.getTipo().equals("LOCAL")) {
				pedido.mostrarInfoPedido();
				esta = true;
			}
		}
		if (esta == false) {
			System.out.println("No hay pedidos consumidos en local en la lista.");
		}
	}

	public void consultarPedidosRecoger() {
		boolean esta = false;
		System.out.println("Los pedidos para recoger son: ");
		for (Pedido pedido : this.pedidos) {
			if (pedido.getTipo().equals("RECOGER")) {
				pedido.mostrarInfoPedido();
				esta = true;
			}

		}
		if (esta == false) {
			System.out.println("No hay pedidos para recoger en la lista.");
		}
	}

	public void consultarPedidosDomicilio() {

		boolean esta = false;
		System.out.println("Los pedidos a domicilio son: ");
		for (Pedido pedido : pedidos) {
			if (pedido.getTipo().equals("DOMICILIO")) {
				pedido.mostrarInfoPedido();
				esta = true;
			}
		}
		if (esta == false) {
			System.out.println("No hay pedidos a domicilio en la lista.");
		}
	}
	public void consultarPedidosHoy() {

		LocalDateTime inicio = LocalDateTime.of(LocalDate.now(), LocalTime.of(10,00));
		LocalDateTime fin = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT);
		for (Pedido pedido : this.pedidos) {
			if (pedido.getFecha().isAfter(inicio) && pedido.getFecha().isBefore(fin)) {
				pedido.mostrarInfoPedido();

			}
		}
	}
	public void mostrarNombrePizza() {

		for(Pizza p : pizzas) {
			System.out.println("- " + p.getId() + " " + p.getNombre());
		}

	}
	
	public Pizza comprobarIdPizza(int idPizza) {
		boolean esta = false;
		for(Pizza p : pizzas) {
			if (p.getId() == idPizza) {
				esta = true;
				return p;
			}
		}
		throw new IllegalArgumentException("Esta pizza no se encuentra en el sistema.");
	}

	public void editarPedido(Scanner sc) {
		System.out.println("Introduce el id del pedido: ");
		int pe = sc.nextInt();
		for (Pedido p : pedidos) {
			if (p.getIdPedido() == pe) {
				do {
					System.out.println("¿Que pizza quieres eliminar?");
					p.mostrarPizzasPedido();
					System.out.println("Si no quieres eliminar las pizzas, pulsa 0. ");
					pe = sc.nextInt();
					if (pe != 0) {
						p.delPizzaPedido(pe);
					}
				} while (pe != 0);
			}
		}
	}
	
}

