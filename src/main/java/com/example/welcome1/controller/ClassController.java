package com.example.welcome1.controller;

import com.example.welcome1.entity.Class;
import com.example.welcome1.response.ResponseResult;
import com.example.welcome1.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("class")
public class ClassController {

    @Resource
    private ClassService classService;

    @RequestMapping("/Info")
    public ResponseResult classInfo(String cid){
        Class getcls = classService.findByCid(cid);
        if(null==getcls){
            return ResponseResult.FAILED("获取班级信息失败");
        }else{
            return ResponseResult.SUCCESS("获取班级信息成功").setData(getcls);

        }
    }
    @RequestMapping("/add")
    public ResponseResult classAdd(Class _class){
        int classDB = classService.addClass(_class);
        if(classDB==0){
            return ResponseResult.FAILED("添加班级失败");
        }else{
            return ResponseResult.SUCCESS("添加班级成功").setData(_class);

        }
    }

    @RequestMapping("/delete")
    public ResponseResult classDelete(String cid){
        int classDB = classService.deleteClass(cid);
        if(classDB==0){
            return ResponseResult.FAILED("删除班级失败");
        }else{
            return ResponseResult.SUCCESS("删除班级成功").setData(cid);

        }
    }
}
