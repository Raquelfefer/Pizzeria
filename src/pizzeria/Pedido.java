package pizzeria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pizzeria.enums.EnumTipo;

public class Pedido {
	private static int contadorIdPedido = 0;
	private int idPedido;
	private Cliente cliente;
	private LocalDateTime fecha;
	private double total;
	private EnumTipo tipo;
	private List<Pizza> pizzasPedido;
	private static Pedido ultimoPedido;

	public Pedido(Cliente cliente, String tipo) {
		contadorIdPedido++;
		this.idPedido = contadorIdPedido;
		this.cliente = cliente;
		this.fecha = LocalDateTime.now();
		setTipo(tipo);
		this.pizzasPedido = new ArrayList<Pizza>();
		this.total = 0.0;
		ultimoPedido = this;
	}

	public Pedido getUltimoPedido() {
		return ultimoPedido;
	}

	

	public void setTipo(String tipo) {
	    if (tipo == null || !(tipo.equals("LOCAL") || tipo.equals("RECOGER") || tipo.equals("DOMICILIO"))) {
	        throw new IllegalArgumentException("Tipo de entrega inválido. Debe ser LOCAL, RECOGER o DOMICILIO.");
	    }
	    this.tipo = EnumTipo.valueOf(tipo);
	}


	public Cliente getCliente() {
		return cliente;
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

	public void addPizzaPedido(Pizza p) {
			pizzasPedido.add(p);
			this.total += p.getPrecio();
	}
	
	public void mostrarInfoPedido() {
		if(!pizzasPedido.isEmpty()) {
			System.out.printf("ID: %s%nCliente: %s%nFecha: %s%nTotal: %.2f%nTipo: %s%n", idPedido, cliente.getId(), fecha, total,
				tipo);
			System.out.println("Pizzas: ");
			for (Pizza pizza : pizzasPedido) {
				System.out.println("- " + pizza.getNombre());
			}
		}
	}

	public static void mostrarUltimoPedido() {
		if (ultimoPedido != null) {
			System.out.println("Último pedido: ");
			ultimoPedido.mostrarInfoPedido();
		}
	}

	public void delPizzaPedido(int idPizza) {
		if (idPizza <= 0) {
			throw new IllegalArgumentException("El campo no puede ser menor o igual a 0.");
		}

		Pizza eliminarPizza = null;

// busca la pizza en la lista del pedido
		for (Pizza p : pizzasPedido) {
			if (p.getId() == idPizza) {
				eliminarPizza = p;
			}
		}
// elimina la pizza si la encuentra
		if (eliminarPizza != null) {
			pizzasPedido.remove(eliminarPizza);
			this.total -= eliminarPizza.getPrecio();
		} else {
			throw new IllegalArgumentException("Esta pizza no se encuentra en el pedido.");
		}
	}

	public void mostrarPizzasPedido() {
		for (Pizza p : pizzasPedido) {
			System.out.println("- " + p.getId() + " " + p.getNombre());
		}
	}
	
	public double saldoCliente() {
		return cliente.getDinero();
	}
	
	public void cobrarPedidoCliente(double dinero) {
		cliente.restarSaldoDisponible(dinero);
	}
}
