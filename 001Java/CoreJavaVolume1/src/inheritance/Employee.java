package inheritance;

import java.time.LocalDate;
/**
 * A {@code Employee} object represents a employee
 * @version 1.0 2019-01-13
 * @author lifei
 */
public class Employee{
    private String name;
    private double salary;
    private LocalDate hireDay;
    /**
    *  Constructor
     * @param name
     * @param salary
     * @param year
     * @param month
     * @param day
     */
    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }
	public String getName()
	{
		return this.name;
	}
	public double getSalary()
	{
		return this.salary;
    }

	public LocalDate getHireday()
	{
		return this.hireDay;
    }
    /**
     * raise salary
     * @param byPercent value of percent
     */
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }


}