
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package Clases;
import java.awt.Image;

import javax.swing.ImageIcon;
/*
*Inicializa el Frame de Bienvenido.
*/
import javax.swing.JFrame;

import JPanel.bienvenido;

public class main {

	public static void main(String[] args) {
		
		 JFrame bank = new JFrame("Bank!");

	        // Configurar el JFrame
	        bank.setIconImage(new ImageIcon(".//src/Imagenes/logo.png").getImage()); // Ruta relativa corregida
	        bank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        bank.setSize(718, 590);
	        bank.setLocationRelativeTo(null); // Centrar el JFrame en la pantalla

	        // Asegúrate de que la clase bienvenido está correctamente definida
	        bienvenido panelBienvenido = new bienvenido();

	        bank.getContentPane().add(panelBienvenido);

	        bank.setVisible(true);
        
        
        
	}

}
