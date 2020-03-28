package kg.attractor.foodorderer.util;

import kg.attractor.foodorderer.model.*;
import kg.attractor.foodorderer.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
@AllArgsConstructor
public class DataPreloader {

    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner preloadData(ClientRepo clientRepo, CafeRepo cafeRepo,
                                  DishRepo dishRepo, OrderRepo orderRepo){

        return args -> {
            clientRepo.deleteAll();
            cafeRepo.deleteAll();
            dishRepo.deleteAll();
            orderRepo.deleteAll();
            Random r = new Random();

            List<Client> clients = new ArrayList<>();
            String email = GenerateData.randomEmail();
            clients.add(Client.builder().username(GenerateData.randomPersonName())
                    .email(email).password(encoder.encode(email)).build());
            email = GenerateData.randomEmail();
            clients.add(Client.builder().username(GenerateData.randomPersonName())
                    .email(email).password(encoder.encode(email)).build());
            email = GenerateData.randomEmail();
            clients.add(Client.builder().username(GenerateData.randomPersonName())
                    .email(email).password(encoder.encode(email)).build());
            email = GenerateData.randomEmail();
            clients.add(Client.builder().username(GenerateData.randomPersonName())
                    .email(email).password(encoder.encode(email)).build());
            email = GenerateData.randomEmail();
            clients.add(Client.builder().username(GenerateData.randomPersonName())
                    .email(email).password(encoder.encode(email)).build());

            List<Cafe> cafes = new ArrayList<>();
            cafes.add(Cafe.builder().name(GenerateData.randomPlace().getName())
                    .description(GenerateData.randomPlace().getDescription()).id(UUID.randomUUID().toString()).build());
            cafes.add(Cafe.builder().name(GenerateData.randomPlace().getName())
                    .description(GenerateData.randomPlace().getDescription()).id(UUID.randomUUID().toString()).build());
            cafes.add(Cafe.builder().name(GenerateData.randomPlace().getName())
                    .description(GenerateData.randomPlace().getDescription()).id(UUID.randomUUID().toString()).build());
            cafes.add(Cafe.builder().name(GenerateData.randomPlace().getName())
                    .description(GenerateData.randomPlace().getDescription()).id(UUID.randomUUID().toString()).build());

            List<Dish> dishes = new ArrayList<>();
            dishes.add(Dish.builder().id(UUID.randomUUID().toString()).cafe(cafes.get(3))
                    .name(GenerateData.randomDish().getName()).price(r.nextInt(80)+20)
                    .type(GenerateData.randomDish().getType()).build());
            dishes.add(Dish.builder().id(UUID.randomUUID().toString()).cafe(cafes.get(0))
                    .name(GenerateData.randomDish().getName()).price(r.nextInt(80)+20)
                    .type(GenerateData.randomDish().getType()).build());
            dishes.add(Dish.builder().id(UUID.randomUUID().toString()).cafe(cafes.get(2))
                    .name(GenerateData.randomDish().getName()).price(r.nextInt(80)+20)
                    .type(GenerateData.randomDish().getType()).build());
            dishes.add(Dish.builder().id(UUID.randomUUID().toString()).cafe(cafes.get(1))
                    .name(GenerateData.randomDish().getName()).price(r.nextInt(80)+20)
                    .type(GenerateData.randomDish().getType()).build());
            dishes.add(Dish.builder().id(UUID.randomUUID().toString()).cafe(cafes.get(0))
                    .name(GenerateData.randomDish().getName()).price(r.nextInt(80)+20)
                    .type(GenerateData.randomDish().getType()).build());

            List<Order> orders = new ArrayList<>();
            orders.add(Order.builder().dateTime(LocalDateTime.now().minusWeeks(1))
                    .client(clients.get(0)).id(UUID.randomUUID().toString()).dish(dishes.get(1)).build());
            orders.add(Order.builder().dateTime(LocalDateTime.now().minusWeeks(2))
                    .client(clients.get(1)).id(UUID.randomUUID().toString()).dish(dishes.get(3)).build());
            orders.add(Order.builder().dateTime(LocalDateTime.now().minusWeeks(3))
                    .client(clients.get(0)).id(UUID.randomUUID().toString()).dish(dishes.get(0)).build());
            orders.add(Order.builder().dateTime(LocalDateTime.now().minusWeeks(4))
                    .client(clients.get(3)).id(UUID.randomUUID().toString()).dish(dishes.get(2)).build());

            clients.stream()
                    .peek(System.out::println)
                    .forEach(clientRepo::save);
            cafes.stream()
                    .peek(System.out::println)
                    .forEach(cafeRepo::save);
            orders.stream()
                    .peek(System.out::println)
                    .forEach(orderRepo::save);
            dishes.stream()
                    .peek(System.out::println)
                    .forEach(dishRepo::save);
        };
    }
}
