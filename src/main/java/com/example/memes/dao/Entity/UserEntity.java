package com.example.memes.dao.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long uid;

    @Column(unique = true)
    private String username;

    @Column
    private String password;



}
