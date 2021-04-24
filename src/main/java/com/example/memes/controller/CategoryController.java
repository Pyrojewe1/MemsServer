package com.example.memes.controller;

import com.example.memes.dao.Entity.CategoryEntity;
import com.example.memes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Synchronization;

@CrossOrigin
@Controller
@RequestMapping(value = "/CategoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @PostMapping(value = "/findCategoryByCid" )
    public  CategoryEntity findCategoryByCid(@RequestParam Long cid )  {
        return categoryService.findCategory(cid);
    }

}
