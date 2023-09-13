package services;

import models.Account;

import java.util.List;

public interface AccountService {
    void create(Account account);
    List<Account> getAll();
    void delete(String id);
}
