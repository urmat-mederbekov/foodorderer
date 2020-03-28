package kg.attractor.foodorderer.dto;

import kg.attractor.foodorderer.model.Client;
import lombok.*;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class ClientDTO {
    public static ClientDTO from(Client client){
        return builder()
                .username(client.getUsername())
                .email(client.getEmail())
                .build();
    }
    private String username;
    private String email;
}
