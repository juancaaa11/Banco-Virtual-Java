
/* 
 * 
 * @author juancaaa11
 * @version 1.0
 * 
 * 
 * */


package Clases;

/*
Clase para mantener la sesion del usuario activo. Esto lo utilizo para que al realizar cualquier consulta siempre tenga el usuario de la persona en esta clase guardada.
Puedo llamarla desde cualquier otra sin necesidad de declararla como nueva. Es decir cada vez que hago un getUsuarioActivo() en cualquier clase me tira el valor guardado, en este caso, el usuario.
*/
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

