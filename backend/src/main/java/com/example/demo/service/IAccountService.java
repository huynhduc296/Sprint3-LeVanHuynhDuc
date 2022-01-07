package com.example.demo.service;


import com.example.demo.entity.account.Account;

public interface IAccountService {
    //PhucNK
    Account findAccountById(Integer AccountId);

    //PhucNK
    void save(Account account);

    //NhatDV
    void editPassword(Integer id, String password);

    //NhatDV
    Account getAccountById(Integer id);

    //NhatDV
    Account getAccountByName(String name);

    //DungNM 21/11
    Account findByUsername(String username);

    //DungNM 21/11
    void signUp(Account account);

    //DungNM 21/11
    Account findAccountByEmail(String email);
}
