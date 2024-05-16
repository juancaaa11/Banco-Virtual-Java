
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package JPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

import Clases.SessionManager;
import Clases.personas;
import Consultas.consultas;

import java.awt.Font;

public class credito extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField numeroCuenta;
	private JTextField Nombre;
	private JLabel logo;
	private JTextField txtNumeroDeTarjeta;
	private JTextField txtNombreTitular;

	/**
	 * Create the panel.
	 */
	public credito() {
		
		consultas consultas = new consultas();
		
		personas usuarioActivo = SessionManager.getUsuarioActivo();
		
		String informacionUsuario = usuarioActivo.getUsuario();
		
		String nombreReal = consultas.obtenerNombre(informacionUsuario);
		
		String apellidos= consultas.obtenerApellidoCompleto(informacionUsuario);
		
		String numCuenta = consultas.obtenerNumeroCuenta(informacionUsuario);
		
		setBackground(SystemColor.controlDkShadow);
		setLayout(null);
		
		txtNumeroDeTarjeta = new JTextField();
		txtNumeroDeTarjeta.setEditable(false);
		txtNumeroDeTarjeta.setBorder(null);
		txtNumeroDeTarjeta.setForeground(Color.WHITE);
		txtNumeroDeTarjeta.setBackground(new Color(231, 84, 87));
		txtNumeroDeTarjeta.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		txtNumeroDeTarjeta.setText("Numero de Tarjeta");
		txtNumeroDeTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroDeTarjeta.setBounds(98, 252, 189, 20);
		add(txtNumeroDeTarjeta);
		txtNumeroDeTarjeta.setColumns(10);
		
		txtNombreTitular = new JTextField();
		txtNombreTitular.setEditable(false);
		txtNombreTitular.setText("Nombre Titular");
		txtNombreTitular.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreTitular.setForeground(Color.WHITE);
		txtNombreTitular.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		txtNombreTitular.setColumns(10);
		txtNombreTitular.setBorder(null);
		txtNombreTitular.setBackground(new Color(231, 84, 87));
		txtNombreTitular.setBounds(202, 32, 189, 20);
		add(txtNombreTitular);
		
		
		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(".//src//Imagenes//logopeque.png"));
		logo.setBackground(new Color(243, 5, 41));
		logo.setBounds(386, 232, 52, 52);
		add(logo);
		
		numeroCuenta = new JTextField();
		numeroCuenta.setFont(new Font("Arial", Font.BOLD, 27));
		numeroCuenta.setBorder(null);
		numeroCuenta.setText(numCuenta + 0);
		numeroCuenta.setEditable(false);
		numeroCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		numeroCuenta.setForeground(Color.BLACK);
		numeroCuenta.setBackground(new Color(243, 5, 41));
		numeroCuenta.setBounds(21, 201, 330, 40);
		add(numeroCuenta);
		numeroCuenta.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setText(nombreReal + " " + apellidos);
		Nombre.setBorder(null);
		Nombre.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		Nombre.setEditable(false);
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setForeground(Color.BLACK);
		Nombre.setBackground(new Color(243, 5, 41));
		Nombre.setBounds(151, 63, 287, 52);
		add(Nombre);
		Nombre.setColumns(10);
		
		JLabel Tarjeta = new JLabel("");
		Tarjeta.setIcon(new ImageIcon(".//src//Imagenes//credito.png"));
		Tarjeta.setBounds(10, 11, 550, 288);
		add(Tarjeta);
		
		
	

	}
}
