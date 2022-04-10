package fr.ensim.dp.cache.filter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CountFilterCache implements IFilterCache {
    private int countAdd = 0;
    private int countRetrieve = 0;
    private IFilterCache next;


    @Override
    public byte[] doAdd(String key, byte[] buf) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        countAdd++;

        if(next != null){
            return next.doAdd(key, buf);
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        countRetrieve++;

        if(next != null){
            return next.doRetreive(key, buf);
        }
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }

    public int getCountAdd() {
        return countAdd;
    }

    public int getCountRetrieve() {
        return countRetrieve;
    }
}
