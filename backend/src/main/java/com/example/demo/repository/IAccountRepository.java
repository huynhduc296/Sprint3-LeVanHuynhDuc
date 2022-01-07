package com.example.demo.repository;


import com.example.demo.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "select * from account join employee on account.accountId=employee.accountId where account.accountId=?1", nativeQuery = true)
    Account findAccountById(Integer AccountId);

    //    edit password by Nhật
    @Modifying
    @Query(value = "update account set account_password = ?2 where (account_id = ?1);", nativeQuery = true)
    void editPassword(Integer id, String password);

    // Xem thông tin user by Nhật
    @Query(value = "select *" +
            "from account a " +
            " where a.account_id =?1", nativeQuery = true)
    Account getAccountById(@Param("id") Integer id);

    // NhatDV getAccountByName
    @Query(value = "select a.account_id,a.account_username,a.account_password,a.active_flag,a.delete_flag,a.email \n" +
            "from account a \n" +
            "where a.account_username= ?1", nativeQuery = true)
    Account getAccountByName(@Param("name") String name);

    //DungNM - Query account with username to verify httpBasic
    @Query(value = "select " +
            "account_id, email, account_password, account_username, delete_flag, active_flag " +
            "from account a " +
            "where a.account_username= ?1", nativeQuery = true)
    Account findAccountByUsername(String username);

    //DungNM - Query account with email
    @Query(value = "select " +
            "account_id, email, account_password, account_username, delete_flag, active_flag " +
            "from account a " +
            "where a.email = ?1", nativeQuery = true)
    Account findAccountByEmail(@Param("account_email") String email);

    //DungNM - insert account but not active
    @Modifying
    @Query(value = "insert into account (account_username, account_password, email, delete_flag, active_flag) " +
            "values (?1, ?2, ?3, 0, 0)", nativeQuery = true)
    void signUpAccount(@Param("account_username") String username, @Param("account_password") String password, @Param("email") String email);

    //DungNM - set role user cho tai khoan vua moi dang ky
    @Modifying
    @Query(value = "insert into account_role (account_id, role_id) values(?1, 2)", nativeQuery = true)
    void setRoleForUser(@Param("account_id") int idOfAccount);

    //DungNM - Kích hoạt tài khoản sau khi xác minh qua gmail
    @Modifying
    @Query(value = "update account set active_flag = 1 where email = ?1", nativeQuery = true)
    void enableActiveAccount(@Param("email") String email);
}
