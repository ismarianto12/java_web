package com.restapiSiswa.restapi.repo;

import com.restapiSiswa.restapi.models.Login;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import HttpS
@Repository
public class UserDaoImpl {

    @Autowired
    private EntityManager em;

    public Login save(Login user, HttpSession session) {
        session.setAttribute("username","test");
        return user;
    }

}