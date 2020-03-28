package kg.attractor.foodorderer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "cafes")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Cafe {
    private String id;
    private String name;
    private String description;
}
