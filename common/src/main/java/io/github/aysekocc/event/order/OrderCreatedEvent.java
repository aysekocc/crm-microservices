package io.github.aysekocc.event.order;

import java.time.LocalDate;

public class OrderCreatedEvent {
    private String id;
    private LocalDate orderDate;
    public OrderCreatedEvent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderCreatedEvent(String id, LocalDate orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
