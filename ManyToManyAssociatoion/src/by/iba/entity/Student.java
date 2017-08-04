package by.iba.entity;

public class Student extends UniversityMember {
	private String firstName;
	private String secondName;
	private String group;
	
	public Student() {
		
	}
	
	public Student(String f, String s) {
		firstName = f;
		secondName = s;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName + " " + secondName;
	}
	
}
