package base1;

/**
 * @author lei.gao
 */
public class Notepad<K, V> {

    private K key;     // 此变量的类型由外部决定
    private V value;   // 此变量的类型由外部决定

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public <V> V getVal(K k) {


        return (V) k;
    }

}
