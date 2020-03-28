package kg.attractor.foodorderer.repository;

import kg.attractor.foodorderer.model.Cafe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CafeRepo extends PagingAndSortingRepository<Cafe, String> {
}
