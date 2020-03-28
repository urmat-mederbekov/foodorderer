package kg.attractor.foodorderer.service;

import kg.attractor.foodorderer.dto.DishDTO;
import kg.attractor.foodorderer.model.Dish;
import kg.attractor.foodorderer.repository.DishRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DishService {

    private final DishRepo dishRepo;

    public Slice<DishDTO> getDishes(Pageable pageable, String cafeId){

        Slice<Dish> cafes = dishRepo.findAllByCafeId(pageable, cafeId);

        return  cafes.map(DishDTO::from);
    }
}
