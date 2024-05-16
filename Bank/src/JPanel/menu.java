
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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import Clases.SessionManager;

import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class menu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBank;
	private JTextField txtauthorJuancaaaversion;

	/**
	 * Create the panel.
	 */
	public menu() {
		
		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
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
		
		JButton agregarSaldo = new JButton("AGREGAR SALDO");
		agregarSaldo.setForeground(SystemColor.desktop);
		agregarSaldo.setBounds(68, 204, 250, 90);
		agregarSaldo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    	 JFrame frame = (JFrame) getTopLevelAncestor();

			     
			        frame.getContentPane().remove(menu.this);

			      
			        JPanel panelSaldo = new saldo();

			        
			        frame.getContentPane().add(panelSaldo);

			     
			        frame.validate();
			        frame.repaint();
		    	
		    }
		});
		agregarSaldo.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		agregarSaldo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		agregarSaldo.setBackground(SystemColor.menu);
		add(agregarSaldo);

		
		JButton Bizum = new JButton("BIZUM");
		Bizum.setForeground(SystemColor.desktop);
		Bizum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JFrame frame = (JFrame) getTopLevelAncestor();

			        
			        frame.getContentPane().remove(menu.this);

			     
			        JPanel panelRegistro = new bizum();

			     
			        frame.getContentPane().add(panelRegistro);

			      
			        frame.validate();
			        frame.repaint();
			}
		});
		Bizum.setBounds(364, 204, 250, 90);
		Bizum.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Bizum.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		Bizum.setBackground(SystemColor.menu);
		add(Bizum);
		
		JButton Detalles = new JButton("DETALLES CUENTA");
		Detalles.setForeground(SystemColor.desktop);
		Detalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JFrame frame = (JFrame) getTopLevelAncestor();

		
			        frame.getContentPane().remove(menu.this);

			    
			        JPanel panelRegistro = new detalles();

			   
			        frame.getContentPane().add(panelRegistro);

			      
			        frame.validate();
			        frame.repaint();
			}
		});
		
		
		Detalles.setBounds(220, 338, 250, 90);
		Detalles.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		Detalles.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		Detalles.setBackground(SystemColor.menu);
		add(Detalles);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(334, 171, 454, 398);
		lblNewLabel.setIcon(new ImageIcon(".//src//Imagenes//logo.png"));
		add(lblNewLabel);
		
		JButton btnAtras = new JButton("CERRAR SESION");
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setBackground(Color.RED);
		btnAtras.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 11));
		btnAtras.setBounds(533, 143, 138, 20);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				SessionManager.cerrarSesion();

			
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(menu.this);

                 
                frame.getContentPane().remove(menu.this);

                
                JPanel panelBienvenido = new bienvenido();
                frame.getContentPane().add(panelBienvenido);

                 
                frame.validate();
                frame.repaint();
			
                       
                 
			}	
			
			
		});
		
			
		
		
		
	}
}