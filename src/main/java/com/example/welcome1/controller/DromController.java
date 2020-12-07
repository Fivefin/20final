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

    @RequestMapping("/info")
    public ResponseResult dromInfo(String did){
        Drom getdro = dromService.findByDid(did);
        if(null==getdro){
            return ResponseResult.FAILED("获取宿舍信息失败");
        }else{
            return ResponseResult.SUCCESS("获取宿舍信息成功").setData(getdro);

        }
    }

    @RequestMapping("/update")
    public ResponseResult dromUpdate(Drom drom){
        int dromDB=dromService.updateDrom(drom);
        if(dromDB==0){
            return ResponseResult.FAILED("修改宿舍信息失败");
        }else{
            return ResponseResult.SUCCESS("修改宿舍信息成功").setData(drom);
        }
    }

    @RequestMapping("/add")
    public ResponseResult dromAdd(Drom drom){
        int dromDB=dromService.addDrom(drom);
        if(dromDB==0){
            return ResponseResult.FAILED("添加宿舍失败");
        }else{
            return ResponseResult.SUCCESS("添加宿舍成功").setData(drom);
        }
    }
}
