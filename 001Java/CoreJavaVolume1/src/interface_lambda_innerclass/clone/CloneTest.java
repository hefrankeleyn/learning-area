package interface_lambda_innerclass.clone;

/**
 * This program demonstrates cloning
 * @version 1.0 2019-01-19
 * @author Li Fei
 */
public class CloneTest {

    public static void main(String[] args) {
        try {
            Employee original = new Employee("aaa", 3000);
            original.setHirDay(2019, 1, 1);
            Employee copy = original.clone();  
            copy.setHirDay(2019, 01, 19);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}