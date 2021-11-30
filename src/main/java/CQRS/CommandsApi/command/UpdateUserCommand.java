package CQRS.CommandsApi.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private String username;
    private String email;
    private String password;
}
