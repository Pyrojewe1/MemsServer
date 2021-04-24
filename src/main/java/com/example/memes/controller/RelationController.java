package com.example.memes.controller;

import com.example.memes.dao.Entity.RelationEntity;
import com.example.memes.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/RelationController")
public class RelationController {
    @Autowired
    private RelationService relationService;

    @PostMapping(value = "/findAllRelationsByPid")
    public List<RelationEntity> findAllRelationsByPid(Long pid){
        return relationService.findAllRelationsByPid(pid);
    }


}
