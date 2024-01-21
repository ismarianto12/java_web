package com.restapiSiswa.restapi.repo;

import com.restapiSiswa.restapi.models.Login;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
public interface GuruRepo extends CrudRepository<Login, Long> {

    @Query(value = "insert into guru set nama = ?", nativeQuery =true)
    public List<Login> inserGuru(String nama);


}
