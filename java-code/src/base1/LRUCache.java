package base1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int cacheSize;

    public LRUCache(int cacheSize) {
        // 第三个参数 true 表示让 LinkedHashMap 按访问顺序进行排序，最近访问的在前，最旧访问的在后。
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    // 当 Map中的数据量大于指定的 缓存个数的时候，自动删除最老的数据
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }


}
