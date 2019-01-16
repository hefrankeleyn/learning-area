package inheritance.abstractclasses;

import java.util.Objects;

/**
 * A abstract class {@code Person} represents a people.
 * @version 1.0 2019-01-13
 * @author lifei
 */
public abstract class Person{
    private String name;
    public abstract String getDescription();
    /**
     * 
     * @param name
     */
    public Person(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        
        if(obj == null) return false;
        System.out.println("getClass() ");
        System.out.println(getClass());
        System.out.println("obj.getClass() ");
        System.out.println(obj.getClass());
        System.out.println("other instanceof Person:");
        System.out.println(obj instanceof Person);
        if(getClass() != obj.getClass()){
            return false;
        }

        Person other = (Person)obj;
        return Objects.equals(this.name, other.name);
    }
}