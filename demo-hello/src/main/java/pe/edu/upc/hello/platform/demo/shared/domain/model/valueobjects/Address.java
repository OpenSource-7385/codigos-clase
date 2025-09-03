package pe.edu.upc.hello.platform.demo.shared.domain.model.valueobjects;

import java.util.Objects;

public record Address(String street, String city,
                      String postalCode, String country) {
    // jpa requires a no-args constructor
    public Address() {
        this(null, null, null, null);
    }
    public Address {
        if (Objects.isNull(street) || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be null or blank");
        }
        if (Objects.isNull(city) || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        if (Objects.isNull(postalCode) || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code cannot be null or blank");
        }
        if (Objects.isNull(country) || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be null or blank");
        }
    }
}
