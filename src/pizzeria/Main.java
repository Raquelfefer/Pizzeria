package pizzeria;

import java.util.List;
import java.util.Scanner;

import pizzeria.enums.EnumTipo;

public class Main {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Pizzeria pizzeria = new Pizzeria();

		int opcion;
		do {
			System.out.println();
			System.out.println("----- Menu -----");
			System.out.printf("1. Nueva pizza \n2. Nuevo cliente \n3. Realizar un pedido \n4. Ver pizzas "
					+ "\n5. Ver pedidos \n6. Ver clientes \n7. Consultar cliente mediante su telefono"
					+ "\n8. Buscar pizzas con ingrediente \n9. Buscar pizza sin ingrediente \n10. Pedidos de hoy"
					+ "\n11. Pedidos consumidos en el local \n12. Pedidos para recoger \n13. Pedidos a domicilio"
					+ "\n14. Pizza mas cara \n15. Pizza mas barata \n16. Ultimo pedido realizado \n17. Salir");

			System.out.println();
			System.out.println();
			System.out.println("Introduce la opción:");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				Pizza p = nuevaPizza(sc);
				pizzeria.addPizzas(p);
				break;

			case 2:
				Cliente c = nuevoCliente(sc);
				pizzeria.addClientes(c);
				break;

			case 3:
				Pedido pe = nuevoPedido(sc);
				pizzeria.addPedido(pe);
				do {
					System.out.printf("¿Qué pizza quieres añadir: \n");
				}
				break;

			case 4:
				pizzeria.mostrarPizzas();
				break;

			case 5:
				pizzeria.mostrarPedidos();
				break;

			case 6:
				pizzeria.mostrarClientes();
				break;

			case 7:
				System.out.println("Introduce el teléfono: ");
				String t = sc.next();
				pizzeria.consultarClienteTelefono(t);
				break;

			case 8:
				System.out.println("Introduce el ingrediente: ");
				String con = sc.next();
				pizzeria.pizzasConIngrediente(con);
				break;

			case 9:
				String sin = sc.next();
				pizzeria.pizzasSinIngrediente(sin);
				break;

			case 10:
				pizzeria.consultarPedidosHoy();
				break;

			case 11:
				pizzeria.consultarPedidosLocal();
				break;

			case 12:
				pizzeria.consultarPedidosRecoger();
				break;

			case 13:
				pizzeria.consultarPedidosDomicilio();
				break;

			case 14:
				Pizza.mostrarPizzaMasCara();
				break;

			case 15:
				Pizza.mostrarPizzaMasBarata();
				break;

			case 16:
				Pedido.mostrarUltimoPedido();
			}

		} while (opcion > 0 && opcion <= 16);
		System.out.println("Ha salido del menú.");

	}

	public static Pizza nuevaPizza(Scanner sc) {
		System.out.println("Nombre: ");
		String nombre = sc.next();
		System.out.println("Ingredientes: ");
		String ingredientes = sc.next();
		System.out.println("Precio: ");
		double precio = sc.nextDouble();

		return new Pizza(nombre, ingredientes, precio);
	}

	public static Cliente nuevoCliente(Scanner sc) {
		System.out.println("Nombre: ");
		String nombre = sc.next();
		System.out.println("Direccion: ");
		String direccion = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Teléfono: ");
		String telefono = sc.next();

		return new Cliente(nombre, direccion, email, telefono);
	}

	public static Pedido nuevoPedido(Scanner sc) {
		System.out.println("Cliente: ");
		int cliente = sc.nextInt();
		System.out.println("Tipo de entrega: ");
		String tipo = sc.next();

		return new Pedido(cliente, tipo);
	}

	public static void verPizzas(List<Pizza> pizzas) {
		for (Pizza p : pizzas) {
			System.out.println(p);
		}
	}

}