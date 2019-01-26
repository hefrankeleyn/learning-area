package interface_lambda_innerclass.interfaces;

import java.util.Arrays;

/**
 * This program demonstrates the use of the Comparable interface
 * @version 1.0 2019-01-17
 * @author Li Fei
 */
public class EmployeeSortTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("aaa", 3700);
        staff[1] = new Employee("bbb", 3510);
        staff[2] = new Employee("ccc", 3600);

        Arrays.sort(staff);
        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}