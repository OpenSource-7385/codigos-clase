package pe.edu.upc.hello.platform.demo.crm.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.hello.platform.demo.crm.domain.model.aggregates.Customer;
import pe.edu.upc.hello.platform.demo.shared.domain.model.valueobjects.Address;

@RestController
@RequestMapping("hello")
public class CustomerController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, World!");
    }

    @GetMapping("customer")
    public ResponseEntity<Customer> helloCustomer() {
        Address address = new Address("Av La marina 1589",
                "Lima", "51001", "Peru");
        Customer customer = new Customer("Juan Perez",
                "juan@upc.edu.pe", address);
        return ResponseEntity.ok(customer);
    }
}
