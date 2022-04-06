package fr.ensim.dp.cache.filter;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class EncryptFilterCache implements IFilterCache{
    private IFilterCache next;



    @Override
    public byte[] doAdd(String key, byte[] buf) {

        if (next != null){

        }
        return new byte[0];
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        return new byte[0];
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }


    public static SecretKey generateSecretKey(String password, byte[] iv) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), iv, 65536, 128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] key = secretKeyFactory.generateSecret(spec).getEncoded();

        return new SecretKeySpec(key, "AES");
    }


    public static byte [] encryptData(byte [] data, SecretKey secretKey, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(128, iv));
        return cipher.doFinal(data);
    }

    public static byte [] decryptData(byte [] encryptedData, SecretKey secretKey, byte [] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(128, iv));
        return cipher.doFinal(encryptedData);
    }
}
