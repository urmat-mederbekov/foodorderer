package kg.attractor.foodorderer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dishes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Dish {

    private String id;
    private String name;
    @DBRef
    private Cafe cafe;
    private String type;
    private double price;
}
