package kg.attractor.foodorderer.repository;

import kg.attractor.foodorderer.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OrderRepo extends PagingAndSortingRepository<Order, String> {

    Page<Order> findAllByClientEmail(Pageable pageable, String email);
}
