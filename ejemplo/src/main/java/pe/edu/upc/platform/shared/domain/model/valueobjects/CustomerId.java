package pe.edu.upc.platform.shared.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record CustomerId(UUID value) {
    public CustomerId {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("Customer id cannot be null");
        }
    }

    public CustomerId() {
        this(UUID.randomUUID());
    }

    public String toString() {
        return value.toString();
    }
}
