package com.restapiSiswa.restapi.repo;

import com.restapiSiswa.restapi.models.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface LoginRep extends CrudRepository<Login, Long> {

    @Query(value = "select * from users where username = ?",nativeQuery = true)
    List<Login> loginApp(String username);

    @Query(value = "update users set username = ?, password = ? ",nativeQuery = true)
    List<Login> changePassw(String username, String password);

    @Query(value = "select * from users where id = ?",nativeQuery = true)
    List<Login> getProfile(String id);

    @Query(value = "update users set password = ? where username = ?",nativeQuery = true)
    List<Login> updatePassword(String username,String password);
}
