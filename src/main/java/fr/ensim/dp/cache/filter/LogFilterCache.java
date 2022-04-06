package fr.ensim.dp.cache.filter;

public class LogFilterCache implements IFilterCache{
    private IFilterCache next;


    @Override
    public byte[] doAdd(String key, byte[] buf) {
        return new byte[0];
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        return new byte[0];
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }


}
