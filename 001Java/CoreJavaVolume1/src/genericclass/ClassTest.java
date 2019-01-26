package genericclass;

import inheritance.Employee;
import inheritance.Manager;

/**
 * ClassTest
 */
public class ClassTest {

    public static void main(String[] args) {
        castTest();
    }

    public static void castTest(){
        Manager manager = new Manager("xiaoMing", 3000, 2010, 01, 23);
        Employee employee = Employee.class.cast(manager);
        System.out.println(employee.toString());
    }
}