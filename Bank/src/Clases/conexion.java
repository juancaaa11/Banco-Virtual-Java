
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package Clases;

/*
 * Clase conexion para realizar el enlace con la base de datos.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	
   private Connection conn;
   
   public conexion() {
      
	   try {
           conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bank", "user" , "userbank");
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   
   public Connection getConnection() {
       return conn;
   }
   

   public void closeConnection() throws SQLException {
       if (conn != null) {
           conn.close();
       }
   
   }

}

