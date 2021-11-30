package CQRS.CommandsApi.aggregate;

import CQRS.CommandsApi.command.CreateUserCommand;
import CQRS.CommandsApi.command.UpdateUserCommand;
import CQRS.CommandsApi.event.CreateUserEvent;
import CQRS.CommandsApi.event.UpdateUserEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private UUID id;
    private String username;
    private String email;
    private String password;

    @CommandHandler
    public UserAggregate(CreateUserCommand cmd) {
        CreateUserEvent event = new CreateUserEvent();

        BeanUtils.copyProperties(cmd,event);

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateUserCommand cmd){
        UpdateUserEvent event = new UpdateUserEvent();

        BeanUtils.copyProperties(cmd,event);

        AggregateLifecycle.apply(event);
    }



    @EventSourcingHandler
    public void on(CreateUserEvent event) {
        this.id = event.getId();
        this.username = event.getUsername();
        this.email = event.getEmail();
        this.password = event.getPassword();
    }

    @EventSourcingHandler
    public void on(UpdateUserEvent event) {
        this.id = event.getId();
        this.username = event.getUsername();
        this.email = event.getEmail();
        this.password = event.getPassword();
    }
}