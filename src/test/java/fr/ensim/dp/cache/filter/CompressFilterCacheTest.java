package fr.ensim.dp.cache.filter;
import junit.framework.TestCase;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertArrayEquals;

public class CompressFilterCacheTest extends TestCase {
    CompressFilterCache compress = new CompressFilterCache();
    byte [] buffer = {1,2,3,4,5,6,7,8,9,10};

    public void testDoAdd() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte [] compressedBuffer = compress.doAdd("key", buffer);
        assertArrayEquals(buffer, compress.doRetreive("key", compressedBuffer));
    }

    public void testDoRetreive() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte [] compressedBuffer = compress.doAdd("key", buffer);
        assertArrayEquals(buffer, compress.doRetreive("key", compressedBuffer));
    }
}