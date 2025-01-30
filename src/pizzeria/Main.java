package pizzeria;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Pizzeria pizzeria = new Pizzeria();

		int opcion;
		do {
			System.out.printf("1. Nueva pizza \n2. Nuevo cliente \n3. Realizar un pedido \n4. Ver pizzas "
					+ "\n5. Ver pedidos \n6. Ver clientes \n7. Consultar cliente mediante su telefono"
					+ "\n8. Buscar pizzas con ingrediente \n9. Buscarpizza sin ingrediente \n10. Pedidos de hoy"
					+ "\n11. Pedidos consumidos en el local \n12. Pedidos para recoger \n13. Pedidos a domicilio"
					+ "\n14. Pizza mas cara \n15. Pizza mas barata \n16. Ultimo pedido realizado \n17. Salir");

			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				Pizza p = nuevaPizza(sc);
				Pizzeria.registrarPizzas(p);
				break;
			}
		} while (opcion > 0 && opcion <= 17);

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

	public static void verPizzas(List<Pizza> pizzas) {
		for (Pizza p : pizzas) {
			System.out.println(p);
		}
	}
}