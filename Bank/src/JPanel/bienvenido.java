
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bienvenido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBank;
	private JTextField txtBank1;
	private JTextField txtBank2;
	private JTextField txtauthorJuancaaaversion;

	/**
	 * Create the panel.
	 */
	public bienvenido() {

		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		txtBank = new JTextField();
		txtBank.setForeground(SystemColor.desktop);
		txtBank.setBounds(10, 115, 681, 55);
		txtBank.setEditable(false);
		txtBank.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtBank.setBackground(new Color(94, 169, 253));
		txtBank.setFont(new Font("Segoe UI Black", Font.PLAIN, 81));
		txtBank.setText("BANK!");
		txtBank.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtBank);
		txtBank.setColumns(10);
		
		txtBank1 = new JTextField();
		txtBank1.setForeground(SystemColor.desktop);
		txtBank1.setBounds(10, 168, 681, 55);
		txtBank1.setEditable(false);
		txtBank1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtBank1.setBackground(new Color(94, 169, 253));
		txtBank1.setFont(new Font("Segoe UI Black", Font.PLAIN, 81));
		txtBank1.setText("BANK!");
		txtBank1.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtBank1);
		txtBank1.setColumns(10);
		
		txtBank2 = new JTextField();
		txtBank2.setForeground(SystemColor.desktop);
		txtBank2.setBounds(10, 64, 681, 55);
		txtBank2.setEditable(false);
		txtBank2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtBank2.setBackground(new Color(94, 169, 253));
		txtBank2.setFont(new Font("Segoe UI Black", Font.PLAIN, 81));
		txtBank2.setText("BANK!");
		txtBank2.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtBank2);
		txtBank2.setColumns(10);
		
		JLabel Welcome = new JLabel("");
		Welcome.setIcon(new ImageIcon(".//src//Imagenes//welcome.png"));
		Welcome.setBounds(468, 329, 223, 210);
		add(Welcome);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(".//src//Imagenes//logo.png"));
		Logo.setBounds(322, 181, 454, 398);
		add(Logo);
		
		JButton registrar = new JButton("REGISTRAR");
		registrar.setForeground(SystemColor.desktop);
		registrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        JFrame frame = (JFrame) getTopLevelAncestor();

		        // Remover el JPanel actual (bienvenido) del contenedor principal
		        frame.getContentPane().remove(bienvenido.this);

		        // Crear una instancia del JPanel de registro (registrarte)
		        JPanel panelRegistro = new registrarte();

		        // Agregar el JPanel de registro al contenedor principal
		        frame.getContentPane().add(panelRegistro);

		        // Validar y repintar el contenedor principal
		        frame.validate();
		        frame.repaint();
		    }
		});

		
		
		registrar.setBounds(48, 277, 250, 90);
		registrar.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		registrar.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		registrar.setBackground(SystemColor.menu);
		add(registrar);
		
		JButton iniciosesion = new JButton("INICIO DE SESION");
		iniciosesion.setForeground(SystemColor.desktop);
		iniciosesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JFrame frame = (JFrame) getTopLevelAncestor();

			        // Remover el JPanel actual (bienvenido) del contenedor principal
			        frame.getContentPane().remove(bienvenido.this);

			        // Crear una instancia del JPanel de registro (registrarte)
			        JPanel panelRegistro = new iniciosesion();

			        // Agregar el JPanel de registro al contenedor principal
			        frame.getContentPane().add(panelRegistro);

			        // Validar y repintar el contenedor principal
			        frame.validate();
			        frame.repaint();
			}
		});
		iniciosesion.setBounds(48, 395, 250, 90);
		iniciosesion.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		iniciosesion.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		iniciosesion.setBackground(SystemColor.menu);
		add(iniciosesion);
		
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
		
	
		
		
	}
}
