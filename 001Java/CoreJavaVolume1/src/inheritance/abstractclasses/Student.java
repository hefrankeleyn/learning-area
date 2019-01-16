package inheritance.abstractclasses;

/**
 * A {@code Student} represents a Student that ia s Person
 * @see Person
 * @version 1.0 2019-01-13
 * @author lifei
 */
public class Student extends Person{
    
    private String major;

    public Student(String name, String major){
        // pass name to superclass constructor
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return String.format("A student majoring in %s", major);
    }
}