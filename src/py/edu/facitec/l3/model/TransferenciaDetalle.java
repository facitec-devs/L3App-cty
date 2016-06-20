package py.edu.facitec.l3.model;

public class TransferenciaDetalle {

	private int codigo;
	private String nombre;
	private int cantidad;
	private Double subtotal;
	public TransferenciaDetalle() {
		super();
		codigo=0;
		nombre="";
		cantidad=0;
		subtotal=0.0;
	}
	
	public TransferenciaDetalle(int codigo, String nombre, int cantidad,
			Double subtotal) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
}
