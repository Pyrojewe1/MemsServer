package com.example.memes.service;

import com.example.memes.dao.Repository.CollectRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectRepository collectRepository;

    public List<Long> findPicByUid(Long uid){
        return collectRepository.findPicByUid(uid);
    }

    public int addCollect(Long uid ,Long pid){
        return collectRepository.addCollect(uid,pid);
    }
}
