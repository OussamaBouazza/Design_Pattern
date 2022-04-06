package fr.ensim.dp.cache.filter;

import fr.ensim.dp.util.GzipUtil;

import java.io.IOException;

public class CompressFilterCache implements IFilterCache{
    private IFilterCache next;


    @Override
    public byte[] doAdd(String key, byte[] buf) throws IOException {
        byte[] bufCompress = GzipUtil.compress(buf);
        if(next != null){
            return next.doAdd(key, bufCompress);
        }
        return bufCompress;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) throws IOException {
        if (next != null) {
           buf = next.doRetreive(key, buf);
        }
        byte[] bufCompress = GzipUtil.uncompress(buf);
        return bufCompress;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }
}
