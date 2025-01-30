package pizzeria;

import java.time.LocalDateTime;

import pizzeria.enums.EnumTipo;

public class Pedido {
	private static int contadorIdPedido;
	private int idPedido;
	private Cliente cliente;
	private LocalDateTime fecha;
	private double total;
	private EnumTipo tipo;

	public Pedido(String cliente, double total, EnumTipo tipo) {
		contadorIdPedido++;
		this.idPedido = contadorIdPedido;
		setCliente(cliente);
		this.fecha = LocalDateTime.now();
		setTotal(total);
	}

	public void setCliente(String cliente) {
		if (cliente == null || cliente.isBlank()) {
			throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o estar vacio");
		} else {
		}
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

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
	
	public EnumTipo getTipo() {
		return tipo;
	}
	
}
