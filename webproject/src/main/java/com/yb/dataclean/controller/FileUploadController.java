package com.yb.dataclean.controller;

import com.yb.dataclean.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Controller
public class FileUploadController {
    @PostMapping(value="/uploadfile")
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {

        String contentType = file.getContentType();   //文件类型
        String fileName = file.getOriginalFilename();  //文件名字

        //文件存放路径
        String filePath = "C:\\Users\\79441\\Desktop\\webproject\\upload\\";

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 返回图片的存放路径
        return filePath;
    }
}
