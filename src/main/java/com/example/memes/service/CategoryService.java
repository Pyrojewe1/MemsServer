package com.example.memes.service;

import com.example.memes.dao.Entity.CategoryEntity;
import com.example.memes.dao.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity findCategory(Long cid){
        return categoryRepository.findCategoryEntityByCid(cid);
    }
}
