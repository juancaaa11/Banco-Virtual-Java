
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package Clases;

public class SessionManager {
	
    private static personas usuarioActivo;

    public static void iniciarSesion(personas usuario) {
        usuarioActivo = usuario;
    }

    public static personas getUsuarioActivo() {
        return usuarioActivo;
    }

    public static boolean sesionActiva() {
        return usuarioActivo != null;
    }

    public static void cerrarSesion() {
        usuarioActivo = null;
    }
}

