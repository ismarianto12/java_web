package com.restapiSiswa.restapi.controllers;

import com.restapiSiswa.restapi.models.Siswa;
import com.restapiSiswa.restapi.models.Upload;
import com.restapiSiswa.restapi.repo.SiswaRep;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class WelcomeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SiswaRep siswarepo;


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String WelcomData(@RequestParam(name = "string", required = false) String para) {
        return "STING REPS";
    }

    @RequestMapping(value = "/siswa", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> RestApi() {
        List<Siswa> data = siswarepo.finDataByname();
        Map<String, Object> resp = new HashMap<>();
        resp.put("msg", "Data Response Success");
        resp.put("data", data);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "/updatedata/{id}", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> updateDataSiswa(@PathParam("id") String id) throws Exception {
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("Data", "exaple data v1");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Throwable e) {
            resp.put("messgaes", e.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/siswa/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> detaildata(@PathVariable("id") Long id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            List<Siswa> detaildata = siswarepo.findByIdData(id);
            resp.put("Data", detaildata);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            resp.put("resp", e.getMessage());
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/uploadfile")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("judul") String judul
    ) throws Exception {
        if (file.isEmpty() && judul.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String filext = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String list[] = {"png", "bmp", "jpg"};

        if (!Arrays.stream(list).anyMatch(ext -> ext.equals(filext))) {
            return ResponseEntity.badRequest().body("Only PNG files are allowed" + filext);
        }
        String newFileName = "prefix_" + System.currentTimeMillis() + "_" + fileName;
        String uploadDir = "./uploads/";
        Path uploadPath = Paths.get(uploadDir);
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(newFileName);
            file.transferTo(filePath);
            return ResponseEntity.ok("File uploaded successfully. New file name: " + newFileName);

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading the file" + e.getMessage());
        }
    }


    @RequestMapping(value = "/deletesiswa/{id}", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        try {
            Map<String, Object> resp = new HashMap<>();
            List<Map<String, Object>> detaildata = jdbcTemplate.queryForList("delete from siswa where id= ?", id);
            resp.put("Data", "Berhasl hapus data");
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
        }
        return null;
    }

    @RequestMapping(value = "/master/guru", method = RequestMethod.GET)
    public String masterGuru(Model model) {
        model.addAttribute("title", "Master data");
        return "/master/guru";
    }

    @RequestMapping(value = "/master/siswa", method = RequestMethod.GET)
    public String masterSiswa(Model model) {
        model.addAttribute("title", "Master data");
        return "/master/siswa";
    }

    @RequestMapping(value = "/master/mapel", method = RequestMethod.GET)
    public String masterMapel(Model model) {
        model.addAttribute("title", "Master data");
        return "/master/mapel";
    }

}
