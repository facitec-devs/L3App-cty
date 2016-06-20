package py.edu.facitec.l3.model;

public class Transferencia {

	private int codigo;
	private String comprobante;
	private String depositoOrigen;
	private String depositoDestino;
	private int totalItems;
	private String fecha;
	private String observaciones;
	
	public Transferencia() {
		super();
		codigo= 0;
		comprobante= "";
		depositoOrigen= "";
		depositoDestino="";
		totalItems=0;
		fecha= "";
		observaciones="";
	}

	public Transferencia(int codigo, String comprobante, String depositoOrigen,
			String depositoDestino, int totalItems, String fecha,
			String observaciones) {
		super();
		this.codigo = codigo;
		this.comprobante = comprobante;
		this.depositoOrigen = depositoOrigen;
		this.depositoDestino = depositoDestino;
		this.totalItems = totalItems;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public String getDepositoOrigen() {
		return depositoOrigen;
	}

	public void setDepositoOrigen(String depositoOrigen) {
		this.depositoOrigen = depositoOrigen;
	}

	public String getDepositoDestino() {
		return depositoDestino;
	}

	public void setDepositoDestino(String depositoDestino) {
		this.depositoDestino = depositoDestino;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
}
