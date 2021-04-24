package com.example.memes.service;

import com.example.memes.dao.Entity.PictureEntity;
import com.example.memes.dao.Entity.RelationEntity;
import com.example.memes.dao.Repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationService {
    @Autowired
    private RelationRepository relationRepository;

    public List<RelationEntity> findAllRelationsByPid(Long pid){
        return relationRepository.findRelationEntitiesByPid(pid);
    }

    public List<RelationEntity> findAllRelationsByCid(Long Cid){
        return relationRepository.findRelationEntitiesByCid(Cid);
    }

    public int addRelation(Long pid,Long cid){
        return relationRepository.addRelation(pid,cid);
    }
}
