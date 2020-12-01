package com.example.welcome1.controller;


import com.example.welcome1.entity.Student;
import com.example.welcome1.response.ResponseResult;
import com.example.welcome1.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/Info")
    public ResponseResult studentInfo(String sid){
        Student getstu = studentService.findBySid(sid);
        if(null==getstu){
            return ResponseResult.FAILED("获取学生信息失败");
        }else{
            return ResponseResult.SUCCESS("获取学生信息成功").setData(getstu);

        }
    }
    @RequestMapping("/InfoUpdate")
    public ResponseResult studentInfoUpdate(Student student){
        int setstu = studentService.setStudent(student);
        if(setstu==0){
            return ResponseResult.FAILED("更改学生信息失败");
        }else{
            return ResponseResult.SUCCESS("更改学生信息成功").setData(setstu);
        }
    }


}
