//------------>Problem 1.3
package lab4;

import java.util.LinkedList;
import java.util.List;

public class MapImpl<K, V> implements Map<K, V> {
    private List<K> keys;
    private List<V> values;

    public MapImpl() {
        keys = new LinkedList<>();
        values = new LinkedList<>();
    }

    @Override
    public void add(K key, V value) {
        if (keys.contains(key)) {
            // Update the value if the key already exists
            int index = keys.indexOf(key);
            values.set(index, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    @Override
    public V remove(K key) {
        if (!keys.contains(key)) {
            return null; // Key not found
        }
        int index = keys.indexOf(key);
        keys.remove(index);
        return values.remove(index);
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public List<K> keys() {
        return new LinkedList<>(keys); // Return a copy to prevent external modification
    }

    @Override
    public void print() {
        for (int i = 0; i < keys.size(); i++) {
            System.out.println("Key: " + keys.get(i) + ", Value: " + values.get(i));
        }
    }

    public static void main(String[] args) {
        MapImpl<String, Integer> myMap = new MapImpl<>();

        myMap.add("One", 1);
        myMap.add("Two", 2);
        myMap.add("Three", 3);
        myMap.add("Two", 22); // Updating value for existing key

        System.out.println("Size of the map: " + myMap.size());
        System.out.println("Is map empty? " + myMap.isEmpty());
        System.out.println("List of keys: " + myMap.keys());
        myMap.print();

        System.out.println("Removing key 'Two', Value removed: " + myMap.remove("Two"));

        System.out.println("Size of the map: " + myMap.size());
        System.out.println("Is map empty? " + myMap.isEmpty());
        System.out.println("List of keys: " + myMap.keys());
        myMap.print();
    }
}
