package interface_lambda_innerclass.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ComparatorTest
 */
public class ComparatorTest {

    public static void main(String[] args) {
         comparingTest();


    }



    public static void comparingTest(){
        People[] peoples = new People[3];
        peoples[0]=new People("ac", 12,"bian","ming");
        peoples[1]=new People("dcd", 11,"chao","hai");
        peoples[2]=new People("ccea", 15,"aang","zhou");
        System.out.println(Arrays.toString(peoples));
        // [[name=aaa, age=12], [name=cce, age=15], [name=dcf, age=11]]
        //Arrays.sort(peoples, Comparator.comparing(x->x.getName()));
        Arrays.sort(peoples, Comparator.comparing(People::getName));
        System.out.println(Arrays.toString(peoples));

        Arrays.sort(peoples, Comparator.comparing(People::getFirstName).thenComparing(People::getLastName));
        System.out.println(Arrays.toString(peoples));

        Arrays.sort(peoples, Comparator.comparing(People::getName,(s,t)->Integer.compare(s.length(), t.length())));
        System.out.println(Arrays.toString(peoples));

        Arrays.sort(peoples, Comparator.comparingInt(p -> p.getName().length()));
        System.out.println(Arrays.toString(peoples));

        peoples[0].setMiddleName("小明");
        Arrays.sort(peoples, Comparator.comparing(People::getMiddleName, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println(Arrays.toString(peoples));
    }
}

class People{
    private String name;
    private int age;
    private String firstName;
    private String lastName;
    private String middleName;

    public People(String name, int age, String firstName, String lastName){
        this.name = name;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public String getMiddleName(){
        return this.middleName;
    }
    public String getName(){
        return this.name;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    @Override
    public String toString() {
        return "[name=" + name +", age=" + age +"firstName=" +firstName+ 
               ", lastName="+lastName+",middleName="+middleName+"]";
    }
}