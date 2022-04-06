package fr.ensim.dp.cache;

import fr.ensim.dp.util.FileUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DiskCache implements ICache{
    private final String mapName;


    private static Map<String, DiskCache> map = new HashMap<>();

    private File dir;
    private DiskCache(String mapName){
        dir = new File("carte", mapName);
        dir.mkdir();            //crée le fichier
        this.mapName = mapName;
    }

    public static DiskCache getInstance(String nomMap){
        if (map.containsKey(nomMap)){   //check si le nom de la map n'a pas déjà été instancié
            return map.get(nomMap);     //retourne l'instance de l'objet qui se trouve déjà dans la hashmap
        }
        else {
            DiskCache instance = new DiskCache(nomMap);     //crée une nouvelle instance de la map
            map.put(nomMap, instance);      //ajoute l'instance dans la hashmap

            return instance;    //retourne l'instance qui vient d'être crée
        }
    }




    @Override
    public long size() {
        return FileUtil.dirLength(dir);
    }

    @Override
    public boolean add(String key, byte[] buf) {
        File file = new File(dir, key);
        FileUtil.copy(new ByteArrayInputStream(buf), file);
        return true;
    }

    @Override
    public byte[] retreive(String key) throws IOException {
        File file = new File(dir, key);
        return FileUtil.readFile(file);
    }

    @Override
    public void clear() {
        FileUtil.deleteDirectory(dir);
        dir.mkdir();
    }
}
