package com.example.welcome1.controller;

import com.example.welcome1.entity.Class;
import com.example.welcome1.response.ResponseResult;
import com.example.welcome1.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("class")
public class ClassController {

    @Resource
    private ClassService classService;

    @GetMapping("/info")
    public ResponseResult classInfo(String cid){
        Class getcls = classService.findByCid(cid);
        if(null==getcls){
            return ResponseResult.FAILED("获取班级信息失败");
        }else{
            return ResponseResult.SUCCESS("获取班级信息成功").setData(getcls);

        }
    }
    @PostMapping("/add")
    public ResponseResult classAdd(Class _class){
        int classDB = classService.addClass(_class);
        if(classDB==0){
            return ResponseResult.FAILED("添加班级失败");
        }else{
            return ResponseResult.SUCCESS("添加班级成功").setData(_class);

        }
    }

    @PostMapping("/delete")
    public ResponseResult classDelete(String cid){
        int classDB = classService.deleteClass(cid);
        if(classDB==0){
            return ResponseResult.FAILED("删除班级失败");
        }else{
            return ResponseResult.SUCCESS("删除班级成功").setData(cid);

        }
    }

    @PostMapping("/update")
    public ResponseResult classUpdate(Class _class){
        int classDB = classService.updateClass(_class);
        if(classDB==0){
            return ResponseResult.FAILED("修改班级失败");
        }else{
            return ResponseResult.SUCCESS("修改班级成功").setData(_class);
        }
    }

    @GetMapping("/getclasses")
    public ResponseResult getCls(String ccollege){
        List<Class> classes= classService.findByCcollege(ccollege);
        if(null==classes){
            return ResponseResult.FAILED("获取班级失败");
        }else{
            return ResponseResult.SUCCESS("获取班级成功").setData(classes);
        }
    }


}
