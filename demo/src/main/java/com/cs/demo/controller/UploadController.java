package com.cs.demo.controller;

import com.cs.demo.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    /**
     * 没有校验文件类型
     * @param file
     * @return
     */
    @PostMapping("/upload/file/type1")
    public Result singleFileUpload1(MultipartFile file) {
        Result res;
        if (file == null) {
            System.out.println("文件为空");
            res = new Result(1, "failure", "文件为空，请重新上传");
            return res;
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            return getResult(file, bytes, path);
        } catch (IOException e) {
            e.printStackTrace();
            res = new Result(0, "failure", "文件上传失败");
            return res;
        }
    }

    private Result getResult(MultipartFile file, byte[] bytes, Path path) throws IOException {
        Result res;
        Files.write(path, bytes);
        System.out.println("路径：" + path);
        String contentType = file.getContentType();
        System.out.println("文件类型：" + contentType);
        System.out.println("文件写入成功！");
        res = new Result(1, "success", "文件上传成功");
        return res;
    }

    @PostMapping("/upload/file/type2")
    public Result singleFileUpload2(MultipartFile file) {

        Result res;
        System.out.println(file);

        if(file == null) {
            System.out.println("文件为空");
            res = new Result(1, "failure", "文件为空，请重新上传");
            return res;
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }

            //检查是否是图片
            BufferedImage bi = ImageIO.read(file.getInputStream());
            if(bi == null){
                res = new Result(1, "failure", "文件不是图片");
                return  res;
            }
            //文件写入指定路径
            return getResult(file, bytes, path);
        } catch (IOException e) {
            e.printStackTrace();
            res = new Result(0, "failure", "文件上传失败");
            return res;
        }
    }
}
