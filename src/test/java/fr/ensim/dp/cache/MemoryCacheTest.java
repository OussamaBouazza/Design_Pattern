package fr.ensim.dp.cache;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemoryCacheTest {

	MemoryCache instance = MemoryCache.getInstance();
	String key = "t1";
	byte [] value = {12, 6, 13};

	@Test
	public void testSize() {

	}

	@Test
	public  void testAdd(){
		String k2 = "k2";
		byte[] v2 = {1,4,6};

		instance.add(key, value);
		assertEquals( value, instance.retreive(key));

		instance.add(k2, v2);
		assertEquals(v2, instance.retreive(k2));
	}

	@Test
	public void testAll() {
		// cle
		// Size vaut0
		// byte [] b = {12,2 ,3} ,
		// add("key1", b)
		// Size vaut 3
		//retreive 
		
	}
	@Test
	public void testRetreive() {
		instance.add(key, value);
		byte [] val = instance.retreive(key);
		assertEquals(value, val);
	}

	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

}
