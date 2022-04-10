package fr.ensim.dp.cache.filter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Chain of responsbility
 * 
 */
public interface IFilterCache {

  /**
   * @param key
   * @param buf
   */
  byte[] doAdd(String key, byte[] buf) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException;

  /**
   * @param key
   * @return <code>true</code>, s'il ne faut pas appele de suivant.
   */
  byte[] doRetreive(String key, byte[] buf) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException;
  
  
  IFilterCache setNext(IFilterCache next);

}
