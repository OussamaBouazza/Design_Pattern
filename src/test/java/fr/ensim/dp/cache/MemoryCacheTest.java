package fr.ensim.dp.cache;

import static org.junit.Assert.*;


import org.junit.Test;

public class MemoryCacheTest {
	MemoryCache instance = MemoryCache.getInstance();
	String key1 = "k1", key2 = "key2";
	byte [] value1 = {12, 6, 13}, value2 = {1,4,6};

	//teste la fonction qui retourne le nombre d'élément dans MemoryCache
	@Test
	public void testSize() {
		assertEquals(0, instance.size());

		instance.add(key1, value1);
		assertEquals(1, instance.size());

		instance.add(key2, value2);
		assertEquals(2, instance.size());
	}

	//tester l'ajout d'un buffer dans MemoryCache
	@Test
	public  void testAdd(){
		instance.add(key1, value1);
		assertEquals( value1, instance.retreive(key1));

		instance.add(key2, value2);
		assertEquals(value2, instance.retreive(key2));
	}

	//test pour récupérer un buffer de MemoryCache en utilisant une clé
	@Test
	public void testRetreive() {
		instance.add(key1, value1);
		byte [] val = instance.retreive(key1);

		assertEquals(value1, val);
		assertNull(instance.retreive("unknownKey"));	//test d'une valeur qui n'est pas dans MemoryCache
	}

	//test pour vider la liste de MemoryCache
	@Test
	public void testClear() {
		instance.add(key1, value1);
		instance.add(key2, value2);
		
		instance.clear();

		assertEquals(0, instance.size());
	}

}
