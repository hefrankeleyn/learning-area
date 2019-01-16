package inheritance.arraylist;

import java.util.ArrayList;

public class ArrayListTest{
    public static void main(String[] args) {
        
    }
    public void test01(){
        ArrayList<Integer> list =new ArrayList<>();
        list.ensureCapacity(10);
        list.trimToSize();
    }
}