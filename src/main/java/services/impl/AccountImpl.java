package services.impl;

import jakarta.inject.Inject;
import models.Account;
import repository.AccountRepository;
import services.AccountService;

import java.util.List;

public class AccountImpl implements AccountService {
    @Inject
    private AccountRepository repository;

    @Override
    public void create(Account account){

    }

    @Override
    public List<Account> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(String id) {

    }


}
