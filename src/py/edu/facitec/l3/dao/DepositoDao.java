package py.edu.facitec.l3.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Deposito;
import py.edu.facitec.l3.util.ConexionManager;

public class DepositoDao {

	public static void guardarDeposito(Deposito deposito){

		String sql="insert into tb_deposito(nombre,abreviatura,estado,fecha_registro) "
				+ "values ('"+deposito.getNombre()+"','"+deposito.getAbreviatura()+"',"+deposito.isEstado()+","
				+ " '"+deposito.getFecha_registro()+"')";		
		System.out.println(sql);
		ConexionManager.abrirConexion();
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}

	public static Deposito buscarDepositoPorId(int id){
		String sql= "select * from tb_deposito where codigo = "+id+";";

		ConexionManager.abrirConexion();
		Deposito deposito = null;
		System.out.println(sql);

		try {
			ResultSet rs= ConexionManager.stm.executeQuery(sql);

			if (rs.next()) {
				deposito =  new Deposito();

				deposito.setCodigo(rs.getInt("codigo"));
				deposito.setNombre(rs.getString("nombre"));
				deposito.setAbreviatura(rs.getString("abreviatura"));
				deposito.setEstado(rs.getBoolean("estado"));
				deposito.setFecha_registro(rs.getString("fecha_registro"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return deposito;
	}

	public static void modificarDeposito(Deposito deposito){
		String sql="update tb_deposito set "
				+ "nombre='"+deposito.getNombre()+"',"
				+"abreviatura='"+deposito.getAbreviatura()+"', "
				+"estado="+deposito.isEstado()+", "
				+"fecha_registro='"+deposito.getFecha_registro()+ "' where "
				+"codigo="+deposito.getCodigo()+" ";	
		System.out.println(sql);
		ConexionManager.abrirConexion();
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionManager.cerrarConexion();
	}

	public static void eliminarDepositoPorCodigo(int codigo) {
		String sql ="delete from tb_deposito where codigo="+codigo+"";

		ConexionManager.abrirConexion();

		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}

	public static int recuperarUltimoCodigo(){
		String sql = "SELECT MAX(codigo) AS codigo FROM tb_deposito";
		System.out.println(sql);
		
		int codigo = 0;
		ConexionManager.abrirConexion();
		
		try {
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			
			while (rs.next()) {
				
				codigo = rs.getInt("codigo");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConexionManager.cerrarConexion();
		return codigo;
	}
	
}