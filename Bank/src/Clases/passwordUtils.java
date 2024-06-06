package Clases;

import org.mindrot.jbcrypt.BCrypt;

public class passwordUtils {

   
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    
    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}

