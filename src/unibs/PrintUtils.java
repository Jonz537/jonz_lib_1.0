package unibs;

import java.util.HashMap;
import java.util.Map;

public class PrintUtils {

    private PrintUtils() {}

    public static <K, V> void printHashMap(HashMap<K, V> hashMap) {
        for (Map.Entry<K, V> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
