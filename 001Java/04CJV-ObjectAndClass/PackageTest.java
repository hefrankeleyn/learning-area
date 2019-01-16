import com.mycompany.corejava.Employee;
import static java.lang.System.*;

public class PackageTest{
    public static void main(String[] args) {
        Employee harry = new Employee("Harry",5000);
        harry.raiseSalary(3000);
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}