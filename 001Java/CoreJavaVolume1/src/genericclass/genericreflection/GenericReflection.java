package genericclass.genericreflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * GenericReflection
 * @version 2019-01-24
 * @author Li Fei
 */
public class GenericReflection {

    private static final Logger logger = Logger.getLogger("genericclass.genericreflection");

    public static void main(String[] args) {
        //test();
        //String[] sa = {"genericclass.Pair"};
        String[] sa = {"genericclass.pair2.ArrayAlg"};
        runMain(sa);
    }
    public static void test(){
        Class<?> cl = String.class;
        
        System.out.print(cl + " cl.getName:" + cl.getName());
        Type[] types = new Type[]{Object.class};
        System.out.print(Arrays.toString(types));
    }
    public static void runMain(String[] args){
        // read class name from command line args or user input
        String name;
        if(args.length > 0) name = args[0];
        else{
            try (Scanner in = new Scanner(System.in)){
                System.out.print("Enter class name (e.g. java.util.Collections):");
                name = in.next();
            }
        }

        // print generic info for class and public methods
        try {
            Class<?> cl = Class.forName(name);
            printClass(cl);

            for (Method m : cl.getDeclaredMethods()) {
                printMethod(m);
            }
        } catch (ClassNotFoundException e) {
            logger.throwing("Class", "forName", e);
        }

    }

    public static void printClass(Class<?> cl){
        System.out.print(cl +"");

        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null){
            System.out.print(" extends ");
            printTypes(sc, false);
        }
        printTypes(cl.getGenericInterfaces(), " implements ", ",", "", false);
        System.out.println();

    }

    public static void printMethod(Method m){
        String name = m.getName();

        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(), "<", ", ", "> ", true);

        printTypes(m.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(name + "(");
        printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition){
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class})) return;
        if (types.length > 0) System.out.print(pre);
        for (int i = 0; i < types.length; i++) {
            if (i > 0) System.out.print(sep);
            printTypes(types[i], isDefinition);
        }
        if (types.length > 0) System.out.print(suf);
    }
    public static void printTypes(Type type, boolean isDefinition){
        // Class 类 描述具体类型
        if (type instanceof Class){
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        }
        // TypeVariable 接口，描述类型变量
        else if (type instanceof TypeVariable){
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t.getName());
            if (isDefinition){
                // t.getBound() 获取界限
                printTypes(t.getBounds(), " extends ", " & ", "", false);
            }
        }
        // WildcardType 接口， 描述通配符 如 ? super T
        else if (type instanceof WildcardType){
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(t.getLowerBounds(), " super ", " & ", "", false);
        }
        // ParameterizedType 接口， 描述泛型类或接口类型 Comparatable<? super T>
        else if (type instanceof ParameterizedType){
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null){
                printTypes(owner, false);
                System.out.print(".");
            }
            printTypes(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ",", ">", false);
        }

        // GenericArrayType 接口，描述泛型数组
        else if (type instanceof GenericArrayType){
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printTypes(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }

}