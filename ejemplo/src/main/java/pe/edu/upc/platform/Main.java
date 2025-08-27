package pe.edu.upc.platform;

import pe.edu.upc.platform.crm.domain.model.aggregate.Customer;
import pe.edu.upc.platform.shared.domain.model.valueobjects.Address;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Address address = new Address("Av. La marina", "Lima", "15001", "Peru");
        Customer customer = new Customer("John doe", "john@upc.edu.pe", address);

        System.out.println("Customer created: " + customer.getName());
        System.out.println("Id created: " + customer.getEmail());
        System.out.println("Name created: " + customer.getAddress());
        System.out.println("Address created: " + customer.getId());
    }
}
