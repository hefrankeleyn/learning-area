package inheritance;
/**
 * A {@code Manager} represents a manager.
 * Manager is a employee
 * @version 1.0 2019-01-13
 * @author lifei
 */
public class Manager extends Employee{
    
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }
	public double getBonus()
	{
        double baseSalary = super.getSalary();
		return baseSalary + this.bonus;
	}

	public void setBonus(double bonus)
	{
		this.bonus = bonus;
	}


}