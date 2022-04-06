package fr.ensim.dp.cache.filter;

import junit.framework.TestCase;

import java.io.IOException;

public class ChainOfResponsibility extends TestCase {
    CountFilterCache count = new CountFilterCache();
    CompressFilterCache compress = new CompressFilterCache();
    EncryptFilterCache encrypt = new EncryptFilterCache();

    byte [] buff = {1,2,3,4,5};

    public void testChainOfResponsibility() throws IOException {
        count.setNext(compress);
        compress.setNext(encrypt);

        byte [] encryptedBuff = count.doAdd("key", buff);
        assertEquals(1, count.getCountAdd());



    }

}
