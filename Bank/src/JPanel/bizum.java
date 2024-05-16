
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

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.JTextComponent;

import Clases.SessionManager;
import Clases.filter;
import Clases.personas;
import Consultas.consultas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class bizum extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBank;
	private JTextField txtauthorJuancaaaversion;
	private JLabel Logo;
	private JTextField txtTelefono;
	private JTextField txtDisponible;
	private JTextField txtCantidad;
	private JTextField dinero_1;
	private JTextField textField_1;
	private JTextField DineroReal;
	

	/**
	 * Create the panel.
	 */
	public bizum() {

		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(".//src//Imagenes//logopeque.png"));
		Logo.setBounds(627, 484, 63, 55);
		add(Logo);
		
		txtBank = new JTextField();
		txtBank.setForeground(SystemColor.desktop);
		txtBank.setBounds(10, 42, 680, 90);
		txtBank.setEditable(false);
		txtBank.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		txtBank.setBackground(new Color(94, 169, 253));
		txtBank.setFont(new Font("Segoe UI Black", Font.PLAIN, 81));
		txtBank.setText("BANK!");
		txtBank.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtBank);
		txtBank.setColumns(10);
		
		JLabel Bizum = new JLabel("");
		Bizum.setIcon(new ImageIcon(".//src//Imagenes//Bizum (1).png"));
		Bizum.setBounds(241, 143, 181, 77);
		add(Bizum);
	
		txtTelefono = new JTextField();
		txtTelefono.setForeground(SystemColor.desktop);
		txtTelefono.setEditable(false);
		txtTelefono.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(160, 160, 160)));
		txtTelefono.setBackground(SystemColor.textHighlight);
		txtTelefono.setText("TELEFONO");
		txtTelefono.setFont(new Font("Arial Black", Font.PLAIN, 31));
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setBounds(98, 231, 191, 65);
		add(txtTelefono);
		txtTelefono.setColumns(10);
		
		personas usuarioActivo = SessionManager.getUsuarioActivo();
		
		String informacionUsuario = usuarioActivo.getUsuario();
		
		consultas consulta = new consultas();
		
		double dinero = consultas.obtenerDineroDisponible(informacionUsuario);
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				
				consultas consultas = new consultas();
				
			
				String personaEnvio =  textField_1.getText();
				
				double Dinero = getDinero();
				
				 boolean bizum = consultas.bizum(informacionUsuario,personaEnvio,Dinero);
	                
	                if (bizum) {
	                	
	                	
	                	JOptionPane.showMessageDialog(null,"Bizum realizado correctamente");
	                	actualizarDineroDisponible();
	          
	                	
	                } else {
	                	
	                	
	                	
	                }
				
				
				
			}
		});
		btnNewButton.setBorder(UIManager.getBorder("ToggleButton.border"));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(587, 402, 89, 23);
		add(btnNewButton);
		
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
		
		txtDisponible = new JTextField();
		txtDisponible.setBorder(null);
		txtDisponible.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		txtDisponible.setBackground(SystemColor.textHighlight);
		txtDisponible.setText("DISPONIBLE");
		txtDisponible.setForeground(Color.RED);
		txtDisponible.setBounds(223, 433, 105, 20);
		add(txtDisponible);
		txtDisponible.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setText("CANTIDAD");
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setForeground(SystemColor.desktop);
		txtCantidad.setFont(new Font("Arial Black", Font.PLAIN, 31));
		txtCantidad.setEditable(false);
		txtCantidad.setColumns(10);
		txtCantidad.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(160, 160, 160)));
		txtCantidad.setBackground(SystemColor.textHighlight);
		txtCantidad.setBounds(424, 231, 191, 65);
		add(txtCantidad);
		
		dinero_1 = new JTextField();
        dinero_1.setHorizontalAlignment(SwingConstants.CENTER);
        dinero_1.setForeground(SystemColor.window);
        dinero_1.setFont(new Font("Dialog", Font.BOLD, 30));
        dinero_1.setDisabledTextColor(SystemColor.textHighlightText);
        dinero_1.setColumns(10);
        dinero_1.setCaretColor(SystemColor.desktop);
        dinero_1.setBorder(new MatteBorder(0, 0, 5, 0, new Color(0, 0, 0)));
        dinero_1.setBackground(SystemColor.textHighlight);
        dinero_1.setBounds(407, 318, 230, 43);
        add(dinero_1);
        
        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setDisabledTextColor(SystemColor.textHighlightText);
        textField_1.setFont(new Font("Dialog", Font.BOLD, 30));
        textField_1.setForeground(SystemColor.window);
        textField_1.setCaretColor(SystemColor.desktop);
        textField_1.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(0, 0, 0)));
        textField_1.setBackground(SystemColor.textHighlight);
        textField_1.setBounds(79, 318, 230, 43);
        add(textField_1);
        textField_1.setColumns(10);
        
        DineroReal = new JTextField();
        DineroReal.setHorizontalAlignment(SwingConstants.CENTER);
        DineroReal.setText(dinero + "$");
        DineroReal.setBorder(null);
        DineroReal.setForeground(SystemColor.desktop);
        DineroReal.setFont(new Font("Dialog", Font.BOLD, 17));
        DineroReal.setEditable(false);
        DineroReal.setBackground(SystemColor.textHighlight);
        DineroReal.setBounds(355, 433, 89, 20);
        add(DineroReal);
        DineroReal.setColumns(10);

      
        ((AbstractDocument) dinero_1.getDocument()).setDocumentFilter(new filter());
        
        JButton btnAtras = new JButton("ATRAS");
		btnAtras.setIcon(null);
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setBackground(SystemColor.window);
		btnAtras.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 23));
		btnAtras.setBounds(557, 143, 118, 28);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

			
				 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(bizum.this);

                 
                 frame.getContentPane().remove(bizum.this);

                
                 JPanel panelMenu = new menu();
                 frame.getContentPane().add(panelMenu);

                 
                 frame.validate();
                 frame.repaint();
			
                 
                 
                 
			}	
			
		});
       
        
	}
	
	
	private void actualizarDineroDisponible() {
	
		personas usuarioActivo = SessionManager.getUsuarioActivo();
		String informacionUsuario = usuarioActivo.getUsuario();
        double nuevoDinero = consultas.obtenerDineroDisponible(informacionUsuario);
        DineroReal.setText(nuevoDinero + " $");
    }
	
	public double getDinero() {
        String text = dinero_1.getText();
        if (text.isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
	
}
