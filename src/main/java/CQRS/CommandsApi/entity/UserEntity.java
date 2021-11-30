package CQRS.CommandsApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private UUID id;
    private String username;
    private String email;
    private String password;

}
