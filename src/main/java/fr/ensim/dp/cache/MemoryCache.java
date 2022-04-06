package fr.ensim.dp.cache;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache implements ICache {
    private static MemoryCache instance;

    private Map<String, byte[]> map = new HashMap<>();

    private MemoryCache (){}

    public static MemoryCache getInstance(){
        if (instance==null){
            instance = new MemoryCache();
        }
        return instance;
    }


    @Override
    public long size() {
        return map.size();
    }

    @Override
    public boolean add(String key, byte[] buf) {
        map.put(key, buf);
        return true;
    }

    @Override
    public byte[] retreive(String key) {
        return map.get(key);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
