package inheritance.abstractclasses;

import java.time.LocalDate;

/**
 * A {@code Employee} represents a employee that is a person.
 * @see Person
 * @version 1.0 2019-01-13
 * @author lifei
 */
public class Employee extends Person{

    private double salary;
    private LocalDate hirDay;
    /**
     * 
     * @param name
     * @param salary
     * @param year
     * @param month
     * @param day
     */
    public Employee(String name, double salary, int year,int month, int day){
        super(name);
        this.salary = salary;
        this.hirDay = LocalDate.of(year, month, day);
    }

	public double getSalary()
	{
		return this.salary;
	}

	public LocalDate getHirday()
	{
		return this.hirDay;
	}

    @Override
    public String getDescription() {
        return String.format("An employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }
}