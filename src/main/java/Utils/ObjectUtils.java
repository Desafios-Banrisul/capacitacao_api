package Utils;

import java.util.HashMap;
import java.util.Map;

public class ObjectUtils {
    public static Map<String, Object> buildModalBody(String key, Object object) {

        Map<String, Object> createBody = new HashMap<>();
        createBody.put(key, object);
        return createBody;
    }
}
