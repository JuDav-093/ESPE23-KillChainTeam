
package ec.edu.espe.evsustore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HashMapManger {
    
    public static String toSring(HashMap<Object, Object> map){
        ArrayList<Object> values = getValues(map);
        String toString = "";
        for(Object value: values){
            toString = toString + " || " + value.toString();
        }
        return toString;
    }
    
    public static ArrayList<Object> getKeys(HashMap<Object, Object> map){
        ArrayList<Object> keys = new ArrayList<>();
        
        for(Map.Entry<Object,Object> keyValues: map.entrySet()){
            keys.add( keyValues.getKey());
        }
        
        return keys;
    }
    
    public static ArrayList<Object> getValues(HashMap<Object, Object> map){
        ArrayList<Object> values = new ArrayList<>();
        
        for(Map.Entry<Object,Object> keyValues: map.entrySet()){
            values.add( keyValues.getValue());
        }
        
        return values;
    }
    
    public static void reorderkeyValues(ArrayList<Object> keys, ArrayList<Object> values){
        int idIndex = keys.indexOf("id");
        
        reorderkeys(keys);
        reorderValues(values, idIndex);
    }
    
    public static void reorderkeys(ArrayList<Object> keys){
        int idIndex = keys.indexOf("id");
        Object idKey = keys.get(idIndex);
        Object firstKey = keys.get(0);
        keys.remove(0);
        keys.add(0, idKey);
        keys.remove(idIndex);
        keys.add(idIndex, firstKey);
        
    }
    
    public static void reorderValues(ArrayList<Object> values, int idIndex){
        
        Object idValue = values.get(idIndex);
        Object firstValue = values.get(0);
        values.remove(0);
        values.add(0, idValue);
        values.remove(idIndex);
        values.add(idIndex, firstValue);
        
    }
    
    public static int getIdIndex(HashMap<Object, Object> map) {
        ArrayList<Object> keys = getKeys(map);
        
        return keys.indexOf("id");
    }
    
}
