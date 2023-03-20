package axon.mall.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.*;

import axon.mall.command.*;
import axon.mall.event.*;
import axon.mall.query.*;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.ToString;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@Data
@ToString
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private String productName;
    private String productId;
    private String status;
    private Integer qty;
    private String userId;

    public OrderAggregate() {}

    @CommandHandler
    public OrderAggregate(OrderCommand command) {}

    private String createUUID() {
        return UUID.randomUUID().toString();
    }

    @EventSourcingHandler
    public void on(OrderPlacedEvent event) {
        //TODO: business logic here

    }
}