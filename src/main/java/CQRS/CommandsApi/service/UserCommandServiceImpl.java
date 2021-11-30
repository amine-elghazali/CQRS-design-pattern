package CQRS.CommandsApi.service;


import CQRS.CommandsApi.entity.UserEntity;
import CQRS.CommandsApi.event.CreateUserEvent;
import CQRS.CommandsApi.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCommandServiceImpl{

    @Autowired
    private final UserRepo userRepo;

    @EventHandler
    public void on(CreateUserEvent event){
        System.out.println("helllo service");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event,userEntity);
        userRepo.save(userEntity);
    }
}
