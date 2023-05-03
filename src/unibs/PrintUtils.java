package unibs;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class PrintUtils {

    private PrintUtils() {}

    public static <K, V> void printMenuHashMap(HashMap<K, V> hashMap) {
        for (Map.Entry<K, V> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
