package com.example.welcome1.dao;

import com.example.welcome1.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NoticeDao {
    //根据标题查找公告
    Notice findByTitle(String title);
    //添加公告
    int addNotice(Notice notice);
    //按标题删除公告
    int deleteNotice(String title);
    //修改公告
    int updateNotice(Notice notice);
    //获取所有公告
    List<Notice> findAllNotice();
    //按时间排序公告
    List<Notice> findAllByntime(Date ntime);
    //按类型排序公告
    List<Notice> findAllByntype(String ntype);
}
