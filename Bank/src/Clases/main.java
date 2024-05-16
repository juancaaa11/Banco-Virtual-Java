
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package Clases;

import javax.swing.JFrame;

import JPanel.bienvenido;

public class main {

	public static void main(String[] args) {
		
		JFrame bank = new JFrame("Bank!"); 

        // Configurar el JFrame
        bank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        bank.setSize(718, 590); 
        bank.setLocationRelativeTo(null); // Centrar el JFrame en la pantalla

        
        bienvenido panelBienvenido = new bienvenido();

       
        bank.getContentPane().add(panelBienvenido);

        
        bank.setVisible(true);
		
		
	}

}
