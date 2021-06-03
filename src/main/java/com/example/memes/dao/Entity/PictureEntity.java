package com.example.memes.dao.Entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "picture")
public class PictureEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pid;

    @Column
    private String pname;

    @Column
    private int download = 0;

    @Column(columnDefinition="mediumblob", nullable=true)
    private byte[] pdetails;


}
