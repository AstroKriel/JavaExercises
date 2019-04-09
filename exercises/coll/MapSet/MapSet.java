package coll.MapSet;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V> {
    public void addValue(K k, V v) {
        this.get(k).add(v);
    }

    @Override
    public Set<Entry<K, HashSet<V>>> entrySet(){
        for
    }

    public Iterator iterator() {
        return null;
    }
}