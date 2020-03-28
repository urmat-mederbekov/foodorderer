package kg.attractor.foodorderer.service;

import kg.attractor.foodorderer.dto.OrderDTO;
import kg.attractor.foodorderer.exception.ResourceNotFoundException;
import kg.attractor.foodorderer.model.Client;
import kg.attractor.foodorderer.model.Dish;
import kg.attractor.foodorderer.model.Order;
import kg.attractor.foodorderer.repository.DishRepo;
import kg.attractor.foodorderer.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final DishRepo dishRepo;

    public OrderDTO order(String dishId, String cafeId, Authentication authentication){

        Client client = (Client) authentication.getPrincipal();
        Dish dish = dishRepo.findByIdAndCafeId(dishId, cafeId)
                .orElseThrow(() -> new ResourceNotFoundException("Dish with id " + dishId + " not found"));
        Order order = Order.builder()
                .id(UUID.randomUUID().toString())
                .client(client)
                .dish(dish)
                .dateTime(LocalDateTime.now())
                .build();

        orderRepo.save(order);
        return OrderDTO.from(order);
    }




















    public Page<OrderDTO> getOrders(Pageable pageable, Authentication authentication){

        Client client = (Client) authentication.getPrincipal();
        Page<Order> orders = orderRepo.findAllByClientEmail(pageable, client.getEmail());

        return orders.map(OrderDTO::from);
    }

}
