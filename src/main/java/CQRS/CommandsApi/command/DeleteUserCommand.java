package CQRS.CommandsApi.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class DeleteUserCommand {
    @TargetAggregateIdentifier
    private UUID id;
}
