package com.example.memes.dao.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "collect")
public class CollectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coid;

    @Column
    private Long pid;

    @Column
    private Long uid;
}

