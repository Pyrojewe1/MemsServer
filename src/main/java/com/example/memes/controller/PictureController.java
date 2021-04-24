package com.example.memes.controller;

import com.example.memes.dao.Entity.PictureEntity;
import com.example.memes.dao.Entity.RelationEntity;
import com.example.memes.service.PictureService;
import com.example.memes.service.RelationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@CrossOrigin
@Controller
@RequestMapping (value = "/picController")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private RelationService relationService;
    private static final String path = "c:/Users/87212/Desktop/memes/test/";
    private static final ExecutorService CACHED_THREAD_POOL = Executors.newCachedThreadPool();

    @ResponseBody
    @PostMapping(value = "/addPic1" )
    public synchronized int addPicture1(@RequestParam MultipartFile file ) throws IOException {
        System.out.println("添加图片");
        String pname = "pic" + pictureService.nextNum();
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setPname(pname);
        pictureEntity.setPdetails(file.getBytes());
        String picPath = path + pname + ".jpg";
        File file1 = new File(picPath);
        file.transferTo(file1);
        try {
            Process process = Runtime.getRuntime().exec("python C:/Users/87212/Desktop/models-master/research/object_detection/recognize.py ");
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            InputStreamReader inputStreamReader = new InputStreamReader(process.getErrorStream());
            BufferedReader bufferedReader = new BufferedReader(ir);
            BufferedReader bufferedReader1 = new BufferedReader((inputStreamReader));

            CACHED_THREAD_POOL.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    String result = "";
                    while((result = bufferedReader.readLine())!=null) {
                        System.out.println(result);
                        relationService.addRelation((long)pictureService.nextNum(),Long.valueOf(result));
                    }
                    bufferedReader.close();
                    ir.close();
                }
            });
//            new Thread(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    String result = "";
//                    while((result = bufferedReader.readLine())!=null) {
//                        System.out.println(result);
//                        relationService.addRelation((long)pictureService.nextNum(),Long.valueOf(result));
//                    }
//                    bufferedReader.close();
//                    ir.close();
//                }
//            }).start();

            CACHED_THREAD_POOL.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    String result = "";
                    while((result = bufferedReader1.readLine())!=null) {
                        //todo
                    }
                    System.out.println("run run run4");
                    bufferedReader1.close();
                    inputStreamReader.close();
                }
            });
//            new Thread(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    String result = "";
//                    while((result = bufferedReader1.readLine())!=null) {
//                        //todo
//                    }
//                    System.out.println("run run run4");
//                    bufferedReader1.close();
//                    inputStreamReader.close();
//                }
//            }).start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("调用python脚本并读取结果时出错：" + e.getMessage());
        }
        System.out.println("结束add");
        return pictureService.addPicture(pictureEntity);
    }

    @ResponseBody
    @PostMapping(value = "/addPic" )
    public synchronized int addPicture(@RequestParam MultipartFile file ) throws IOException {
        System.out.println("添加图片");
        String pname = "pic" + pictureService.nextNum();
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setPname(pname);
        pictureEntity.setPdetails(file.getBytes());
        String picPath = path + pname + ".jpg";
        File file1 = new File(picPath);
        file.transferTo(file1);
        Socket socket = new Socket("127.0.0.1",12345);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("recognize");
        bufferedWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        boolean flag =true;
        while(flag){
            String result = "";
            while((result = bufferedReader.readLine())!=null) {
                System.out.println(result);
                relationService.addRelation((long)pictureService.nextNum(),Long.valueOf(result));
                flag = false;
            }
            bufferedReader.close();
        }
        return pictureService.addPicture(pictureEntity);
    }


    @GetMapping(value = "/addPic" )
    public synchronized void addPicture()  {
        try {
            Process process = Runtime.getRuntime().exec("python C:/Users/87212/Desktop/models-master/research/object_detection/recognize.py ");
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            InputStreamReader inputStreamReader = new InputStreamReader(process.getErrorStream());
            BufferedReader bufferedReader = new BufferedReader(ir);
            BufferedReader bufferedReader1 = new BufferedReader((inputStreamReader));
            CACHED_THREAD_POOL.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    String result = "";
                    while((result = bufferedReader.readLine())!=null) {
                        System.out.println(result);

                    }
                    bufferedReader.close();
                    ir.close();
                }
            });

            CACHED_THREAD_POOL.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    String result = "";
                    while((result = bufferedReader1.readLine())!=null) {
                        //todo
                    }
                    System.out.println("run run run4");
                    bufferedReader1.close();
                    inputStreamReader.close();
                }
            });

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("调用python脚本并读取结果时出错：" + e.getMessage());
        }
    }

    @SneakyThrows
    @ResponseBody
    @GetMapping(value = "/findPic" )
    public List<PictureEntity> findPic(){
        List<PictureEntity> pictureEntityList = new ArrayList<>();
        PictureEntity pictureEntity = pictureService.findPictureByPid((long)1);
        PictureEntity pictureEntity1 = pictureService.findPictureByPid((long)2);
        pictureEntityList.add(pictureEntity);
        pictureEntityList.add(pictureEntity1);
        String picPath = path + "123123"  + ".jpg";
        File file1 = new File(picPath);
        FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(file1);
        fileImageOutputStream.write(pictureEntity.getPdetails(),0,pictureEntity.getPdetails().length);
        fileImageOutputStream.close();
        System.out.println("输出完成");
        return pictureEntityList;
    }

    @ResponseBody
    @GetMapping(value = "/findAllPic" )
    public List<PictureEntity> findAllPic(){
        System.out.println("查询全部图片");
        return pictureService.findAllPicture();
    }

    @ResponseBody
    @PostMapping(value = "/findPicByCid" )
    public List<PictureEntity> findPicByCid(@RequestParam String cid){
        List<PictureEntity> pictureEntityList = new ArrayList<>();
        List<RelationEntity> relationEntityList ;
        System.out.println(cid+"************************************************************");
        relationEntityList = relationService.findAllRelationsByCid(Long.valueOf(cid));
        for(RelationEntity relationEntity : relationEntityList){
            pictureEntityList.add(pictureService.findPictureByPid(relationEntity.getPid()));
        }
        return pictureEntityList;
    }


}
