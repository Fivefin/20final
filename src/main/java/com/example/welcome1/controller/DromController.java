package com.example.welcome1.controller;


import com.example.welcome1.entity.Drom;
import com.example.welcome1.response.ResponseResult;
import com.example.welcome1.service.DromService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("drom")
public class DromController {

    @Resource
    private DromService dromService;
    @RequestMapping("/Info")
    public ResponseResult classInfo(String did){
        Drom getdro = dromService.findByDid(did);
        if(null==getdro){
            return ResponseResult.FAILED("获取班级信息失败");
        }else{
            return ResponseResult.SUCCESS("获取班级信息成功").setData(getdro);

        }
    }
}
