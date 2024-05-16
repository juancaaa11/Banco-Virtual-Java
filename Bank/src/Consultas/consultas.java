
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package Consultas;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Clases.conexion;
import Clases.personas;


public class consultas {
	
	
	public static String obtenerDNI(String nombreUsuario) {
	    
		Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String dni = "";

	    try {
	    	
	        connection = new conexion().getConnection();

	       
	        String queryGetDNI = "SELECT dni FROM personas " +
	                             "JOIN usuarios ON personas.usuario_id = usuarios.id " +
	                             "WHERE usuarios.usuario = ?";
	        ps = connection.prepareStatement(queryGetDNI);
	        ps.setString(1, nombreUsuario);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            dni = rs.getString("dni");
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return dni;
	}

	
	public static boolean actualizarNumeroTelefono(String nombreUsuario, String nuevoTelefono) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    boolean actualizado = false;

	    try {
	    	
	        connection = new conexion().getConnection();

	       
	        String queryActualizarTelefono = "UPDATE personas " +
	                                         "JOIN usuarios ON personas.usuario_id = usuarios.id " +
	                                         "SET personas.numero_telefono = ? " +
	                                         "WHERE usuarios.usuario = ?";
	        
	        ps = connection.prepareStatement(queryActualizarTelefono);
	        ps.setString(1, nuevoTelefono);
	        ps.setString(2, nombreUsuario);

	      
	        int filasActualizadas = ps.executeUpdate();

	        if (filasActualizadas > 0) {
	            actualizado = true;
	            JOptionPane.showMessageDialog(null,"Número de teléfono actualizado correctamente.");
	        } else {
	        	JOptionPane.showMessageDialog(null,"No se encontró el usuario o no se pudo actualizar el número de teléfono.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return actualizado;
	}

	
	public static String obtenerNumeroCuenta(String nombreUsuario) {
		
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String numeroCuentaFormateado = "";

	    try {
	        connection = new conexion().getConnection();

	       
	        String queryObtenerCuenta = "SELECT numero_cuenta FROM cuenta " +
	                                     "JOIN usuarios ON cuenta.usuario_id = usuarios.id " +
	                                     "WHERE usuarios.usuario = ?";
	        ps = connection.prepareStatement(queryObtenerCuenta);
	        ps.setString(1, nombreUsuario);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            long numeroCuenta = rs.getLong("numero_cuenta");
	          
	            numeroCuentaFormateado = formatNumberWithDashes(numeroCuenta);
	        } else {
	            System.out.println("No se encontró el usuario o no tiene número de cuenta asociado.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return numeroCuentaFormateado;
	}

	
	private static String formatNumberWithDashes(long number) {
		
	    String numberStr = Long.toString(number);
	    StringBuilder formattedNumber = new StringBuilder();

	    int length = numberStr.length();
	    for (int i = 0; i < length; i++) {
	        formattedNumber.append(numberStr.charAt(i));
	        if ((i + 1) % 3 == 0 && i != length - 1) {
	            formattedNumber.append(" - ");
	        }
	    }

	    return formattedNumber.toString();
	}
	
	
	
	
	public static boolean actualizarNombreUsuario(String nombreUsuario, String nuevoNombreUsuario) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    boolean actualizado = false;

	    try {
	        connection = new conexion().getConnection();

	      
	        String queryActualizarNombre = "UPDATE usuarios SET usuario = ? WHERE usuario = ?";
	        ps = connection.prepareStatement(queryActualizarNombre);
	        ps.setString(1, nuevoNombreUsuario);
	        ps.setString(2, nombreUsuario);

	        
	        int filasActualizadas = ps.executeUpdate();

	        if (filasActualizadas > 0) {
	            actualizado = true;
	            JOptionPane.showMessageDialog(null, "Nombre de usuario actualizado correctamente.");
	        } else {
	        	 JOptionPane.showMessageDialog(null, "No se encontró el usuario o no se pudo actualizar el nombre.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return actualizado;
	}

	
	
	public static String obtenerTelefono(String nombreUsuario) {
	   
		
		Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String telefono = "";

	    try {
	    	
	        connection = new conexion().getConnection();

	 
	        String queryGetTelefono = "SELECT numero_telefono FROM personas " +
	                                  "JOIN usuarios ON personas.usuario_id = usuarios.id " +
	                                  "WHERE usuarios.usuario = ?";
	        ps = connection.prepareStatement(queryGetTelefono);
	        ps.setString(1, nombreUsuario);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            telefono = rs.getString("numero_telefono");
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return telefono;
	}
	
	
	public static String obtenerNombre(String nombreUsuario) {
		
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String nombre = "";

	    try {
	    	
	        connection = new conexion().getConnection();

	       
	        String queryGetNombre = "SELECT nombre FROM personas " +
	                                "JOIN usuarios ON personas.usuario_id = usuarios.id " +
	                                "WHERE usuarios.usuario = ?";
	        
	        ps = connection.prepareStatement(queryGetNombre);
	        ps.setString(1, nombreUsuario);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            nombre = rs.getString("nombre");
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return nombre;
	}
	
	
	public static String obtenerApellidoCompleto(String nombreUsuario) {
		
		
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String apellidoCompleto="";

	    try {
	    	
	        connection = new conexion().getConnection();

	        
	        String queryGetApellidos = "SELECT apellido1, apellido2 FROM personas " +
	                                    "JOIN usuarios ON personas.usuario_id = usuarios.id " +
	                                    "WHERE usuarios.usuario = ?";
	        
	        ps = connection.prepareStatement(queryGetApellidos);
	        ps.setString(1, nombreUsuario);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            String apellido1 = rs.getString("apellido1");
	            String apellido2 = rs.getString("apellido2");
	           
	            apellidoCompleto = apellido1 + " " + apellido2;
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return apellidoCompleto;
	}
	
	
	
	public static boolean registrarUsuario(String usuario, String contrasena, String apellido1, String apellido2, String telefono, String dni, String nombre, String num_cuenta, double dinero_disp) {
        
		Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        
        boolean exito=false;
        
        try {
        	
            
        	conexion = new conexion().getConnection();

        
            String usuariosQuery = "INSERT INTO usuarios (usuario, contrasena) VALUES (?, ?)";
            statement = conexion.prepareStatement(usuariosQuery, PreparedStatement.RETURN_GENERATED_KEYS);

           
            statement.setString(1, usuario);
            statement.setString(2, contrasena);

          
            int filasInsertadasUsuarios = statement.executeUpdate();

           
            int userId = -1;
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1); 
            } else {
                throw new SQLException("No se pudo obtener el ID del usuario insertado");
            }

         
            String personaQuery = "INSERT INTO personas (dni, nombre, apellido1, apellido2, numero_telefono, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
            statement = conexion.prepareStatement(personaQuery);
            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.setString(3, apellido1);
            statement.setString(4, apellido2);
            statement.setString(5, telefono);
            statement.setInt(6, userId);

            int filasInsertadasPersonas = statement.executeUpdate();

           
            String cuentaQuery = "INSERT INTO cuenta (numero_cuenta, dinero_disponible, usuario_id) VALUES (?, ?, ?)";
            statement = conexion.prepareStatement(cuentaQuery);
            statement.setString(1, num_cuenta);
            statement.setDouble(2, dinero_disp);
            statement.setInt(3, userId);

            int filasInsertadasCuentas = statement.executeUpdate();
    
        
        
            if (filasInsertadasCuentas > 0 && filasInsertadasPersonas > 0 && filasInsertadasUsuarios > 0)  {
            	JOptionPane.showMessageDialog(null, "Registro existoso!");
            	exito= true;
                
            } else {
            	JOptionPane.showMessageDialog(null, "Registro fallido!");
            	exito=false;
            }	
               
            }
            
                catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "El registro no se completo: " + e.getMessage());
           
        } finally {
          
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                	JOptionPane.showMessageDialog(null, "Error al cerrar Stament");
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                	JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
                }
            }
        }
        return exito;
        }
        
	
      
	public static boolean verificarCredenciales(String usuario, String contrasena) {
		
		conexion conexion = new conexion();
		
		
		String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario = ? AND contrasena = ?";
        boolean loggedIn = false;

        try (Connection conn = conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, usuario);
            pstmt.setString(2, contrasena);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                loggedIn = true; 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loggedIn;
    }
		
		
		
	
    public static double obtenerDineroDisponible(String nombreUsuario) {
        
    	
    	double dineroDisponible = 0.0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            
        	connection = new conexion().getConnection(); 

         
            String sql = "SELECT dinero_disponible FROM cuenta " +
                         "JOIN usuarios ON cuenta.usuario_id = usuarios.id " +
                         "WHERE usuarios.usuario = ?";

         
            statement = connection.prepareStatement(sql);
            statement.setString(1, nombreUsuario);

          
            resultSet = statement.executeQuery();

          
            if (resultSet.next()) {
                dineroDisponible = resultSet.getDouble("dinero_disponible");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
               
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return dineroDisponible;
    }
    
    
    
    public static boolean bizum(String nombreUsuario, String telefonoDestino, double monto) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        
        try {
        	
        	
            connection = new conexion().getConnection();

          
            String queryGetUserId = "SELECT id FROM usuarios WHERE usuario = ?";
            ps = connection.prepareStatement(queryGetUserId);
            ps.setString(1, nombreUsuario);
            rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario origen no existe.");
                return false;
            }

            int usuarioIdOrigen = rs.getInt("id");
            rs.close();
            ps.close();

         
            String queryGetDestUserId = "SELECT usuario_id FROM personas WHERE numero_telefono = ?";
            ps = connection.prepareStatement(queryGetDestUserId);
            ps.setString(1, telefonoDestino);
            rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "El número de teléfono destino no existe.");
                return false;
            }

            int usuarioIdDestino = rs.getInt("usuario_id");
            rs.close();
            ps.close();

            
            String querySaldoOrigen = "SELECT dinero_disponible FROM cuenta WHERE usuario_id = ?";
            ps = connection.prepareStatement(querySaldoOrigen);
            ps.setInt(1, usuarioIdOrigen);
            rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "El usuario origen no tiene cuenta asociada.");
                return false;
            }

            double saldoOrigen = rs.getDouble("dinero_disponible");
            rs.close();
            ps.close();

            if (saldoOrigen < monto) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                return false;
            }

         
            connection.setAutoCommit(false);

          
            String updateSaldoOrigen = "UPDATE cuenta SET dinero_disponible = dinero_disponible - ? WHERE usuario_id = ?";
            ps = connection.prepareStatement(updateSaldoOrigen);
            ps.setDouble(1, monto);
            ps.setInt(2, usuarioIdOrigen);
            ps.executeUpdate();
            ps.close();

           
            String updateSaldoDestino = "UPDATE cuenta SET dinero_disponible = dinero_disponible + ? WHERE usuario_id = ?";
            ps = connection.prepareStatement(updateSaldoDestino);
            ps.setDouble(1, monto);
            ps.setInt(2, usuarioIdDestino);
            ps.executeUpdate();
            ps.close();

            
            connection.commit();
            return true;

        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            return false;
    
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
	
    public static boolean ingresarDinero(String nombreUsuario, double monto) {
        
    	
    	Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	
            connection = new conexion().getConnection();

          
            String queryGetUserId = "SELECT id FROM usuarios WHERE usuario = ?";
            ps = connection.prepareStatement(queryGetUserId);
            ps.setString(1, nombreUsuario);
            rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario no existe.");
                return false;
            }

            int usuarioId = rs.getInt("id");
            rs.close();
            ps.close();

         
            String querySaldoUsuario = "SELECT dinero_disponible FROM cuenta WHERE usuario_id = ?";
            ps = connection.prepareStatement(querySaldoUsuario);
            ps.setInt(1, usuarioId);
            rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "El usuario no tiene cuenta asociada.");
                return false;
            }

            double saldoActual = rs.getDouble("dinero_disponible");
            rs.close();
            ps.close();

           
            double nuevoSaldo = saldoActual + monto;

         
            String updateSaldoUsuario = "UPDATE cuenta SET dinero_disponible = ? WHERE usuario_id = ?";
            ps = connection.prepareStatement(updateSaldoUsuario);
            ps.setDouble(1, nuevoSaldo);
            ps.setInt(2, usuarioId);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Bizum realizado correctamente!");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
}





