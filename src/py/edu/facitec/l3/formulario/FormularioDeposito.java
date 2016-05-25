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
import java.util.Date;
import java.awt.event.ActionEvent;


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
		lblNombre.setBounds(10, 51, 46, 14);
		getContentPane().add(lblNombre);

		JLabel lblAbreviatura = new JLabel("Abreviatura:");
		lblAbreviatura.setBounds(10, 91, 67, 14);
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
		btnModificar.setBounds(120, 246, 89, 23);
		getContentPane().add(btnModificar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(235, 246, 89, 23);
		getContentPane().add(btnBorrar);

		tfNombre = new JTextField();
		tfNombre.setBounds(66, 48, 213, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		tfAbreviatura = new JTextField();
		tfAbreviatura.setBounds(76, 88, 86, 20);
		getContentPane().add(tfAbreviatura);
		tfAbreviatura.setColumns(10);

		JCheckBox chActivo = new JCheckBox("Activo");
		chActivo.setBounds(66, 135, 97, 23);
		getContentPane().add(chActivo);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(51, 8, 86, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);

		tfFecha = new JTextField();
		tfFecha.setBounds(66, 180, 143, 20);
		getContentPane().add(tfFecha);
		tfFecha.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(178, 7, 89, 23);
		getContentPane().add(btnBuscar);

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
			deposito.setEstado(chActivo.isSelected());
			deposito.setFecha_registro(new Date(tfFecha.getText()));

			//le pasamos el objeto cargado
			DepositoDao.guardarDeposito(deposito);

		}
		limpiarCampos();

	}

	private void limpiarCampos(){
		tfCodigo.selectAll();
		tfCodigo.requestFocus();
		tfNombre.setText("");
		tfAbreviatura.setText("");
		chActivo.setSelected(false);
		tfFecha.setText("");
	}

	private void modificarDeposito() {
		Deposito deposito = new Deposito();
		deposito.setCodigo(Integer.parseInt(tfCodigo.getText()));
		deposito.setNombre(tfNombre.getText());
		deposito.setAbreviatura(tfAbreviatura.getText());
	}

}
