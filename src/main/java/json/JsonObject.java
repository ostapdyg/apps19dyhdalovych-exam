package json;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    HashMap<String, Json> pairs;

    public JsonObject(JsonPair... jsonPairs) {
        pairs = new HashMap<>();
        for(JsonPair pair:jsonPairs){
            add(pair);
        }
    }

    @Override
    public String toJson() {
        String res = "{";
        for(String key:pairs.keySet()){
            res = res + key + ":" + pairs.get(key).toJson() + ", ";
        }
        if(res.endsWith(", ")){res = res.substring(0, res.length()-2);}
    return res+"}";
    }

    public void add(JsonPair jsonPair) {
        pairs.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return pairs.get(name);
    }

    public boolean contains(String name){
        return pairs.containsKey(name);
    }

    public JsonObject projection(String... names) {
        JsonObject res = new JsonObject();
        for(String key:names){
            if(contains(key)){
                res.add(new JsonPair(key, find(key)));
            }
        }
        return res;
    }
}
