
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package JPanel;

import java.awt.Color;
import Consultas.consultas;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;


import Clases.SessionManager;
import Clases.personas;
import Consultas.consultas;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class registrarte extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtRegistrarse;
	private JTextField txtBank;
	private JPasswordField passwordField;
	private JTextField txtContrasea;
	private JTextField txtauthorJuancaaaversion;
	private JTextField txtTelefono;
	private JTextField txtApellido1;
	private JTextField txtdni;
	private JTextField txtApellido2;
	private JTextArea textNombre;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	
    public static String generarNumeroCuenta(int longitud) {
        // Definir los dígitos válidos para el número de cuenta (0-9)
        String digitosValidos = "0123456789";

        // Crear un objeto Random
        Random random = new Random();

        // Crear un StringBuilder para construir el número de cuenta
        StringBuilder sb = new StringBuilder(longitud);

        // Generar el número de cuenta de la longitud especificada
        for (int i = 0; i < longitud; i++) {
            // Generar un índice aleatorio para seleccionar un dígito de la lista de dígitos válidos
            int indiceAleatorio = random.nextInt(digitosValidos.length());

            // Obtener el dígito aleatorio y agregarlo al StringBuilder
            char digitoAleatorio = digitosValidos.charAt(indiceAleatorio);
            sb.append(digitoAleatorio);
        }

        // Convertir el StringBuilder a una cadena y devolver el número de cuenta generado
        return sb.toString();
    }
	
	/**
	 * Create the panel.
	 */
	public registrarte() {

		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		txtRegistrarse = new JTextField();
		txtRegistrarse.setForeground(SystemColor.desktop);
		txtRegistrarse.setEditable(false);
		txtRegistrarse.setBorder(new MatteBorder(2, 2, 3, 2, (Color) new Color(0, 0, 0)));
		txtRegistrarse.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtRegistrarse.setBackground(new Color(0, 54, 155));
		txtRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistrarse.setText("REGISTRARSE");
		txtRegistrarse.setBounds(220, 204, 225, 43);
		add(txtRegistrarse);
		txtRegistrarse.setColumns(10);
		
		txtBank = new JTextField();
		txtBank.setForeground(SystemColor.desktop);
		txtBank.setEditable(false);
		txtBank.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtBank.setBackground(new Color(94, 169, 253));
		txtBank.setFont(new Font("Segoe UI Black", Font.PLAIN, 81));
		txtBank.setText("BANK!");
		txtBank.setHorizontalAlignment(SwingConstants.CENTER);
		txtBank.setBounds(10, 42, 680, 90);
		add(txtBank);
		txtBank.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(SystemColor.desktop, 3, true));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(44, 388, 161, 20);
		add(passwordField);
		
		txtApellido1 = new JTextField();
		txtApellido1.setEditable(false);
		txtApellido1.setBorder(null);
		txtApellido1.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtApellido1.setBackground(SystemColor.textHighlight);
		txtApellido1.setForeground(Color.BLACK);
		txtApellido1.setText("Apellido 1");
		txtApellido1.setBounds(292, 296, 73, 20);
		add(txtApellido1);
		txtApellido1.setColumns(10);
		
		JTextArea textApellido1 = new JTextArea();
		textApellido1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textApellido1.setBounds(252, 327, 161, 22);
		add(textApellido1);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBorder(null);
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTelefono.setBackground(SystemColor.textHighlight);
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setText("Telefono");
		txtTelefono.setBounds(507, 360, 86, 20);
		add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JTextArea textDNI = new JTextArea();
		textDNI.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textDNI.setBounds(468, 327, 161, 22);
		add(textDNI);
		
		txtdni = new JTextField();
		txtdni.setEditable(false);
		txtdni.setBorder(null);
		txtdni.setHorizontalAlignment(SwingConstants.CENTER);
		txtdni.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtdni.setBackground(SystemColor.textHighlight);
		txtdni.setForeground(Color.BLACK);
		txtdni.setText("DNI");
		txtdni.setBounds(528, 296, 42, 20);
		add(txtdni);
		txtdni.setColumns(10);
		
		JTextArea textTelefono = new JTextArea();
		textTelefono.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textTelefono.setBounds(468, 385, 161, 22);
		add(textTelefono);
		
		txtApellido2 = new JTextField();
		txtApellido2.setEditable(false);
		txtApellido2.setBorder(null);
		txtApellido2.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtApellido2.setBackground(SystemColor.textHighlight);
		txtApellido2.setForeground(Color.BLACK);
		txtApellido2.setText("Apellido 2");
		txtApellido2.setBounds(292, 360, 86, 20);
		add(txtApellido2);
		txtApellido2.setColumns(10);
		
		JTextArea textApellido2 = new JTextArea();
		textApellido2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textApellido2.setBounds(252, 385, 161, 22);
		add(textApellido2);
		
		txtContrasea = new JTextField();
		txtContrasea.setEditable(false);
		txtContrasea.setBorder(null);
		txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasea.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtContrasea.setBackground(SystemColor.textHighlight);
		txtContrasea.setForeground(Color.BLACK);
		txtContrasea.setText("Contrase\u00F1a");
		txtContrasea.setBounds(83, 360, 86, 20);
		add(txtContrasea);
		txtContrasea.setColumns(10);
		
		JTextArea textUsuario = new JTextArea();
		textUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textUsuario.setBounds(44, 327, 161, 22);
		add(textUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(SystemColor.desktop);
		txtUsuario.setEditable(false);
		txtUsuario.setBorder(null);
		txtUsuario.setBackground(SystemColor.textHighlight);
		txtUsuario.setText("Usuario");
		txtUsuario.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(83, 296, 86, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String usuario = textUsuario.getText();
                String contrasena = new String(passwordField.getPassword());
                String apellido1 = textApellido1.getText();
                String apellido2 = textApellido2.getText();
                String telefono = textTelefono.getText();
                String dni = textDNI.getText();
                String nombre = textNombre.getText();
                String num_cuenta = generarNumeroCuenta(10);
                double dinero_disp = 0.00;
               
                
                
                consultas consultas = new consultas();
                
                // Guardar los datos en variables para usar en la lógica de registro o verificación
             
				
                
                boolean registro = consultas.registrarUsuario(usuario, contrasena, apellido1, apellido2, telefono, dni, nombre, num_cuenta, dinero_disp);
                
                if (registro) {
                	
                	personas persona = new personas(nombre,dni,apellido1,apellido2,telefono,num_cuenta,dinero_disp,usuario);
                	
                
                	JFrame frame = (JFrame) getTopLevelAncestor();

     		        // Remover el JPanel actual (bienvenido) del contenedor principal
     		        frame.getContentPane().remove(registrarte.this);

     		        // Crear una instancia del JPanel de registro (registrarte)
     		        JPanel panelBienvenido = new bienvenido();

     		        // Agregar el JPanel de registro al contenedor principal
     		        frame.getContentPane().add(panelBienvenido);

     		        // Validar y repintar el contenedor principal
     		        frame.validate();
     		        frame.repaint();
                	
                } else {
                	
                	
                	JOptionPane.showMessageDialog(null, "Error al registrase!");
                }
               
            }
				
				
			
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.setBounds(292, 451, 89, 23);
		add(btnNewButton);

		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(".//src//Imagenes//logo.png"));
		Logo.setBounds(334, 173, 454, 398);
		add(Logo);
		
		txtauthorJuancaaaversion = new JTextField();
		txtauthorJuancaaaversion.setEditable(false);
		txtauthorJuancaaaversion.setBorder(null);
		txtauthorJuancaaaversion.setBackground(SystemColor.textHighlight);
		txtauthorJuancaaaversion.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtauthorJuancaaaversion.setText("@author: juancaaa11 @version: 1.0");
		txtauthorJuancaaaversion.setBounds(10, 519, 286, 20);
		add(txtauthorJuancaaaversion);
		txtauthorJuancaaaversion.setColumns(10);
		
		textNombre = new JTextArea();
		textNombre.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textNombre.setBounds(44, 451, 161, 20);
		add(textNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBorder(null);
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtNombre.setBackground(SystemColor.textHighlight);
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(83, 419, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setIcon(null);
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setBackground(SystemColor.window);
		btnAtras.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 23));
		btnAtras.setBounds(557, 143, 118, 28);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

			
				 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(registrarte.this);

                 
                 frame.getContentPane().remove(registrarte.this);

                
                 JPanel panelBienvenido = new bienvenido();
                 frame.getContentPane().add(panelBienvenido);

                 
                 frame.validate();
                 frame.repaint();
			
                 
                 
                 
			}
			
		
			
			
			
			
		});
	
		
		
	}
}
