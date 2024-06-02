
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package JPanel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.Box;
import javax.swing.JPasswordField;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import Clases.SessionManager;
import Clases.conexion;
import Clases.personas;

import Consultas.consultas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JFrame;


import java.awt.Dimension;

public class iniciosesion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtInicioDeSesion;
	private JTextField txtBank;
	private JPasswordField passwordField;
	private JTextField txtContrasea;
	private JTextField txtUsuario;
	private JTextField txtauthorJuancaaaversion;
	

	/**
	 * Create the panel.
	 */
	public iniciosesion() {
		
		
		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		txtInicioDeSesion = new JTextField();
		txtInicioDeSesion.setForeground(SystemColor.desktop);
		txtInicioDeSesion.setEditable(false);
		txtInicioDeSesion.setBorder(new MatteBorder(2, 2, 3, 2, (Color) new Color(0, 0, 0)));
		txtInicioDeSesion.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtInicioDeSesion.setBackground(new Color(0, 54, 155));
		txtInicioDeSesion.setHorizontalAlignment(SwingConstants.CENTER);
		txtInicioDeSesion.setText("INICIO DE SESION");
		txtInicioDeSesion.setBounds(220, 204, 238, 43);
		add(txtInicioDeSesion);
		txtInicioDeSesion.setColumns(10);
		
		JButton terminosbank = new JButton("\u00BFHas olvidado tu contrase\u00F1a?");
		terminosbank.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		terminosbank.setBackground(SystemColor.textHighlight);
		terminosbank.setFont(new Font("Verdana", Font.PLAIN, 13));
		terminosbank.setForeground(SystemColor.windowText);
		terminosbank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame("Recuperacion Contraseña ");

                
                JPanel panelRecuperacion = new recuperacion();
                frame.getContentPane().add(panelRecuperacion);
                frame.setSize(647,529);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setIconImage(new ImageIcon("src/Imagenes/logo.png").getImage());
			}	
		});
		
		
		terminosbank.setBounds(40, 452, 205, 23);
		add(terminosbank);
		
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
		passwordField.setBounds(259, 377, 199, 20);
		add(passwordField);
		
		txtContrasea = new JTextField();
		txtContrasea.setEditable(false);
		txtContrasea.setBorder(null);
		txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		txtContrasea.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtContrasea.setBackground(SystemColor.textHighlight);
		txtContrasea.setForeground(Color.BLACK);
		txtContrasea.setText("PASSWORD");
		txtContrasea.setBounds(163, 376, 86, 20);
		add(txtContrasea);
		txtContrasea.setColumns(10);
		
		JTextArea textUsuario = new JTextArea();
		textUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textUsuario.setBounds(259, 326, 199, 20);
		add(textUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setEditable(false);
		txtUsuario.setBorder(null);
		txtUsuario.setBackground(SystemColor.textHighlight);
		txtUsuario.setText("USER");
		txtUsuario.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(163, 327, 86, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 	consultas consulta = new consultas();
					
	                String usuario = textUsuario.getText();
	                String contrasena = new String(passwordField.getPassword());
	               
	                
	                if (usuario.isEmpty() || contrasena.isEmpty()) {
	                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios. Por favor, complete todos los campos.");
	                        return; 
	                    } 
	                
	                boolean credencialesCorrectas = consultas.verificarCredenciales(usuario, contrasena);
	             
	                
	               

	                if (credencialesCorrectas) {
	                	
	                	
	                	personas persona = new personas();
	                	
	                	persona.setUsuario(usuario);
	                	         
	                	
	                	SessionManager.iniciarSesion(persona);
	                	
	                	JOptionPane.showMessageDialog(null, "Correcto, has iniciado correctamente!");
	                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(iniciosesion.this);

	                    // Remover el panel actual (iniciosesion)
	                    frame.getContentPane().remove(iniciosesion.this);

	                    // Crear y agregar el panel menu
	                    JPanel panelMenu = new menu();
	                    frame.getContentPane().add(panelMenu);

	                    // Validar y repintar el contenedor principal 
	                    frame.validate();
	                    frame.repaint();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            
				
			}
		});
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.setBounds(313, 418, 89, 23);
		add(btnNewButton);

		
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(".//src//Imagenes//logo.png"));
		Logo.setBounds(334, 173, 454, 398);
		add(Logo);
		
		txtauthorJuancaaaversion = new JTextField();
		txtauthorJuancaaaversion.setForeground(SystemColor.desktop);
		txtauthorJuancaaaversion.setEditable(false);
		txtauthorJuancaaaversion.setBorder(null);
		txtauthorJuancaaaversion.setBackground(SystemColor.textHighlight);
		txtauthorJuancaaaversion.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtauthorJuancaaaversion.setText("@author: juancaaa11 @version: 1.0");
		txtauthorJuancaaaversion.setBounds(10, 519, 286, 20);
		add(txtauthorJuancaaaversion);
		txtauthorJuancaaaversion.setColumns(10);
	
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(iniciosesion.this);

                 // Remover el panel actual (iniciosesion)
                 frame.getContentPane().remove(iniciosesion.this);

                 // Crear y agregar el panel menu
                 JPanel panelBienvenidos = new bienvenido();
                 frame.getContentPane().add(panelBienvenidos);

                 // Validar y repintar el contenedor principal 
                 frame.validate();
                 frame.repaint();
			
			}
		});
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setBackground(SystemColor.window);
		btnAtras.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 23));
		btnAtras.setBounds(548, 143, 128, 33);
		add(btnAtras);
		
	}
}
