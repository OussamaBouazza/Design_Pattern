package fr.ensim.dp.cache.filter;

import junit.framework.TestCase;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.assertArrayEquals;

public class EncryptFilterCacheTest extends TestCase {
    SecureRandom secureRandom = new SecureRandom();
    byte [] iv = new byte[12];
    byte [] dataTest = {1,2,3};



    public void testDoAdd() {
    }

    public void testDoRetreive() {
    }

    public void testSetNext() {
    }

    public void testEncryptData() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        secureRandom.nextBytes(iv);
        SecretKey secretKey = EncryptFilterCache.generateSecretKey("pass", iv);

        byte [] encryptedData = EncryptFilterCache.encryptData(dataTest, secretKey, iv);

        byte [] decryptedData = EncryptFilterCache.decryptData(encryptedData, secretKey, iv);

        assertArrayEquals(decryptedData, dataTest);


    }

    public void testDecryptData() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        secureRandom.nextBytes(iv);
        SecretKey secretKey = EncryptFilterCache.generateSecretKey("pass", iv);

        byte [] encryptedData = EncryptFilterCache.encryptData(dataTest, secretKey, iv);

        byte [] decryptedData = EncryptFilterCache.decryptData(encryptedData, secretKey, iv);

        assertArrayEquals(decryptedData, dataTest);
    }
}