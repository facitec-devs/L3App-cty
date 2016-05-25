package py.edu.facitec.l3.model;

import java.util.Date;

public class Deposito {

	private int codigo;
	private String nombre;
	private String abreviatura;
	private boolean estado;
	private Date fecha_registro;
	public Deposito() {
		super();
		this.codigo = 0;
		this.nombre = "";
		this.abreviatura = "";
		this.estado = false;
		this.fecha_registro = new Date();
	}
	public Deposito(int codigo, String nombre, String abreviatura, boolean estado, Date fecha_registro) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.estado = estado;
		this.fecha_registro = fecha_registro;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
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
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}



}
