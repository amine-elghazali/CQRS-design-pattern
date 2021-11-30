package CQRS.CommandsApi.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserEvent {
    private UUID id;
    private String username;
    private String email;
    private String password;
}
