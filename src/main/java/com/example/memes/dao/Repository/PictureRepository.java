package com.example.memes.dao.Repository;

import com.example.memes.dao.Entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PictureRepository extends JpaRepository<PictureEntity,Long> {
    @Query
    PictureEntity findPictureEntityByPid(Long pid);

    @Transactional
    @Modifying
    @Query(value = "insert into picture (pname,pdetails) values (?1,?2)",nativeQuery = true)
    int addPicture(String pname,byte[] pdetails);

    @Transactional
    @Modifying
    @Query(value = "delete from picture where pid=?1",nativeQuery = true)
    int deletePictureByPid(Long pid);

   @Query(value = "select * from picture",nativeQuery = true)
    List<PictureEntity> findAllPicture();

   @Query(value = "select count (*) from picture",nativeQuery = true)
    int countNum();



}
