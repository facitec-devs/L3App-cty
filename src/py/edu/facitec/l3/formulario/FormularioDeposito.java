package py.edu.facitec.l3.formulario;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import py.edu.facitec.l3.dao.DepositoDao;
import py.edu.facitec.l3.model.Deposito;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FormularioDeposito extends JDialog {
	private JTextField tfNombre;
	private JTextField tfAbreviatura;
	private JTextField tfCodigo;
	private JCheckBox chActivo;
	private JTextField tfFecha;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private int estado;
	private JCheckBox chEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioDeposito dialog = new FormularioDeposito();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FormularioDeposito() {
		setBounds(100, 100, 500, 337);
		getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 51, 67, 14);
		getContentPane().add(lblNombre);

		JLabel lblAbreviatura = new JLabel("Abreviatura:");
		lblAbreviatura.setBounds(10, 91, 74, 14);
		getContentPane().add(lblAbreviatura);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 139, 46, 14);
		getContentPane().add(lblEstado);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 183, 46, 14);
		getContentPane().add(lblFecha);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCliente();
			}
		});
		btnGuardar.setBounds(10, 246, 89, 23);
		getContentPane().add(btnGuardar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarDeposito();
			}
		});
		btnModificar.setBounds(120, 246, 89, 23);
		getContentPane().add(btnModificar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarDepsito();
			}
		});
		btnBorrar.setBounds(235, 246, 89, 23);
		getContentPane().add(btnBorrar);

		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfAbreviatura.requestFocus();
				}
			}
		});
		tfNombre.setBounds(90, 48, 213, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		tfAbreviatura = new JTextField();
		tfAbreviatura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					chEstado.setSelected(true);
					tfFecha.requestFocus();
				}
			}
		});
		tfAbreviatura.setBounds(87, 88, 86, 20);
		getContentPane().add(tfAbreviatura);
		tfAbreviatura.setColumns(10);

		chEstado = new JCheckBox("Activo");
		chEstado.addKeyListener(new KeyAdapter() {

		});
		chEstado.setBounds(66, 135, 97, 23);
		getContentPane().add(chEstado);

		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfNombre.requestFocus();
				}
			}
		});
		tfCodigo.setBounds(90, 8, 86, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);

		tfFecha = new JTextField();
		tfFecha.setBounds(66, 180, 143, 20);
		getContentPane().add(tfFecha);
		tfFecha.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = 2;
				buscarDeposito(Integer.parseInt(tfCodigo.getText()));
			}
		});
		btnBuscar.setBounds(268, 7, 89, 23);
		getContentPane().add(btnBuscar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfFecha.setText(fechaActual().toString());
				limpiarCampos();
			}
		});
		btnNuevo.setBounds(356, 246, 89, 23);
		getContentPane().add(btnNuevo);

		recuperarUltimoCodigo();
		tfFecha.setText(fechaActual().toString());

	}

	private void guardarCliente() {

		if (tfNombre.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Ingrese el nombre");
			tfNombre.requestFocus();

		}else if (tfAbreviatura.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Ingrese la abreviatura");
			tfAbreviatura.requestFocus();	

		}else{

			Deposito deposito = new Deposito();//isntanciar una clase

			//setear al atributo nombre el valor del
			//campo de texto tfNombre
			deposito.setNombre(tfNombre.getText());
			deposito.setAbreviatura(tfAbreviatura.getText());
			deposito.setEstado(chEstado.isSelected());
			deposito.setFecha_registro(tfFecha.getText());

			JOptionPane.showMessageDialog(this, "Se a guardado con exito!!");
			//le pasamos el objeto cargado
			DepositoDao.guardarDeposito(deposito);

		}
		limpiarCampos();

	}

	public static String fechaActual(){

		java.util.Date  fecha = new java.util.Date(); 
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY"); 

		return  formatoFecha.format(fecha);
	}

	private void limpiarCampos(){
		tfCodigo.selectAll();
		tfCodigo.setText("");
		tfCodigo.requestFocus();
		tfNombre.setText("");
		tfAbreviatura.setText("");
		chEstado.setSelected(false);
		tfFecha.setText("");
		tfFecha.setText(fechaActual().toString());
		recuperarUltimoCodigo();
	}

	private void modificarDeposito() {
		Deposito deposito = new Deposito();
		deposito.setCodigo(Integer.parseInt(tfCodigo.getText()));
		deposito.setNombre(tfNombre.getText());
		deposito.setAbreviatura(tfAbreviatura.getText());
		deposito.setFecha_registro(tfFecha.getText());
		
		if (chEstado.isSelected()) {
			deposito.setEstado(true);
		}else{
			deposito.setEstado(false);
		}
		DepositoDao.modificarDeposito(deposito);
		limpiarCampos();
	}

	private void eliminarDepsito() {

		int bor= JOptionPane.showConfirmDialog(this, "¿Seguro quieres eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);

		if (bor==JOptionPane.YES_OPTION) {
			DepositoDao.eliminarDepositoPorCodigo(Integer.parseInt(tfCodigo.getText()));
			JOptionPane.showMessageDialog(this, "El Registro se a Eliminado!!");
			limpiarCampos();
		}
	}

	private void buscarDeposito(int codigo){
		Deposito dep = DepositoDao.buscarDepositoPorId(codigo);
		if (dep != null) {

			tfCodigo.setText(Integer.toString(dep.getCodigo()));
			tfNombre.setText(dep.getNombre());
			tfAbreviatura.setText(dep.getAbreviatura());
			tfFecha.setText(dep.getFecha_registro());
			chEstado.setSelected(dep.isEstado());
		}
		else {
			JOptionPane.showMessageDialog(this, "No existe cliente con ese codigo", "Aviso", 1);
			limpiarCampos();
		}
	}

	private void recuperarUltimoCodigo() {
		int codigo;

		codigo = DepositoDao.recuperarUltimoCodigo() + 1;

		tfCodigo.setText(String.valueOf(codigo));
		tfCodigo.selectAll();
	}



}//END
