package com.restapiSiswa.restapi.repo;

import com.restapiSiswa.restapi.models.Siswa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface SiswaRep extends CrudRepository<Siswa,Long>{
    @Query(value = "select * from siswa order by id",nativeQuery = true)
    List<Siswa> finDataByname();
    @Query(value = "select * from siswa where id = ?",nativeQuery = true)
    List<Siswa>findByIdData(Long id);

    @Query(value= "delete from siswa where id= ? ",nativeQuery = true)
    List<Siswa> DeleteSiswaRec(Long id);

}
