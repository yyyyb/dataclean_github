package com.yb.dataclean.controller;

import com.yb.dataclean.domain.Job;
import com.yb.dataclean.domain.Result;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExcuteJobController {
    @PostMapping(value = "/excutejob")
    public Result excuteJob(Job job) throws IOException {
        String filePath = job.getAlgfile();
        String csvPath = job.getDatafile();
        filePath = "C:\\Users\\79441\\Desktop\\webproject\\upload\\" + filePath;
        csvPath ="C:\\Users\\79441\\Desktop\\webproject\\upload\\"+csvPath;
        String cmd ="cmd /c start java -Dcsvfile=" + "\"" + csvPath + "\""  + " " +  "-Dfile.encoding=utf-8 -jar "  + "\"" + filePath + "\"";
        System.out.println(cmd);
        Runtime.getRuntime().exec(cmd);
        return ResultUtil.success("执行成功");
    }
}
