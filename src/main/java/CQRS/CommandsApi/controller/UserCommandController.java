package CQRS.CommandsApi.controller;


import CQRS.CommandsApi.command.CreateUserCommand;
import CQRS.CommandsApi.command.UpdateUserCommand;
import CQRS.CommandsApi.entity.UserEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/command/")
public class UserCommandController {

    private CommandGateway commandGateway;

    public UserCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("user")
    public String addUser(@RequestBody UserEntity userEntity){
        CreateUserCommand createUserCommand = new CreateUserCommand(
                                                    userEntity.getId().randomUUID(),
                                                    userEntity.getUsername(),
                                                    userEntity.getEmail(),
                                                    userEntity.getPassword()
                                                );
        commandGateway.sendAndWait(createUserCommand);
        return "User Created";
    }

    @PutMapping("user")
    public String UpdateUser(@RequestBody UserEntity userEntity){
        UpdateUserCommand updateUserCommand = new UpdateUserCommand(
                                                userEntity.getId(),
                                                userEntity.getUsername(),
                                                userEntity.getEmail(),
                                                userEntity.getPassword()
                                            );

        commandGateway.sendAndWait(updateUserCommand);

        return "user updated";
    }


}
