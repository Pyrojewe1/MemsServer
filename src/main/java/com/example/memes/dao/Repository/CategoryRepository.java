package com.example.memes.dao.Repository;

import com.example.memes.dao.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    @Query
    CategoryEntity findCategoryEntityByCid(Long cid);

}
