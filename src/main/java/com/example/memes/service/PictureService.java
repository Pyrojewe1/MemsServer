package com.example.memes.service;

import com.example.memes.dao.Entity.PictureEntity;
import com.example.memes.dao.Repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public List<PictureEntity> findAllPicture(){
        return pictureRepository.findAllPicture();
    }

    public PictureEntity findPictureByPid(Long pid){
        return pictureRepository.findPictureEntityByPid(pid);
    }

    public int deletePictureByPid(Long pid){
        return pictureRepository.deletePictureByPid(pid);
    }

    public int nextNum(){
        return pictureRepository.countNum()+1;
    }

    public int addPicture(PictureEntity pictureEntity){
        return pictureRepository.addPicture(pictureEntity.getPname(),pictureEntity.getPdetails());
    }

    public int updateDownload(Long pid){
        return pictureRepository.updateDownload(pid);
    }

    public List<PictureEntity> queryPicByDownload(){
        return pictureRepository.queryPicByDownload();
    }
}
