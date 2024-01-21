package com.restapiSiswa.restapi.controllers;

import com.restapiSiswa.restapi.models.Login;
import com.restapiSiswa.restapi.repo.LoginRep;
import com.restapiSiswa.restapi.utils.PropertiApp;
import org.codehaus.groovy.runtime.metaclass.MetaMethodIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
public class AdminpanelController {

    @Autowired
    LoginRep loginrepo;

    @RequestMapping(value = "/app/auth", method = RequestMethod.GET)
    public String loginApp(@RequestParam("") String page, Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
//        Byte byte =  (byte) new Byte();
        Byte data = 10;
        if (username != null) {
            return "redirect:/admin/home";
        }
        model.addAttribute("page", page);
        model.addAttribute("title", "Login Aplikasi");
        return "login";
    }

    @RequestMapping(value = "/testdash", method = RequestMethod.GET)
    public String appdas(HttpSession session, Model model) throws Exception {
        model.addAttribute("title", "Login Aplikasi");
        return "list";
    }

    private String testing(Integer paramdata) {
        var stat = (paramdata != null) ? String.valueOf(paramdata) : null;
        return stat;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String aplikasi(HttpSession session, Model model) throws Exception {

        String username = (String) session.getAttribute("username");

        System.out.println(username + "username nya");
        if (username != null && !username.isEmpty()) {
            model.addAttribute("userdata", username);
            model.addAttribute("title", "Welcome Admin Panel");
            return "admin/dashboard";
        } else {
            return "redirect:/app/auth?page=silahkan_login";
        }
    }

    @RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
    public String homeapp(Model model) {
        model.addAttribute("content", "dashboard_panel");
        return "template";
    }

    @RequestMapping(value = "/app/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("title", "Login Aplikasi");
        return "login";
    }

    @RequestMapping(value = "/admin/changepass", method = RequestMethod.GET)
    public String changePassw(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<Login> data = loginrepo.getProfile(username);
        String namanya = data.get(0).getUsername();
        model.addAttribute("nama", namanya);
        model.addAttribute("data", data);
        return "profilepass";
    }


    @RequestMapping(value = "/admin/userlist", method = RequestMethod.GET)
    public String userlist(Model model) {
        model.addAttribute("title", "List data user");
        return "admin/userlist";
    }




    private void UploadFile(@RequestParam("file") MultipartFile file)throws  Exception{
        try{

          String namafile   = file.getOriginalFilename();
          String extfile = StringUtils.getFilenameExtension(namafile);
          String list[] = {"png","bmp","png"};

          if(!Arrays.stream(list).anyMatch((ext)-> ext.contains(extfile))){
              new Exception("adsada");
          }


        }catch (Exception th){

        }
    }



    @RequestMapping(value = "/admin/api/passowrd", method = RequestMethod.POST)
    public ResponseEntity<?> gantiPass(@RequestParam Login login) throws Exception {
        Map<String, Object> restdata = new HashMap<>();
        try {

            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String username = login.getUsername();
            String password = bcrypt.encode(login.getPassword());
            var res = loginrepo.updatePassword(username, password);

            restdata.put("messages", "berhasil update");
            return new ResponseEntity<>(restdata, HttpStatus.OK);
        } catch (Exception e) {
            restdata.put("messages", e.getMessage());
            return new ResponseEntity<>(restdata, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/listsiswa",method =  RequestMethod.GET)
    public String listSiswa(Model model){
        model.addAttribute("title","List Data Siswa");
                return "admin/listsiswa";

    }
    @RequestMapping(value = "/listmapel",method =  RequestMethod.GET)
    public String listMapel(Model model){
        model.addAttribute("title","List Data Mata Pelajatan");
        return "admin/mapel";
    }

}
