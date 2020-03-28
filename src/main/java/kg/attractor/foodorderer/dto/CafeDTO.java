package kg.attractor.foodorderer.dto;

import kg.attractor.foodorderer.model.Cafe;
import lombok.*;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class CafeDTO {
    public static CafeDTO from(Cafe cafe){
        return builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .description(cafe.getDescription())
                .build();
    }
    private String id;
    private String name;
    private String description;
}
