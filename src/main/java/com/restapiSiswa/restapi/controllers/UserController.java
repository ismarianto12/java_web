package com.restapiSiswa.restapi.controllers;

import com.restapiSiswa.restapi.models.Login;
import com.restapiSiswa.restapi.repo.LoginRep;
import com.restapiSiswa.restapi.repo.SiswaRep;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private SiswaRep siswaRep;
    @Autowired
    private LoginRep loginRepo;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginApp(@RequestBody Login paramlog, HttpSession session) {
        Map<String, Object> res = new HashMap<>();
        try {
            List<Login> user = loginRepo.loginApp(paramlog.getUsername());

            BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
            String encpPasswd = encode.encode(paramlog.getPassword());

            if (user.isEmpty()) {
                res.put("response", "login gagal");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
            Login fuser = user.get(0);
            String nama = (String) user.get(0).getName();
            String storedPassword = fuser.getPassword();
            boolean matchPas = encode.matches(storedPassword,encpPasswd);
            if (!user.isEmpty()) {
                session.setAttribute("username", user.get(0).getUsername());
                session.setAttribute("password", user.get(0).getUsername());
                session.setAttribute("nama", nama);
                res.put("response", "login berhasil");
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {

                res.put("response", "login gagal");
                res.put("request", storedPassword);
                res.put("match", matchPas);
//                res.put()

                res.put("Data", user);

                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
            }
        } catch (Throwable e) {
            res.put("response", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/change_pass", method = RequestMethod.GET)
    public ResponseEntity<?> ChangePassword(@RequestParam Login login) throws Exception {

        Map<String, Object> resp = new HashMap<>();
        try {
            String loginparam = login.getPassword();
            String levelid = "";
            switch (loginparam) {
                case "1": //
                    levelid = "1";
                    break;
                default:
                    levelid = "undefined";
                    break;
            }

            if (login.getPassword().isEmpty()) {
                System.out.println(levelid);
                resp.put("error", "invalid parameter");
                return new ResponseEntity<>(resp, HttpStatus.OK);
            }
            String password = login.getPassword();
            String username = login.getUsername();
            List<Login> data = loginRepo.changePassw(username, password);
            resp.put("messagees", "data berhasil di simpan");
            resp.put("data", data);
            return new ResponseEntity<>(resp, HttpStatus.OK);

        } catch (Exception e) {
            resp.put("messagees", "gagal di simpan");
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
    }
}

