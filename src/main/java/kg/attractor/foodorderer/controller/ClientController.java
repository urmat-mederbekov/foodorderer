package kg.attractor.foodorderer.controller;

import kg.attractor.foodorderer.annotations.ApiPageable;
import kg.attractor.foodorderer.dto.ClientDTO;
import kg.attractor.foodorderer.dto.OrderDTO;
import kg.attractor.foodorderer.service.ClientService;
import kg.attractor.foodorderer.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final OrderService orderService;
    private final ClientService clientService;

    @GetMapping("/client")
    public ClientDTO getClient(Authentication authentication){
        return clientService.getClient(authentication);
    }

    @ApiPageable
    @GetMapping("/client/orders")
    public Page<OrderDTO> getOrders(@ApiIgnore Pageable pageable, Authentication authentication){
        return orderService.getOrders(pageable, authentication);
    }
}
