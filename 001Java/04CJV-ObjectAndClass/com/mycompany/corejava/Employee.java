package com.mycompany.corejava;

public class Employee{
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee(String n, double s){
        name = n;
        salary = s;
        id = 0;
    }

	public String getName()
	{
		return this.name;
	}

	public double getSalary()
	{
		return this.salary;
    }
    
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary += raise;
    }
	public int getId()
	{
		return this.id;
	}

	public void setId()
	{
        this.id = nextId;
        nextId++;
    }
    
    public static int getNextId(){
        return nextId;
    }



    public static void main(String[] args) {
        Employee e = new Employee("Harry", 50000);
        System.out.println(e.getName() +" " + e.getSalary());
    }
}