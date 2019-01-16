package inheritance;
/**
 * This program demonstrates inheritance
 * @version 1.0 2019-01-13
 * @author lifei
 */
public class ManagerTest{
    public static void main(String[] args) {
        // construct a Manager object
        Manager boss = new Manager("Lu ZhanKa", 80000, 2019, 01, 03);
        boss.setBonus(2000);

        Employee[] staff = new Employee[3];

        // fill the staff array with Manager and Employee objects
        staff[0] = boss;
        staff[1] = new Employee("aaa", 3000, 2019, 01, 01);
        staff[2] = new Employee("bbb", 4000, 2019, 01, 02);

        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}