package pizzeria;

public class Pedido {
	private static int contadorIdPedido;
	private int idPedido;
	private String cliente;
	private String fecha;
	private double total;
	private TipoPedido tipo;
	
	public Pedido(String cliente, String fecha, double total, TipoPedido tipo) {
		contadorIdPedido++;
		this.idPedido = contadorIdPedido;
		
	}
	
	public void setCliente(String cliente) {
		if(cliente == null || cliente.isBlank()) {
			throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o estar vacio");
		}else {
		this.cliente = cliente;
	}
		}
	public String getCliente() {
		return cliente;
	}
	
	
}
