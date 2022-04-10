package fr.ensim.dp.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
    private static final String TYPE = "AES";
    private static final byte [] keyValue = "Ad0#2s!3oGyRq!5F".getBytes();
    private static Key key;

    public static Key generateKey(){
        //utiliser un singleton pour ne générer qu'une seule clé de cryptage
        if (key == null){
            key =new SecretKeySpec(keyValue, TYPE);
        }
        return key;
    }

    //fonction pour crypter un buffer avec une clé privée
    public static byte [] encryptData(byte [] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key privateKey = generateKey();
        Cipher cipher =Cipher.getInstance(TYPE);

        //initialiser le chiffrement avec le mode "encrypt" et la clé privée
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    //fonction pour decrypter un buffer
    public static byte [] decryptData(byte [] decryptData) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key privateKey = generateKey();
        Cipher cipher =Cipher.getInstance(TYPE);

        //initialiser le chiffrement avec le mode "decrypt" et la clé privée
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(decryptData);
    }

}
