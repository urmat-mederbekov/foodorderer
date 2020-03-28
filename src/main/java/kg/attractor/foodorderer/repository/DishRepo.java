package kg.attractor.foodorderer.repository;

import kg.attractor.foodorderer.model.Dish;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DishRepo extends PagingAndSortingRepository<Dish, String> {
    Slice<Dish> findAllByCafeId(Pageable pageable, String cafeId);
    Optional<Dish> findByIdAndCafeId(String id, String cafeId);
}
