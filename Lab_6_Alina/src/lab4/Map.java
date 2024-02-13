package lab4;

import java.util.List;

public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
    List<K> keys();
    void print();
}

