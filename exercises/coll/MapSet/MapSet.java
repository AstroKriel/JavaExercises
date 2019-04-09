package coll.MapSet;

import java.util.*;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V> {
    Map<K, HashSet<V>> hashMap = new HashMap<K, HashSet<V>>();

    public void addValue(K key, V value) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new HashSet<V>());
        }
        hashMap.get(key).add(value);
    }


    @Override
    public Set<Entry<K, HashSet<V>>> entrySet(){
        return hashMap.entrySet();
    }


    public Iterator iterator() {
        // Initialise the iterator
        ArrayList<V> elememts = new ArrayList<>();

        // Testing
        List<HashSet<V>> sizesList = new ArrayList<>(hashMap.values());
        Collections.sort(sizesList, (a, b) -> b.size() - a.size());
        /* Above is equivalent to:
        ArrayList<Integer> sizesArray = new ArrayList<Integer>();
        List<HashSet<V>> list = new ArrayList<>(hashMap.values());
        for (HashSet<V> values : list) {
            sizesArray.add(values.size());
        }
        Collections.sort(sizesArray, Collections.reverseOrder());
        for (int element : sizesArray) {
            System.out.println(element);
        }
        */
        for (HashSet<V> sz : sizesList) {
            for (V val : sz) {
                elememts.add(val);
            }
        }
        return elememts.iterator();
    }
}