package by.iba.entity;

public class Person {
	  private String name;
	  private String address;
	  private String email;
	  private String phone;


	public Person(String name, String address, 
	    String email, String phone) {
	    this.name = name;
	    this.address = address;
	    this.email = email;
	    this.phone = phone;
	  }

	// -- used by the data-binding framework
	  public Person() { }

	// -- accessors
	  public String getName() { return name; }

	  public String getAddress() { return address; }

	  public String getEmail() { return email; }

	  public String getPhone() { return phone; }


	// -- mutators
	  public void setName(String name) { this.name = name; }

	  public void setAddress(String address) {
	    this.address = address;
	  }

	  public void setEmail(String email) { this.email = email;  }

	  public void setPhone(String phone) {
	    this.phone = phone;
	  }

	@Override
	public String toString() {
		  StringBuilder builder = new StringBuilder();
		  builder.append("Person Attributes\n");
		  builder.append("-----------------");
		  builder.append("\nName: " + name );
		  builder.append("\nAddress: " + address );
		  builder.append("\nEmail: " + email );
		  builder.append("\nPhone: " +  phone );
		return builder.toString();
	}
	  
}