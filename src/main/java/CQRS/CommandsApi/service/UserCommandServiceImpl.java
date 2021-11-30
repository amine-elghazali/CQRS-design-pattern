package CQRS.CommandsApi.service;


import CQRS.CommandsApi.entity.UserEntity;
import CQRS.CommandsApi.event.CreateUserEvent;
import CQRS.CommandsApi.event.UpdateUserEvent;
import CQRS.CommandsApi.repository.UserRepo;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl{

    private UserRepo userRepo;

    public UserCommandServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @EventHandler
    public void on(CreateUserEvent event){
        System.out.println("helllo service create handler");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event,userEntity);
        userRepo.save(userEntity);
    }

    @EventHandler
    public void on(UpdateUserEvent event){
        System.out.println("helllo service update hander");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event,userEntity);
        userRepo.save(userEntity);
    }
}
