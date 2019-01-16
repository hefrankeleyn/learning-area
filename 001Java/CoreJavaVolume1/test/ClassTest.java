public class ClassTest{
    public static void main(String[] args) {
        //objSuperClassTest();
        primitiveTest();
    }
    /**
     * 获取Object对象的superclass
     * @version 1.0 2019-01-15
     * @author Li Fei
     * @return 返回null
     */
    public static void objSuperClassTest(){
        System.out.println(Object.class.getSuperclass());
    }
    /**
     * 测试是否为原始数据类型
     */
    public static void primitiveTest(){
        Integer aa = new Integer(23);
        Class cl = aa.getClass();
        System.out.println(cl.isPrimitive());
        System.out.println("cl");
    }
}