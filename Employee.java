package com.employee;

public class Employee
{
	
		
		private int employeeId;
	    private String employeeName;
	    private int employeeAge;
	    private char employeeGender;
	    private double salary;
	    private String designation;
	    
	    
	    public Employee(int employeeId, String employeeName, int employeeAge, char employeeGender, double salary,
				String designation)
	    {
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.employeeAge = employeeAge;
			this.employeeGender = employeeGender;
			this.salary = salary;
			this.designation = designation;
		}


		public int getEmployeeId()
		{
			return employeeId;
		}


		public void setEmployeeId(int employeeId)
		{
			this.employeeId = employeeId;
		}


		public String getEmployeeName()
		{
			return employeeName;
		}


		public void setEmployeeName(String employeeName)
		{
			this.employeeName = employeeName;
		}


		public int getEmployeeAge() 
		{
			return employeeAge;
		}


		public void setEmployeeAge(int employeeAge) 
		{
			this.employeeAge = employeeAge;
		}


		public char getEmployeeGender() 
		{
			return employeeGender;
		}


		public void setEmployeeGender(char employeeGender)
		{
			this.employeeGender = employeeGender;
		}


		public double getSalary()
		{
			return salary;
		}


		public void setSalary(double salary) 
		{
			this.salary = salary;
		}


		public String getDesignation()
		{
			return designation;
		}


		public void setDesignation(String designation) 
		{
			this.designation = designation;
		}


		@Override
		public String toString() 
		{
			return "[employeeId ="  +  employeeId + ", employeeName =" +  employeeName + ","
					+ " employeeAge =" +   employeeAge + ", employeeGender ="  +  employeeGender + ","
							+ " salary ="  +  salary +"lpa"+ ", designation="  +  designation + "]";
		}
	    
	    
	    
	}

