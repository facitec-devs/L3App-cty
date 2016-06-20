package py.edu.facitec.l3.dao;

import java.sql.SQLException;

import py.edu.facitec.l3.model.Transferencia;
import py.edu.facitec.l3.model.TransferenciaDetalle;
import py.edu.facitec.l3.util.ConexionManager;

public class TransferenciaDao {

	public static void guardarTransferencia(Transferencia trans){

		String sql="insert into tb_transferencia(codigo,comprobante,fecha,deposito_origen,deposito_destino,total_items,observaciones)"
				+ "VALUES("+trans.getCodigo()+",'"+trans.getComprobante()+"','"+trans.getFecha()+"',"
				+ "'"+trans.getDepositoOrigen()+"','"+trans.getDepositoDestino()+"',"+trans.getTotalItems()+","
				+ "'"+trans.getObservaciones()+"' )";

		System.out.println(sql);
		ConexionManager.abrirConexion();
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}

	public static void guardadDetalle(TransferenciaDetalle detalle) {
		String sql="insert into tb_transferencia_detalle(codigo,nombre,cantidad,subtotal)"
				+ "VALUES("+detalle.getCodigo()+",'"+detalle.getNombre()+"',"+detalle.getCantidad()+","+detalle.getSubtotal()+" )";

		System.out.println(sql);
		ConexionManager.abrirConexion();
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}

	
}
