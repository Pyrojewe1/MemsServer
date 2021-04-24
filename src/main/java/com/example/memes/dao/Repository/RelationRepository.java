package com.example.memes.dao.Repository;

import com.example.memes.dao.Entity.RelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface RelationRepository extends JpaRepository<RelationEntity,Long> {
    @Query(value = "select * from relation where pid = ?1", nativeQuery = true )
    List<RelationEntity> findRelationEntitiesByPid(Long pid);

    @Query(value = "select * from relation where  cid = ?1",nativeQuery = true)
    List<RelationEntity> findRelationEntitiesByCid(Long Cid);

    @Transactional
    @Modifying
    @Query(value = "insert into relation (pid,cid) values (?1,?2)",nativeQuery = true)
    int addRelation(Long pid,Long cid);

}
