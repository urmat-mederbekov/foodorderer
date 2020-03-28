package kg.attractor.foodorderer.dto;

import kg.attractor.foodorderer.model.Cafe;
import kg.attractor.foodorderer.model.Dish;
import lombok.*;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class DishDTO {
    public static DishDTO from(Dish dish){
        return builder()
                .id(dish.getId())
                .name(dish.getName())
                .cafe(dish.getCafe())
                .type(dish.getType())
                .price(dish.getPrice())
                .build();
    }
    private String id;
    private String name;
    private Cafe cafe;
    private String type;
    private double price;
}
