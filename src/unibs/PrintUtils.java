package unibs;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class PrintUtils {

    public void printMenuHashMap(HashMap<Key, Value> hashMap) {
        for (Map.Entry<Key, Value> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
