package pe.edu.upc.example.shared.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record CustomerId(UUID value) {
    // Constructor that generates a random UUID if none is provided
    public CustomerId() {
        this(UUID.randomUUID());
    }
    public CustomerId {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("CustomerId value cannot be null");
        }
    }
}
