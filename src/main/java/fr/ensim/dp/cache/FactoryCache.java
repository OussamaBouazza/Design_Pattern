package fr.ensim.dp.cache;

public class FactoryCache {
    private static final FactoryCache instance = new FactoryCache();

    public FactoryCache getInstance(){
        return instance;
    }

    public static ICache memoryCache(){
        return MemoryCache.getInstance();
    }

    public  static ICache diskCache(String mapName){
        return DiskCache.getInstance(mapName);
    }
}
