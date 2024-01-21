package com.restapiSiswa.restapi.controllers;

import com.restapiSiswa.restapi.models.Siswa;
import com.restapiSiswa.restapi.repo.GuruRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class GuruController {

    @Autowired
    GuruRepo guruRepo;

    public ResponseEntity<?> insert(@RequestParam("nama") String nama, Siswa siswa) throws Exception {
        Map<String,Object> res = new HashMap<>();
         try{
             guruRepo.inserGuru(nama);
             res.put("messages","Berhasil");
             return new ResponseEntity<>(res, HttpStatus.OK);
         }catch (Exception e){
             res.put("messages",e.getMessage());
             return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
         }

    }
}
