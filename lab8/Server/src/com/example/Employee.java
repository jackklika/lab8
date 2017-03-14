package com.example;

public class Employee implements Comparable<Object>{
	
	public String firstName;
	public String lastName;
	public String department;
	public String phoneNumber;
	
	public Employee(String firstName, String lastName, String department, String phoneNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phoneNumber = phoneNum;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " \tin " + department + " \thas phone number of " + phoneNumber;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Employee) {
			Employee other = (Employee) o;
			return lastName.compareTo(other.lastName);
		}
		return 0;
	}

}
