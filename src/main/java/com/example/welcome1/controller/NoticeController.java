package com.example.welcome1.controller;


import com.example.welcome1.entity.Notice;
import com.example.welcome1.response.ResponseResult;
import com.example.welcome1.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @RequestMapping("/add")
    public ResponseResult addNotice(Notice notice){
        int addnum = noticeService.addNotice(notice);
        if(addnum!=0){
            return ResponseResult.SUCCESS("公告发布成功").setData(notice);
        }else{
            return ResponseResult.FAILED("公告发布失败").setData(notice);
        }
    }

    @RequestMapping("/delete")
    public ResponseResult deleteNotice(String title){
        int delnum = noticeService.deleteNotice(title);
        if(delnum==0){
            return ResponseResult.FAILED("删除失败");
        }else{
            return ResponseResult.SUCCESS("公告删除成功").setData(delnum);
        }
    }

    @RequestMapping("/update")
    public ResponseResult updateNotice(Notice notice){
        int updnum = noticeService.updateNotice(notice);
        if(updnum!=0){
            return ResponseResult.SUCCESS("公告更新成功").setData(notice);
        }else{
            return ResponseResult.FAILED("公告更新成功").setData(null);
        }
    }

    @RequestMapping("/findAll")
    public ResponseResult findAllNotice(){
        List<Notice> allNotice = noticeService.findAllNotice();
        if(null==allNotice){
            return ResponseResult.FAILED("暂无公告");
        }else{
            return ResponseResult.SUCCESS("公告获取成功").setData(allNotice);
        }
    }

    @RequestMapping("/findAllByntype")
    public ResponseResult findAllByntype(String ntype){
        List<Notice> allNotice = noticeService.findAllByntype(ntype);
        if(null==allNotice){
            return ResponseResult.FAILED("暂无公告");
        }else{
            return ResponseResult.SUCCESS("公告获取成功").setData(allNotice);
        }
    }

    @RequestMapping("/findAllByntime")
    public ResponseResult findAllByntime(Date ntime){
        List<Notice> allNotice = noticeService.findAllByntime(ntime);
        if(null==allNotice){
            return ResponseResult.FAILED("暂无公告");
        }else{
            return ResponseResult.SUCCESS("公告获取成功").setData(allNotice);
        }
    }




}
