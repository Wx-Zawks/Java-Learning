package demo.zhouzhou.controller;

import demo.zhouzhou.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("上传文件: {}, {}, {}, {}", name, age, file.getOriginalFilename(), file.getSize());
        String originalFilename = file.getOriginalFilename();
        String newFilename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File("E:\\JavaProject\\JavaWeb\\DeptManageStystem\\DeptManageSystem\\src\\main\\resources\\" + newFilename));
        return Result.success();
    }
}
