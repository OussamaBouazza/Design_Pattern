package fr.ensim.dp.cache.filter;

import fr.ensim.dp.util.EncryptUtil;

import javax.crypto.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptFilterCache implements IFilterCache{
    private IFilterCache next;


    @Override
    public byte[] doAdd(String key, byte[] buf) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte [] encryptedBuf = EncryptUtil.encryptData(buf);
        if (next != null){
            return next.doAdd(key, encryptedBuf);
        }
        return encryptedBuf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IOException {
        if (next != null){
            //récupère le buffer traité par l'étape suivante avant de le décrypter
            byte [] buffRetrieved = next.doRetreive(key, buf);
            return EncryptUtil.decryptData(buffRetrieved);
        }

        return EncryptUtil.decryptData(buf);
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }



}
