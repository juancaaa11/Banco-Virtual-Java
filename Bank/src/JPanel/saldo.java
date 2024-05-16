
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
import Clases.filter;
import Clases.personas;
import Consultas.consultas;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.AbstractDocument;

public class saldo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBank;
	private JTextField txtauthorJuancaaaversion;
	private JLabel Logo;
	private JTextField textField;
	private JTextField txtSaldoDisponible;
	private JTextField txtIngresarDinero;
	private JTextField Ingreso;

	/**
	 * Create the panel.
	 */
	public saldo() {

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
		
	
		
		personas usuarioActivo = SessionManager.getUsuarioActivo();
		
		String informacionUsuario = usuarioActivo.getUsuario();
		
		consultas consulta = new consultas();
		
		double dinero = consultas.obtenerDineroDisponible(informacionUsuario);
		
		
		
		textField = new JTextField();
		textField.setForeground(SystemColor.textHighlightText);
		textField.setBorder(null);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Dialog", Font.BOLD, 62));
		textField.setBackground(SystemColor.textHighlight);
		textField.setText( dinero + " $");
		textField.setEditable(false);
		textField.setBounds(252, 168, 286, 121);
		add(textField);
		textField.setColumns(10);
		
		txtSaldoDisponible = new JTextField();
		txtSaldoDisponible.setEditable(false);
		txtSaldoDisponible.setBackground(SystemColor.textHighlight);
		txtSaldoDisponible.setForeground(SystemColor.desktop);
		txtSaldoDisponible.setBorder(null);
		txtSaldoDisponible.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		txtSaldoDisponible.setText("SALDO:");
		txtSaldoDisponible.setHorizontalAlignment(SwingConstants.CENTER);
		txtSaldoDisponible.setBounds(10, 217, 213, 38);
		add(txtSaldoDisponible);
		txtSaldoDisponible.setColumns(10);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setIcon(null);
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setBackground(SystemColor.textHighlight);
		btnAtras.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 23));
		btnAtras.setBounds(572, 143, 103, 28);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

			
				 JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(saldo.this);

                 
                 frame.getContentPane().remove(saldo.this);

                
                 JPanel panelMenu = new menu();
                 frame.getContentPane().add(panelMenu);

                 
                 frame.validate();
                 frame.repaint();
			
                 
                 
                 
			}		
			
			
		});
		
		
		txtIngresarDinero = new JTextField();
		txtIngresarDinero.setEditable(false);
		txtIngresarDinero.setBackground(SystemColor.textHighlight);
		txtIngresarDinero.setForeground(SystemColor.desktop);
		txtIngresarDinero.setBorder(null);
		txtIngresarDinero.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		txtIngresarDinero.setText("INGRESAR DINERO: ");
		txtIngresarDinero.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngresarDinero.setBounds(30, 341, 424, 38);
		add(txtIngresarDinero);
		txtIngresarDinero.setColumns(10);
		
		
		btnAtras.setForeground(SystemColor.desktop);
		btnAtras.setBackground(SystemColor.window);
		btnAtras.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 23));
		btnAtras.setBounds(548, 143, 127, 28);
		add(btnAtras);
		
		Ingreso = new JTextField();
		Ingreso.setCaretColor(SystemColor.desktop);
		Ingreso.setDisabledTextColor(SystemColor.textHighlightText);
		Ingreso.setFont(new Font("Dialog", Font.BOLD, 60));
		Ingreso.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(0, 0, 0)));
		Ingreso.setBackground(SystemColor.textHighlight);
		Ingreso.setForeground(Color.BLACK);
		Ingreso.setBounds(325, 390, 221, 90);
		add(Ingreso);
		Ingreso.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double monto = getDinero();
				
				consultas consulta = new consultas();
				boolean ingresar = consulta.ingresarDinero(informacionUsuario, monto);
				actualizarDineroDisponible();
				
				
				
			}
		});
		btnNewButton.setBorder(UIManager.getBorder("ToggleButton.border"));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(582, 397, 89, 23);
		add(btnNewButton);
		
		
		((AbstractDocument) Ingreso.getDocument()).setDocumentFilter(new filter());
	}
	
	
	
	public double getDinero() {
        String text = Ingreso.getText();
        if (text.isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
	
	
	
	private void actualizarDineroDisponible() {
		
		personas usuarioActivo = SessionManager.getUsuarioActivo();
		String informacionUsuario = usuarioActivo.getUsuario();
        double nuevoDinero = consultas.obtenerDineroDisponible(informacionUsuario);
        textField.setText(nuevoDinero + "$");
    }
}
