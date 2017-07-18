
public class Main {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("Ivan", "Ivanov", new Account(300));
		Customer customer2 = new Customer("Ivan", "Petrov", new Account(100));
		Customer customer3 = new Customer("Ivan", "Ivanov", new Account(300));
		
		System.out.println("customer1 == customer2: " + customer1.equals(customer2));
		System.out.println("customer1 == customer3: " + customer1.equals(customer3));
	}

}
