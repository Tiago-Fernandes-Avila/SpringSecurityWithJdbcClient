package com.blog.tiago.authdemo.repository;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.blog.tiago.authdemo.domain.user.User;


@Repository
public class UserRepository {
    private static final String INSERT = "INSERT INTO tb_users(username, email, password) VALUES (?,?,?)";
    private static final String FindByEmail = "SELECT * FROM tb_users WHERE tb_users.email = ?";
    private static final String findByUserName = "SELECT * FROM tb_users WHERE tb_users.username = ?";

    private final JdbcClient jdbcClient;

    public UserRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }


    public Optional<User> findByEmail(String email) {
      return  jdbcClient.sql(FindByEmail)
        .param(email) //parametro da query
        .query(User.class) //indica a classe entidade
        .optional(); //para retornar em um optional poderia ser .list() para salvar uma lista caso fosse
        
        
    }

    public Optional<User> findByUserName(String username){
        return jdbcClient.sql(findByUserName)
        .param(username)
        .query(User.class)
        .optional();

    }

    public void add(User user) {
       long affected = jdbcClient.sql(INSERT)
        .param(user.username())
        .param(user.email())
        .param(user.password())
        .update();
        Assert.isTrue(affected == 1, "Error inserting user");
    }


}
