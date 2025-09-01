package pe.edu.upc.example;

import pe.edu.upc.example.crm.domain.model.aggregates.Customer;
import pe.edu.upc.example.sales.domain.model.Entities.SalesOrderItem;
import pe.edu.upc.example.sales.domain.model.aggregates.SalesOrder;
import pe.edu.upc.example.sales.domain.model.valueobjects.ProductId;
import pe.edu.upc.example.shared.domain.model.valueobjects.Address;
import pe.edu.upc.example.shared.domain.model.valueobjects.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Address address = new Address("Av La marina 1589",
                "Lima", "51001", "Peru");
        Address address2 = new Address("Av La marina 2058",
                "Lima", "05101", "Peru");

        Customer customer = new Customer("Juan Perez",
                "juan@upc.edu.pe", address);

        System.out.println(customer);
        customer.updateContactInfo("juan.perez@upc.edu.pe", address2);
        System.out.println(customer.getContactInfo());

        SalesOrder salesOrder = new SalesOrder(customer.getId());
        System.out.println(salesOrder);

        SalesOrderItem pantalon = new SalesOrderItem(
                new ProductId(), 1,
                new Money(BigDecimal.valueOf(79.90),
                        Currency.getInstance("PEN")));
        SalesOrderItem chompa = new SalesOrderItem(
                new ProductId(), 2,
                new Money(BigDecimal.valueOf(79.90),
                        Currency.getInstance("PEN")));
        salesOrder.addItem(pantalon);
        salesOrder.addItem(chompa);
        System.out.println(salesOrder);

    }
}
