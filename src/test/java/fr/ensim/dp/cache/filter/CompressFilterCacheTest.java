package fr.ensim.dp.cache.filter;
import junit.framework.TestCase;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class CompressFilterCacheTest extends TestCase {
    CompressFilterCache compress = new CompressFilterCache();
    byte [] buffer = {1,2,3,4,5,6,7,8,9,10};

    public void testDoAdd() throws IOException {
        byte [] compressedBuffer = compress.doAdd("key", buffer);
        assertArrayEquals(buffer, compress.doRetreive("key", compressedBuffer));
    }

    public void testDoRetreive() throws IOException {
        byte [] compressedBuffer = compress.doAdd("key", buffer);
        assertArrayEquals(buffer, compress.doRetreive("key", compressedBuffer));
    }

    public void testSetNext() {
    }
}