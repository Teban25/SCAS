package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.util.encrypt;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Teban-Ing
 */
public class Encrypt {

    MessageDigest md;
    String textEncrypt;

    public Encrypt(String password) {
        this.textEncrypt = password;
    }

    public String getPasswordEncrypted() throws BussinessException {
        StringBuffer sb = new StringBuffer();
        if(textEncrypt==null || textEncrypt.equals(""))
            throw new BussinessException("Por favor revisar el texto a encriptar");
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(textEncrypt.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            for (int i = 0; i < digest.length; i++) {
                String hex = Integer.toHexString(0xff & digest[i]);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
        return sb.toString();
    }
}
