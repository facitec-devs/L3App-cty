package py.edu.facitec.l3.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import py.edu.facitec.l3.model.Deposito;
import py.edu.facitec.l3.util.ConexionManager;

public class DepositoDao {

	public static void guardarDeposito(Deposito deposito){

		String sql="insert into tb_deposito(nombre,abreviatura,estado,fecha) "
				+ "values ('"+deposito.getNombre()+"','"+deposito.getAbreviatura()+"',"+deposito.isEstado()+""
				+ "'+deposito.getFecha_registro()+')";		
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

		ConexionManager.abrirConexion();//abrimos la conexion
		Deposito deposito = null;
		System.out.println(sql);

		try {
			//executar el sql que montamos contra la base de datos devolviendo resultado
			ResultSet rs= ConexionManager.stm.executeQuery(sql);

			//si tiene un resultado
			if (rs.next()) {
				deposito =  new Deposito();//instancio mi clase, para crear objeto

				deposito.setCodigo(rs.getInt("codigo"));
				deposito.setNombre(rs.getString("nombre"));
				deposito.setAbreviatura(rs.getString("abreviatura"));
				deposito.setEstado(rs.getBoolean("estado"));
				deposito.setFecha_registro(rs.getDate("fecha_registro"));
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
				+"estado="+deposito.isEstado()+""
				+"fecha_registro="+deposito.getFecha_registro()+ " where "
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

}