package CQRS.QueriesApi.service;

import CQRS.CommandsApi.entity.UserEntity;
import CQRS.CommandsApi.repository.UserRepo;
import CQRS.QueriesApi.query.FindUserQuery;
import CQRS.QueriesApi.query.GetUsersQuery;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryServiceImpl {
    private UserRepo userRepo;

    public UserQueryServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @QueryHandler
    public List<UserEntity> handle(GetUsersQuery getUsersQuery){
        return userRepo.findAll();
    }

    @QueryHandler
    public UserEntity handle(FindUserQuery findUserQuery){
        return userRepo.findById(findUserQuery.getId()).get();
    }
}
