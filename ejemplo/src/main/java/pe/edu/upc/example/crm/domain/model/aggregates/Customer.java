package pe.edu.upc.example.crm.domain.model.aggregates;

import lombok.*;
import pe.edu.upc.example.shared.domain.model.valueobjects.Address;
import pe.edu.upc.example.shared.domain.model.valueobjects.CustomerId;

import java.util.Objects;

@Getter
@ToString
public class Customer {
    private final CustomerId id;
    @Setter @NonNull
    private String name;
    @Setter @NonNull
    private String email;
    @Setter @NonNull
    private Address address;

    public Customer(String name, String email, Address address) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (Objects.isNull(email) || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (Objects.isNull(address)) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        this.name = name;
        this.email = email;
        this.address = address;
        this.id = new CustomerId();
    }
    public void updateContactInfo(String email, Address address) {
        if (Objects.isNull(email) || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (Objects.isNull(address)) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        this.email = email;
        this.address = address;
    }
    public String getContactInfo() {
        return String.format("Email: %s, Address: %s, %s, %s, %s",
                email, address.street(), address.city(),
                address.postalCode(), address.country());
    }
}







