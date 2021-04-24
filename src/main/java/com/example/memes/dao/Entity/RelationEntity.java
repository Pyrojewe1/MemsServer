package com.example.memes.dao.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "relation")
public class RelationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long rid;

    @Column
    private Long pid;

    @Column
    private Long cid;
}

