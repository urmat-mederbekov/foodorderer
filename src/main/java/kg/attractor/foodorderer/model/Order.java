package kg.attractor.foodorderer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Order {

    private String id;
    @DBRef
    private Client client;
    private Dish dish;
    private LocalDateTime dateTime;
}
