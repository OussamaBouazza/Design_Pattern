package fr.ensim.dp.cache;

import junit.framework.TestCase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertArrayEquals;

public class DiskCacheTest extends TestCase {
    DiskCache dCache = DiskCache.getInstance("cyclemap");
    byte [] values = {1,2,3};

    public void testSize() {
        System.out.println(dCache.size());
    }

    public void testAdd() {
        assertTrue(dCache.add("key1", values));
    }

    public void testRetreive() throws IOException {
        byte[] retrievedValues = dCache.retreive("key1");

        assertArrayEquals(values, retrievedValues);

    }

    public void testClear() {
    }
}