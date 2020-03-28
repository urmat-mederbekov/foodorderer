package kg.attractor.foodorderer.dto;

import kg.attractor.foodorderer.model.Client;
import kg.attractor.foodorderer.model.Dish;
import kg.attractor.foodorderer.model.Order;
import lombok.*;

import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class OrderDTO {
    public static OrderDTO from(Order order){
        return builder()
                .id(order.getId())
                .client(order.getClient())
                .dish(order.getDish())
                .dateTime(order.getDateTime())
                .build();
    }
    private String id;
    private Client client;
    private Dish dish;
    private LocalDateTime dateTime;
}
