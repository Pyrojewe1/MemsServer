package com.example.memes.controller;

import com.example.memes.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value = "/CollectController")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @ResponseBody
    @PostMapping(value = "/addCollect")
    public int addCollect(@RequestParam Long uid , @RequestParam Long pid){
        return collectService.addCollect(uid,pid);
    }
}
