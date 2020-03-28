package kg.attractor.foodorderer.service;

import kg.attractor.foodorderer.dto.ClientDTO;
import kg.attractor.foodorderer.exception.ResourceNotFoundException;
import kg.attractor.foodorderer.model.Client;
import kg.attractor.foodorderer.repository.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService implements UserDetailsService {
    private final ClientRepo clientRepo;

    public ClientDTO getClient(Authentication authentication){
        Client client = (Client) authentication.getPrincipal();
        return  ClientDTO.from(clientRepo.findByEmail(client.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Client with email "
                        + client.getEmail() + "not found")));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Client> user = clientRepo.findByEmail(email);
        if(user.isEmpty())
            throw new UsernameNotFoundException("Not found");
        return user.get();
    }
}
