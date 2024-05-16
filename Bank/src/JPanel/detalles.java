
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
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

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class detalles extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBank;
	private JTextField txtauthorJuancaaaversion;
	private JTextField txtDetallesCuenta;
	private JLabel Logo;
	private JTextField txtApellido1;
	private JTextField txtTelefono;
	private JTextField txtdni;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JTextField textField;
	private JTextField txtVerTarjeta;
	

	/**
	 * Create the panel.
	 */
	public detalles() {
		
		consultas consultas = new consultas();
		personas usuarioActivo = SessionManager.getUsuarioActivo();
		String informacionUsuario = usuarioActivo.getUsuario();
		

		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(".//src//Imagenes//logopeque.png"));
		Logo.setBounds(627, 484, 64, 55);
		add(Logo);
		
		txtBank = new JTextField();
		txtBank.setForeground(SystemColor.desktop);
		txtBank.setBounds(10, 42, 681, 90);
		txtBank.setEditable(false);
		txtBank.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtBank.setBackground(new Color(94, 169, 253));
		txtBank.setFont(new Font("Segoe UI Black", Font.PLAIN, 81));
		txtBank.setText("BANK!");
		txtBank.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtBank);
		txtBank.setColumns(10);
		
		txtApellido1 = new JTextField();
		txtApellido1.setEditable(false);
		txtApellido1.setBorder(null);
		txtApellido1.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellido1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtApellido1.setBackground(SystemColor.textHighlight);
		txtApellido1.setForeground(new Color(255, 255, 255));
		txtApellido1.setText("APELLIDOS");
		txtApellido1.setBounds(222, 339, 86, 20);
		add(txtApellido1);
		txtApellido1.setColumns(10);
		
		String nombre=consultas.obtenerNombre(informacionUsuario);
		
		JTextArea textNombre = new JTextArea();
		textNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		textNombre.setBackground(SystemColor.textHighlight);
		textNombre.setForeground(Color.BLACK);
		textNombre.setEditable(false);
		textNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textNombre.setBounds(353, 304, 161, 22);
		add(textNombre);
		
		if (nombre != null) {
		    textNombre.setText(nombre);
		} else {
		    textNombre.setText("Null");
		}
		
		
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBorder(null);
		txtTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		txtTelefono.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTelefono.setBackground(SystemColor.textHighlight);
		txtTelefono.setForeground(new Color(255, 255, 255));
		txtTelefono.setText("TELEFONO");
		txtTelefono.setBounds(222, 372, 86, 20);
		add(txtTelefono);
		txtTelefono.setColumns(10);
		
		
		
		
		String dni=consultas.obtenerDNI(informacionUsuario);
		
		JTextArea textDNI = new JTextArea();
		textDNI.setFont(new Font("Dialog", Font.BOLD, 16));
		textDNI.setBackground(SystemColor.textHighlight);
		textDNI.setForeground(Color.BLACK);
		textDNI.setEditable(false);
		textDNI.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textDNI.setBounds(353, 271, 161, 22);
		add(textDNI);
		
		if (dni != null) {
		    textDNI.setText(dni);
		} else {
		    textDNI.setText("Null");
		}
		
		txtdni = new JTextField();
		txtdni.setEditable(false);
		txtdni.setBorder(null);
		txtdni.setHorizontalAlignment(SwingConstants.LEFT);
		txtdni.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		txtdni.setBackground(SystemColor.textHighlight);
		txtdni.setForeground(new Color(255, 255, 255));
		txtdni.setText("DNI ");
		txtdni.setBounds(222, 274, 86, 20);
		add(txtdni);
		txtdni.setColumns(10);
		
		
		String apellidos = consultas.obtenerApellidoCompleto(informacionUsuario);
	
		
		JTextArea textApellidos = new JTextArea();
		textApellidos.setFont(new Font("Dialog", Font.BOLD, 16));
		textApellidos.setForeground(SystemColor.desktop);
		textApellidos.setBackground(SystemColor.textHighlight);
		textApellidos.setEditable(false);
		textApellidos.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textApellidos.setBounds(353, 337, 161, 22);
		add(textApellidos);
		
		if (apellidos != null) {
		    textApellidos.setText(apellidos);
		} else {
		    textApellidos.setText("Null");
		}
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBorder(null);
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtNombre.setBackground(SystemColor.textHighlight);
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setText("NOMBRE");
		txtNombre.setBounds(222, 306, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
			
		
		
		JTextArea textUsuario = new JTextArea();
		textUsuario.setCaretColor(SystemColor.desktop);
		textUsuario.setDisabledTextColor(Color.BLACK);
		textUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		textUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textUsuario.setBackground(SystemColor.textHighlight);
		textUsuario.setForeground(Color.BLACK);
		textUsuario.setBounds(396, 221, 161, 10);
		add(textUsuario);
		textUsuario.setBounds(353, 238, 161, 22);
		add(textUsuario);
		
		
		if (usuarioActivo != null) {
		    textUsuario.setText(informacionUsuario);
		} else {
		    textUsuario.setText("Null");
		}
		
		
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(255, 255, 255));
		txtUsuario.setEditable(false);
		txtUsuario.setBorder(null);
		txtUsuario.setBackground(SystemColor.textHighlight);
		txtUsuario.setText("USUARIO");
		txtUsuario.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setBounds(222, 243, 86, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		JLabel Icono = new JLabel("");
		Icono.setHorizontalAlignment(SwingConstants.CENTER);
		Icono.setIcon(new ImageIcon(".//src//Imagenes//icono.png"));
		Icono.setBounds(56, 269, 129, 114);
		add(Icono);
		
		
		txtauthorJuancaaaversion = new JTextField();
		txtauthorJuancaaaversion.setForeground(SystemColor.desktop);
		txtauthorJuancaaaversion.setBounds(10, 519, 286, 20);
		txtauthorJuancaaaversion.setEditable(false);
		txtauthorJuancaaaversion.setBorder(null);
		txtauthorJuancaaaversion.setBackground(SystemColor.textHighlight);
		txtauthorJuancaaaversion.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtauthorJuancaaaversion.setText("@author: juancaaa11 @version: 1.0");
		add(txtauthorJuancaaaversion);
		txtauthorJuancaaaversion.setColumns(10);
		
		txtDetallesCuenta = new JTextField();
		txtDetallesCuenta.setEditable(false);
		txtDetallesCuenta.setBorder(new LineBorder(SystemColor.desktop, 3, true));
		txtDetallesCuenta.setBackground(SystemColor.controlShadow);
		txtDetallesCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		txtDetallesCuenta.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		txtDetallesCuenta.setForeground(SystemColor.desktop);
		txtDetallesCuenta.setText("DETALLES CUENTA:");
		txtDetallesCuenta.setBounds(237, 169, 214, 41);
		add(txtDetallesCuenta);
		txtDetallesCuenta.setColumns(10);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(detalles.this);

                
                 frame.getContentPane().remove(detalles.this);

               
                 JPanel panelmenu = new menu();
                 frame.getContentPane().add(panelmenu);

                 
                 frame.validate();
                 frame.repaint();
			
			}
		});
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setBackground(SystemColor.window);
		btnAtras.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 23));
		btnAtras.setBounds(548, 143, 128, 33);
		add(btnAtras);
		
		JButton btnNewButton = new JButton("actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nuevoUsuario = textUsuario.getText();
				boolean opcion = consultas.actualizarNombreUsuario(informacionUsuario, nuevoUsuario);
				
				if (opcion) {
					
					personas personas = new personas();
					personas.setUsuario(nuevoUsuario);
					SessionManager.iniciarSesion(personas);
					
				}
				
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.RED));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBounds(548, 241, 89, 20);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nuevoTelefono = textField.getText();
				String informacionUsuario1 = usuarioActivo.getUsuario();
				
				consultas.actualizarNumeroTelefono(informacionUsuario1, nuevoTelefono);
				
				
				
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.RED));
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(548, 373, 89, 20);
		add(btnNewButton_1);
		
		String telefono = consultas.obtenerTelefono(informacionUsuario);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 16));
		textField.setForeground(SystemColor.desktop);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBackground(SystemColor.textHighlight);
		textField.setBounds(353, 371, 161, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame("Tarjeta de " + nombre + " " + apellidos);

                
                JPanel panelcredito = new credito();
                frame.getContentPane().add(panelcredito);
                frame.setSize(486,350);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
				
				
			}
		});
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setIcon(new ImageIcon(".//src//Imagenes//2244.png"));
		btnNewButton_2.setBounds(383, 424, 101, 65);
		add(btnNewButton_2);
		
		txtVerTarjeta = new JTextField();
		txtVerTarjeta.setEditable(false);
		txtVerTarjeta.setBackground(SystemColor.textHighlight);
		txtVerTarjeta.setBorder(null);
		txtVerTarjeta.setForeground(SystemColor.activeCaption);
		txtVerTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		txtVerTarjeta.setFont(new Font("Dialog", Font.BOLD, 13));
		txtVerTarjeta.setText("ver tarjeta");
		txtVerTarjeta.setBounds(398, 484, 86, 20);
		add(txtVerTarjeta);
		txtVerTarjeta.setColumns(10);
		
		if (telefono != null) {
		    textField.setText(telefono);
		} else {
		    textField.setText("Null");
		}
		
		
	}
}
