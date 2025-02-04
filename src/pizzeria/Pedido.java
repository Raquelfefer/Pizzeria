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
	private List<Pizza> pizza;
	private static Pedido ultimoPedido;

	public Pedido(Cliente cliente, EnumTipo tipo) {
		contadorIdPedido++;
		this.idPedido = contadorIdPedido;
		setCliente(cliente);
		this.fecha = LocalDateTime.now();
		this.tipo = tipo;
		this.pizza = new ArrayList<Pizza>();
		this.total = 0.0;
		ultimoPedido = this;
	}

	public Pedido getUltimoPedido() {
		return ultimoPedido;
	}

	public void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("El nombre del cliente no puede ser nulo. ");
		}
		this.cliente = cliente;
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

	public EnumTipo getTipo() {
		return tipo;
	}

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void addPizza(Pizza pizza) {
		if (pizza == null) {
			throw new IllegalArgumentException("La pizza no esta en el sistema");
		}
		this.total += pizza.getPrecio();

	}

	public void mostrarPedido() {
		System.out.printf("ID pedido: " + idPedido + " \nCliente: " + cliente + "\nPizza: " + pizza
				+ " \nTipo de pedido: " + tipo);
	}

	public void mostrarUltimoPedido() {
		if (ultimoPedido != null) {
            System.out.println("Último pedido: ");
            ultimoPedido.mostrarPedido(); 
        }
	}
}
