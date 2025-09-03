package pe.edu.upc.hello.platform.demo.sales.domain.model.aggregates;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import pe.edu.upc.hello.platform.demo.sales.domain.model.Entities.SalesOrderItem;
import pe.edu.upc.hello.platform.demo.shared.domain.model.valueobjects.CustomerId;
import pe.edu.upc.hello.platform.demo.shared.domain.model.valueobjects.Money;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@ToString
public class SalesOrder {
    private final UUID id;
    private final CustomerId customerId;
    private final LocalDateTime orderDate;
    private List<SalesOrderItem> items;
    private Money totalAmount;

    public SalesOrder(@NonNull CustomerId customerId) {
        if (Objects.isNull(customerId)) {
            throw new IllegalArgumentException("CustomerId cannot be null");
        }
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.totalAmount = new Money(BigDecimal.ZERO, Currency.getInstance("PEN"));
    }
    public void addItem(@NonNull SalesOrderItem item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("SalesOrderItem cannot be null");
        }
        this.items.add(item);
        this.calculateTotalAmount();
    }
    public void calculateTotalAmount() {
        this.totalAmount = items.stream()
                .map(SalesOrderItem::calculateItemAmount)
                .reduce(new Money(BigDecimal.ZERO, Currency.getInstance("PEN")),
                        Money::add);
    }
}
