package fr.ensim.dp.cache.filter;

import junit.framework.TestCase;
import org.junit.Assert;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ChainOfResponsibility extends TestCase {
    CountFilterCache count = new CountFilterCache();
    CompressFilterCache compress = new CompressFilterCache();
    EncryptFilterCache encrypt = new EncryptFilterCache();

    byte [] buff = {1,2,3,4,5};

    public void testChainOfResponsibility() throws NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        count.setNext(encrypt);
        encrypt.setNext(compress);

        assertEquals(0, count.getCountAdd());
        assertEquals(0, count.getCountRetrieve());

        byte [] encryptedBuff = count.doAdd("key", buff);
        byte [] decryptedBuff = count.doRetreive("key", encryptedBuff);

        assertEquals(1, count.getCountAdd());
        assertEquals(1, count.getCountRetrieve());
        Assert.assertArrayEquals(buff, decryptedBuff);
    }

}
