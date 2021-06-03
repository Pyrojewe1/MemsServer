package com.example.memes.dao.Repository;

import com.example.memes.dao.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query(value = "select uid from user where username = ?1 and password =?2",nativeQuery = true)
    Long verifyUser(String username,String password);
}
