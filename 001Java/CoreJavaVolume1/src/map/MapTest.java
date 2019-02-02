package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import inheritance.Employee;

/**
 * This program demonstrates the use of a map with key type string and value type element.
 * @version 2019-01-26
 * @author Li Fei
 */
public class MapTest {

    public static void main(String[] args) {
        //runMain();
        mapItemTest();
        linkedHashMapTest();
    }

    private static void linkedHashMapTest(){
    

    //    Map<String,Integer> map =  new LinkedHashMap<>(128, 0.75, true);
    //     map.put("aaa", 1);
    //     System.out.println(map);
        
    }

    private static void mapItemTest(){
        Map<String, Integer> map = new HashMap<>();
        map.putIfAbsent("aaa", 0);
        map.put("aaa", map.get("aaa") + 1);
        System.out.println(map);
        map.merge("bbb", 1, Integer::sum);
        map.merge("bbb", 1, Integer::sum);
        System.out.println(map);
    }

    private static void runMain(){
        Map<String, Employee> staff = new HashMap<>();
        staff.put("001", new Employee("xiaoA"));
        staff.put("002", new Employee("xiaoB"));
        staff.put("004", new Employee("xiaoC"));
        staff.put("003", new Employee("xiaoD"));

        // print all entries
        System.out.println(staff);

        // remove an entry
        staff.remove("004");

        // replace an entry
        staff.put("003", new Employee("daC"));

        // loop up a value
        System.out.println(staff.get("001"));

        // iterator through all entries
        staff.forEach((k,v)->System.out.print("key=" + k + ", vlaue=" + v));
    }
    
}