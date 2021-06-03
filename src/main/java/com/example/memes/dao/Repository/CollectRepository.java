package com.example.memes.dao.Repository;

import com.example.memes.dao.Entity.CollectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectRepository extends JpaRepository<CollectEntity,Long> {
    @Query(value = "select pid from collect where uid=?1",nativeQuery = true)
    List<Long> findPicByUid(Long uid);

    @Query(value = "insert into collect (uid,pid) values (?1,?2)",nativeQuery = true)
    int addCollect(Long uid , Long pid);
}
