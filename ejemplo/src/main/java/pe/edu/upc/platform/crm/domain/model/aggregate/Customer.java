package pe.edu.upc.platform.crm.domain.model.aggregate;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import pe.edu.upc.platform.shared.domain.model.valueobjects.Address;
import pe.edu.upc.platform.shared.domain.model.valueobjects.CustomerId;

import java.util.Objects;

@Getter
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
        if (Objects.isNull(email)|| email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (Objects.isNull(address)) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        this.id = new CustomerId();
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public void updateContactInfo(String email, Address address) {
        if (Objects.isNull(email)|| email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }

        if (Objects.isNull(address)) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        this.email = email;
        this.address = address;
    }
}
