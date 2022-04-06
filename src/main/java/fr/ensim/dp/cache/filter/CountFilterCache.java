package fr.ensim.dp.cache.filter;

import java.io.IOException;

public class CountFilterCache implements IFilterCache {
    private int countAdd = 0;
    private int countRetrieve = 0;
    private IFilterCache next;


    @Override
    public byte[] doAdd(String key, byte[] buf) throws IOException {
        countAdd++;

        if(next != null){
            return next.doAdd(key, buf);
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) throws IOException {
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
