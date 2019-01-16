package inheritance.reflection.object_analyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/**
 * Object analyzer that common toString() method
 * 注意： 其中调用了递归函数，容易和toString()方法混淆
 * @version 1.0 2019-01-15
 * @author Li Fei
 */
public class ObjectAnalyzer{
    
    private ArrayList<Object> visited = new ArrayList<>();
    
    
    /**
     * Converts an object to a string representation that lists all fields.
     * @param obj an object
     * @return a string with the object's class name and all field names and values.
     */
    public String toString(Object obj){
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        
        if(cl == String.class) return (String)obj;
        // System.out.println(cl.getName());
        // System.out.println("isArray: "+cl.isArray());
        // 判断是否为数组，处理为数组的值
        if(cl.isArray()){
            // getcomponentType 方法返回一个数组的成分类型，如果不是数组，返回null
            String r = cl.getComponentType() + "[]{";
            //System.out.println(r);
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i>0) r += ",";
                // 获取数组的角标为i的值
                Object val = Array.get(obj, i);

                // 判断数组里面存的是否为原始类型的值，如果不是原始数据类型，采用递归调用
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }
        String r = cl.getName();
        // inspect the fields of the class and all superclasses
        do{
            r +="[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        // 获取字段的值
                        Object val = f.get(obj);
                        // 判断是否为原始数据类型，如果不是原始数据类型，采用递归调用
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            // 如果cl不为空，就持续该循环
            cl = cl.getSuperclass();
        }while(cl!=null);
        return r;
     
    }
    
    
}