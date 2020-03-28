package kg.attractor.foodorderer.repository;

import kg.attractor.foodorderer.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ClientRepo extends PagingAndSortingRepository<Client, String> {

    Optional<Client> findByEmail(String email);
}
