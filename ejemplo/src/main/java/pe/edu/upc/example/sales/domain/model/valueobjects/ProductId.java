package pe.edu.upc.example.sales.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record ProductId(UUID value) {
    // Constructor that generates a random UUID if none is provided
    public ProductId() {
        this(UUID.randomUUID());
    }
    public ProductId {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("ProductId value cannot be null");
        }
    }
}
