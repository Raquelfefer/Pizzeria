
package pizzeria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		menu();
		
	}
	

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Pizzeria pizzeria = new Pizzeria();
		
		Pizza pizza1 = new Pizza("Margarita", "Tomate, Mozzarella, Albahaca", 8.50);
		Pizza pizza2 = new Pizza("Pepperoni", "Tomate, Mozzarella, Pepperoni", 9.00);
		Pizza pizza3 = new Pizza("Cuatro Estaciones", "Tomate, Mozzarella, Jamón, Champiñones, Aceitunas, Pimientos",
				10.00);
		Pizza pizza4 = new Pizza("Vegetariana", "Tomate, Mozzarella, Espinacas, Pimientos, Champiñones, Cebolla", 9.50);

		Cliente cliente1 = new Cliente("Juan Pérez", "Calle Ficticia 123", "juan@email.com", "555123456", 1500.50);
		Cliente cliente2 = new Cliente("Ana Gómez", "Avenida Siempre Viva 456", "ana@email.com", "555654321", 2200.75);
		Cliente cliente3 = new Cliente("Carlos Rodríguez", "Calle Real 789", "carlos@email.com", "555987654", 3000.00);
		Cliente cliente4 = new Cliente("Luisa Martínez", "Plaza Mayor 101", "luisa@email.com", "555246810", 500.30);
		
		Pedido pedido1 = new Pedido(cliente1,"RECOGER");
		pedido1.addPizzaPedido(pizza4);
		pizzeria.addPedido(pedido1);
		
		pizzeria.addPizzas(pizza1);
		pizzeria.addPizzas(pizza2);
		pizzeria.addPizzas(pizza3);
		pizzeria.addPizzas(pizza4);
		
		pizzeria.addClientes(cliente1);
		pizzeria.addClientes(cliente2);
		pizzeria.addClientes(cliente3);
		pizzeria.addClientes(cliente4);
		
		
		int opcion;
		do {
			System.out.println();
			System.out.println("----- Menu -----");
			System.out.printf("1. Nueva pizza \n2. Nuevo cliente \n3. Realizar un pedido \n4. Ver pizzas "
					+ "\n5. Ver pedidos \n6. Ver clientes \n7. Consultar cliente mediante su telefono"
					+ "\n8. Buscar pizzas con ingrediente \n9. Buscar pizza sin ingrediente \n10. Pedidos de hoy"
					+ "\n11. Pedidos consumidos en el local \n12. Pedidos para recoger \n13. Pedidos a domicilio"
					+ "\n14. Pizza mas cara \n15. Pizza mas barata \n16. Ultimo pedido realizado \n17. Eliminar pizza de pedido \n18. Añadir pizza \n 19. Añadir saldo al cliente \n"
					+ "20. Salir del menú");

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
				Pedido pe = nuevoPedido(sc, pizzeria);
				int p1;
				do {
					System.out.println("¿Qué pizza quieres añadir?");
					pizzeria.mostrarNombrePizza();
					System.out.println("Si no quieres añadir más pizzas presiona 0.");
					p1 = sc.nextInt();
					if (p1 != 0) {
						pe.addPizzaPedido(pizzeria.comprobarIdPizza(p1));
					}
				} while (p1 != 0);
				pe.mostrarInfoPedido();
				do {
					System.out.println("¿Que pizza quieres eliminar?");
					pe.mostrarPizzasPedido();
					System.out.println("Si no quieres eliminar las pizzas, pulsa 0. ");
					p1 = sc.nextInt();
					if (p1 != 0) {
						pe.delPizzaPedido(p1);
					}
				} while (p1 != 0);
				if (pe.saldoCliente() < pe.getTotal()) {
					System.out.println("No tienes saldo suficiente para hacer el pedido. El pedido ha sido cancelado.");
				} else {
					pizzeria.addPedido(pe);
					pe.cobrarPedidoCliente(pe.getTotal());
					pe.mostrarInfoPedido();
					System.out.println("Pedido realizado.");
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
				System.out.println("Introduce el ingrediente: ");
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
				break;

			case 17:
				pizzeria.eliminarPizza(sc);
				break;
			case 18:
				pizzeria.agregarPizza(sc);
				break;
			case 19:
				System.out.println("¿A qué cliente quieres añadir dinero?");
				int c1 = sc.nextInt();
				Cliente cliente = pizzeria.comprobarIdCliente(c1);
				System.out.println("¿Cuánto dinero quieres introducir?");
				double saldo = sc.nextDouble();
				cliente.aumentarSaldoDisponible(saldo);
				break;
			default:

				if (opcion != 20) {

					System.out.println("Esta opción no es válida.");
				} else {
					System.out.println("Ha salido del menú.");
				}
				break;
			}
		
				

		} while (opcion != 19);

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
		System.out.println("¿Cuanto saldo quieres introducir (0-...)?");
		double dineroDisponible = sc.nextDouble();
		return new Cliente(nombre, direccion, email, telefono, dineroDisponible);
	}

	public static Pedido nuevoPedido(Scanner sc, Pizzeria pizzeria) {
		System.out.println("ID Cliente: ");
		int cliente = sc.nextInt();
		System.out.println("Tipo de entrega: LOCAL,RECOGER,DOMICILIO");
		String tipo = sc.next().toUpperCase();

		return new Pedido(pizzeria.comprobarIdCliente(cliente), tipo);
	}

}
