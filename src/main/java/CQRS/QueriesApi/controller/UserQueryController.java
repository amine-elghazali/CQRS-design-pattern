package CQRS.QueriesApi.controller;

import CQRS.CommandsApi.entity.UserEntity;
import CQRS.QueriesApi.query.FindUserQuery;
import CQRS.QueriesApi.query.GetUsersQuery;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/query/")
public class UserQueryController {

    private QueryGateway queryGateway;

    public UserQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }

    @GetMapping("users")
    public List<UserEntity> getAllUsers(){

        GetUsersQuery getUsersQuery = new GetUsersQuery();
        List<UserEntity> users = queryGateway.query(getUsersQuery, ResponseTypes.multipleInstancesOf(UserEntity.class)).join();

        return users;
    }

    @GetMapping("user/{id}")
    public UserEntity getOneUser(@PathVariable("id") UUID id){

        FindUserQuery findUserQuery = new FindUserQuery(id);
        UserEntity user = queryGateway.query(findUserQuery,UserEntity.class).join();
        return user;
    }
}
