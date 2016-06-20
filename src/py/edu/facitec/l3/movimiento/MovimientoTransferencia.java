package py.edu.facitec.l3.movimiento;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import py.edu.facitec.l3.model.Transferencia;
import py.edu.facitec.l3.model.TransferenciaDetalle;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovimientoTransferencia extends JDialog {
	private JTextField tfCodigo;
	private JTextField tfComprobante;
	private JTextField tfDepO;
	private JTextField tfDepD;
	private JTextField tfTotal;
	private JTextField tfObs;
	private JTextField tfFecha;
	private JTextField tfTransCodigo;
	private JTextField tfTransNombre;
	private JTextField tfTransCantidad;
	private JTextField textField_10;
	private JTextField textField_11;
	private JButton btnBuscarDepO;
	private JButton btnBuscarDepD;
	private JButton btnGuardar;
	private JButton btnAnular;
	private JButton btnCancelar;
	private JButton btnCerrar;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable tbDetalle;

	private DefaultTableModel dtmDetalle = new DefaultTableModel(null, new String[]{"Codigo", "Nombre", "Cantidad", "Precio", "SubTotal"})
	{boolean[] columnEditables = new boolean[]{false, false, false, false, false};

	public boolean isCellEditable(int row, int column){
		return columnEditables[column];
	}

	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovimientoTransferencia dialog = new MovimientoTransferencia();
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
	public MovimientoTransferencia() {
		setBounds(100, 100, 650, 500);
		getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);

		JLabel lblComprobante = new JLabel("Comprobante:");
		lblComprobante.setBounds(10, 36, 87, 14);
		getContentPane().add(lblComprobante);

		JLabel lblDepositoDeOrigen = new JLabel("Deposito de Origen:");
		lblDepositoDeOrigen.setBounds(10, 74, 111, 14);
		getContentPane().add(lblDepositoDeOrigen);

		JLabel lblDepositoDeDestino = new JLabel("Deposito de Destino:");
		lblDepositoDeDestino.setBounds(10, 113, 111, 14);
		getContentPane().add(lblDepositoDeDestino);

		JLabel lblTotalItems = new JLabel("Total Items:");
		lblTotalItems.setBounds(10, 155, 87, 14);
		getContentPane().add(lblTotalItems);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(353, 11, 46, 14);
		getContentPane().add(lblFecha);

		JLabel lblCodigo_1 = new JLabel("Codigo:");
		lblCodigo_1.setBounds(10, 195, 63, 14);
		getContentPane().add(lblCodigo_1);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(100, 195, 63, 14);
		getContentPane().add(lblNombre);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(384, 195, 70, 14);
		getContentPane().add(lblCantidad);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(356, 155, 87, 14);
		getContentPane().add(lblObservaciones);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(60, 8, 103, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);

		tfComprobante = new JTextField();
		tfComprobante.setBounds(107, 33, 131, 20);
		getContentPane().add(tfComprobante);
		tfComprobante.setColumns(10);

		tfDepO = new JTextField();
		tfDepO.setBounds(117, 71, 121, 20);
		getContentPane().add(tfDepO);
		tfDepO.setColumns(10);

		tfDepD = new JTextField();
		tfDepD.setBounds(127, 110, 111, 20);
		getContentPane().add(tfDepD);
		tfDepD.setColumns(10);

		tfTotal = new JTextField();
		tfTotal.setBounds(83, 152, 111, 20);
		getContentPane().add(tfTotal);
		tfTotal.setColumns(10);

		tfObs = new JTextField();
		tfObs.setBounds(453, 152, 121, 20);
		getContentPane().add(tfObs);
		tfObs.setColumns(10);

		tfFecha = new JTextField();
		tfFecha.setBounds(395, 8, 121, 20);
		getContentPane().add(tfFecha);
		tfFecha.setColumns(10);

		tfTransCodigo = new JTextField();
		tfTransCodigo.setBounds(10, 230, 63, 20);
		getContentPane().add(tfTransCodigo);
		tfTransCodigo.setColumns(10);

		tfTransNombre = new JTextField();
		tfTransNombre.setBounds(77, 230, 295, 20);
		getContentPane().add(tfTransNombre);
		tfTransNombre.setColumns(10);

		tfTransCantidad = new JTextField();
		tfTransCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					agregarTransferencia();
				}
			}
		});
		tfTransCantidad.setBounds(384, 230, 99, 20);
		getContentPane().add(tfTransCantidad);
		tfTransCantidad.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(248, 71, 233, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(248, 110, 233, 20);
		getContentPane().add(textField_11);
		textField_11.setColumns(10);

		btnBuscarDepO = new JButton("Buscar");
		btnBuscarDepO.setBounds(510, 70, 89, 23);
		getContentPane().add(btnBuscarDepO);

		btnBuscarDepD = new JButton("Buscar");
		btnBuscarDepD.setBounds(510, 109, 89, 23);
		getContentPane().add(btnBuscarDepD);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(510, 229, 89, 23);
		getContentPane().add(btnBuscar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(32, 416, 89, 23);
		getContentPane().add(btnGuardar);

		btnAnular = new JButton("Anular");
		btnAnular.setBounds(183, 416, 89, 23);
		getContentPane().add(btnAnular);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(335, 416, 89, 23);
		getContentPane().add(btnCancelar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(485, 416, 89, 23);
		getContentPane().add(btnCerrar);
		tfFecha.setText(fechaActual().toString());

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 260, 589, 145);
		getContentPane().add(scrollPane);

		tbDetalle = new JTable();
		scrollPane.setColumnHeaderView(tbDetalle);
		scrollPane.setRowHeaderView(tbDetalle);
		scrollPane.setViewportView(tbDetalle);
		tbDetalle.setModel(dtmDetalle);
	}

	private void guardar(){
		if (tfComprobante.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Ingrese el ncomprobante");
			tfComprobante.requestFocus();

		}else if (tfDepO.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Ingrese el Deposito Origen y todo los campos restantes");
			tfDepO.requestFocus();	

		}else{

			Transferencia tra = new Transferencia();
			tra.setComprobante(tfComprobante.getText());
			tra.setFecha(tfFecha.getText());
			tra.setDepositoOrigen(tfDepO.getText());
			tra.setDepositoDestino(tfDepD.getText());
			tra.setTotalItems(Integer.parseInt(tfTotal.getText()));
			tra.setObservaciones(tfObs.getText());

			TransferenciaDetalle det = new TransferenciaDetalle();


		}
	}

	public static String fechaActual(){

		java.util.Date  fecha = new java.util.Date(); 
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY"); 

		return  formatoFecha.format(fecha);
	}
	private void agregarTransferencia(){
		int precio, cantidad, subtotal;

		Object row[] =new Object[5];
		row [0] = tfTransCodigo.getText();
		row [1] = tfTransNombre.getText();
		row [2] = tfTransCantidad.getText();

		dtmDetalle.addRow(row);
	}

	private void cancelar(){

		int res = JOptionPane.showConfirmDialog(this, "Esta seguro que quieres cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);

		if (res == JOptionPane.YES_OPTION) {
			tfComprobante.setText("");
			tfDepO.setText("");
			tfDepD.setText("");
			tfTotal.setText("");
			tfObs.setText("");
			tfTransCodigo.setText("");
			tfTransNombre.setText("");
			tfTransCantidad.setText("");
		}
	}	

}//EnD

