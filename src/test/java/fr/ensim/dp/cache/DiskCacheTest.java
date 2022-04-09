package fr.ensim.dp.cache;

import junit.framework.TestCase;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class DiskCacheTest extends TestCase {
    DiskCache dCache = DiskCache.getInstance("cyclemap");
    byte [] values = {1,2,3};

    public void testSize() {
        dCache.add("key1", values);
        assertEquals(3,dCache.size());
    }

    public void testAdd() throws IOException {
        assertTrue(dCache.add("key1", values));
        assertArrayEquals(values, dCache.retreive("key1"));
    }

    public void testRetreive() throws IOException {
        dCache.add("key1", values);
        byte[] retrievedValues = dCache.retreive("key1");

        assertArrayEquals(values, retrievedValues);

    }

    public void testClear() {
        dCache.add("fileKey", values);
        dCache.clear();
        assertEquals(0, dCache.size());
    }
}