package by.iba.entity;

public class Professor extends UniversityMember {

	private String firstName;
	private String secondName;
	private String stream;
	
	public Professor() {
		
	}
	
	public Professor(String f, String s, String st) {
		firstName = f;
		secondName = s;
		stream = st;
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

	public String getStream() {
		return stream;
	}

	public void setStream(String group) {
		this.stream = group;
	}
	
	@Override
	public String toString() {		
		return firstName + " " + secondName + " " + stream;
	}
}
