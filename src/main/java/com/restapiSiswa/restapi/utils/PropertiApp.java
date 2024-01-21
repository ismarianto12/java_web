package com.restapiSiswa.restapi.utils;

import java.util.ArrayList;
import java.util.List;

public class PropertiApp {
     public static List<String> jenisArtikel(){
        List<String> param = new ArrayList<>();
        param.add(1,"Publish");
        param.add(2,"UnPublish");
        return param;
    }
}
