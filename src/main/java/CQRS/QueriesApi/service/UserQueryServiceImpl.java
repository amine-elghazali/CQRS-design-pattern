package CQRS.QueriesApi.service;

import CQRS.CommandsApi.entity.UserEntity;
import CQRS.CommandsApi.repository.UserRepo;
import CQRS.QueriesApi.query.GetUsersQuery;

import org.axonframework.queryhandling.QueryHandler;

import java.util.List;

public class UserQueryServiceImpl {
    private UserRepo userRepo;

    public UserQueryServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @QueryHandler
    public List<UserEntity> handle(GetUsersQuery getUsersQuery){
        return userRepo.findAll();
    }
}
