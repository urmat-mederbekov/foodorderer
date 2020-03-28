package kg.attractor.foodorderer.controller;

import kg.attractor.foodorderer.dto.OrderDTO;
import kg.attractor.foodorderer.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderDTO order(String dishId, String cafeId, Authentication authentication){
        return orderService.order(dishId, cafeId, authentication);
    }
}
