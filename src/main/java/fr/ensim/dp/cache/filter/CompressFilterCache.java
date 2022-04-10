package fr.ensim.dp.cache.filter;

import fr.ensim.dp.util.GzipUtil;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class CompressFilterCache implements IFilterCache{
    private IFilterCache next;


    @Override
    public byte[] doAdd(String key, byte[] buf) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte[] bufCompress = GzipUtil.compress(buf);

        if(next != null){
            return next.doAdd(key, bufCompress);
        }
        return bufCompress;
    }


    public byte[] doRetreive(String key, byte[] buf) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        if (next != null) {
           //récupère le buffer traité par l'étape suivante avant de le décompresser
           byte [] buffRetrieved = next.doRetreive(key, buf);
           return GzipUtil.uncompress(buffRetrieved);
        }

        return GzipUtil.uncompress(buf);
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }
}
