package objetos;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Encripta {
    public Encripta(){
        
    }
    private static final  String  ALGORITMO = "AES";
    private static final String MODO = "ECB";
    private static final String PADDING = "PKCS5Padding";
    private static final String CLAVE_SECRETA = "TANJIROKAMADORYT";

    public String encripta(String texto) {
        try {
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), ALGORITMO);
            Cipher cipher = Cipher.getInstance(ALGORITMO + "/" + MODO + "/" + PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            byte[] textoEncriptado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String desencriptar(String textoEncriptado) {
        try {
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), ALGORITMO);
            Cipher cipher = Cipher.getInstance(ALGORITMO + "/" + MODO + "/" + PADDING);
            cipher.init(Cipher.DECRYPT_MODE, clave);
            byte[] textoDesencriptado = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
            return new String(textoDesencriptado, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}