package fr.ensim.dp.cache.filter;

import fr.ensim.dp.util.EncryptUtil;
import junit.framework.TestCase;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertArrayEquals;

public class EncryptFilterCacheTest extends TestCase {
    byte [] dataTest = {1,2,3};


    public void testEncryptData() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte [] encryptedData = EncryptUtil.encryptData(dataTest);
        byte [] decryptedData = EncryptUtil.decryptData(encryptedData);

        assertArrayEquals(dataTest, decryptedData);
    }

    public void testDecryptData() throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        byte [] encryptedData = EncryptUtil.encryptData(dataTest);
        assertArrayEquals(dataTest, EncryptUtil.decryptData(encryptedData));

    }
}