package pe.edu.upc.platform.shared.domain.model.valueobjects;

import java.util.Objects;

public record Address(String street, String city, String postalCode, String country) {
    public Address {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be null or blank");
        }
        if (Objects.isNull(city) || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        if (postalCode == null || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code cannot be null or blank");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be null or blank");
        }
    }
}
