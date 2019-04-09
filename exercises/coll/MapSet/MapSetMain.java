package coll.MapSet;

public class MapSetMain {
    public static void main(String[] args) {
        MapSet<String, Integer> map = new MapSet<>();
        map.addValue("A", 1);
        map.addValue("A", 2);
        map.addValue("A", 3);
        map.addValue("A", 4);

        map.addValue("B", 5);

        map.addValue("C", 6);
        map.addValue("C", 7);
        map.addValue("C", 8);

        map.addValue("D", 9);


        System.out.println(map.entrySet() + "\n");

        for (Integer value : map) {
            System.out.println(value);
        }
    }
}
