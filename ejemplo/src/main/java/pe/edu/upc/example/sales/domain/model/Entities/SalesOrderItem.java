package pe.edu.upc.example.sales.domain.model.Entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import pe.edu.upc.example.sales.domain.model.valueobjects.ProductId;
import pe.edu.upc.example.shared.domain.model.valueobjects.Money;

import java.util.Objects;

@Getter
@ToString
public class SalesOrderItem {
    private final ProductId productId;
    @Setter
    private int quantity;
    private final Money amount;

    public SalesOrderItem(@NonNull ProductId productId, int quantity, @NonNull Money amount) {
        if (Objects.isNull(productId) ) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (Objects.isNull(amount)) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }
    public Money calculateItemAmount() {
        return amount.multiply(quantity);
    }

}
