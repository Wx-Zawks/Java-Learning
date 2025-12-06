package demo.zhouzhou.controller;

import demo.zhouzhou.pojo.Result;
import demo.zhouzhou.utils.AliyunOSSOperator;
import demo.zhouzhou.utils.AliyunOSSProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
//        log.info("上传文件: {}, {}, {}, {}", name, age, file.getOriginalFilename(), file.getSize());
//        String originalFilename = file.getOriginalFilename();
//        String newFilename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
//        file.transferTo(new File("E:\\JavaProject\\JavaWeb\\DeptManageStystem\\DeptManageSystem\\src\\main\\resources\\" + newFilename));
//        return Result.success();

        //阿里云OSS上传文件
        log.info("阿里云OSS上传文件:{}",file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        return Result.success(url);
    }
}
