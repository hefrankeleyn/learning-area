package inheritance.abstractclasses;
/**
 * This program demonstrates abstract classes
 * @version 1.0 2019-01-13
 * @author lifei
 */
public class PersonTest{
    public static void main(String[] args) {
        Person[] people = new Person[2];

        // fill the people array with Student and Employee objects.
        people[0] = new Employee("aaa", 20000, 2019, 01, 01);
        people[1] = new Student("xiaoming", "algorithms");

        // print out names and descriptions of all Person objects
        for(Person p : people){
            System.out.println(p.getName() +"," +p.getDescription());
        }
        boolean b = people[0].equals(people[1]);
        System.out.println(b);
    }
}