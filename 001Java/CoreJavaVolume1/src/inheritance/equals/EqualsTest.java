package inheritance.equals;

public class EqualsTest{
    public static void main(String[] args) {
        Employee alice1 = new Employee("aaa", 3000, 2019, 01, 01);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("aaa", 3000, 2019, 01, 01);
        Employee bob = new Employee("ccc", 2000, 2019, 01, 01);

        System.out.println("alice1 == alice2:" + (alice1 == alice2));
        System.out.println("alice1 == alice3:" + (alice1 == alice3));
        System.out.println("alice1.equals(alice3):" + (alice1.equals(alice3)));
        System.out.println("alice1.equals(bob):" + (alice1.equals(bob)));

        System.out.println("bob.toString():" + bob);

        Manager carl = new Manager("aaa", 3000, 2019, 01, 01);
        Manager boss = new Manager("aaa", 3000, 2019, 01, 01);
        boss.setBonus(5000);
        System.out.println("boss.toString():" + boss);
        System.out.println("carl.equals(boss):" + carl.equals(boss));
        System.out.println("alice1.hashCode():" + alice1.hashCode());
        System.out.println("alice3.hashCode():" + alice3.hashCode());
        System.out.println("bob.hashCode():" + bob.hashCode());
        System.out.println("carl.hashCode():" + carl.hashCode());
    }
}