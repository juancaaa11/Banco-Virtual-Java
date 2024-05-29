package JPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import Consultas.consultas;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class recuperacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JTextField txtUsuario_2;
	private JTextField textField;
	private JTextField txtEnviar;

	/**
	 * Create the panel.
	 */
	public recuperacion() {
		setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBorder(null);
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setFont(new Font("FiraCode Nerd Font Mono", Font.PLAIN, 17));
		txtUsuario.setText("Usuario:");
		txtUsuario.setBounds(95, 206, 184, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton Enviar = new JButton("Enviar");
		Enviar.setBackground(SystemColor.control);
		Enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = txtUsuario_2.getText().trim();
                if (usuario.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de usuario.");
                    return;
                }

               
                consultas consultas = new consultas();
                boolean usuarioExiste = consultas.verificarUsuario(usuario);

                if (usuarioExiste) {
                    
                    String nuevaContrasena = JOptionPane.showInputDialog(null, "Ingrese la nueva contraseña:");
                    if (nuevaContrasena != null && !nuevaContrasena.trim().isEmpty()) {
                        boolean actualizacionExitosa = consultas.actualizarContrasena(usuario, nuevaContrasena);
                        if (actualizacionExitosa) {
                            JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe.");
                }
            }
        });
				
				
		
		Enviar.setBorder(null);
		Enviar.setForeground(Color.BLUE);
		Enviar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		Enviar.setBounds(272, 344, 89, 23);
		add(Enviar);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBorder(null);
		textField.setEditable(false);
		textField.setBounds(125, 429, 398, 38);
		add(textField);
		textField.setColumns(10);
		
		txtUsuario_2 = new JTextField();
		txtUsuario_2.setBorder(null);
		txtUsuario_2.setBackground(Color.WHITE);
		txtUsuario_2.setForeground(Color.GRAY);
		txtUsuario_2.setFont(new Font("SimSun", Font.PLAIN, 19));
		txtUsuario_2.setText("");
		txtUsuario_2.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario_2.setBounds(109, 257, 414, 38);
		add(txtUsuario_2);
		txtUsuario_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".//src//Imagenes//recuperacion.png"));
		lblNewLabel.setBounds(0, 0, 647, 529);
		add(lblNewLabel);
		
		
		
		
		
		
		
	

	}
}
