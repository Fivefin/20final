package com.example.welcome1.service;

import com.example.welcome1.entity.Notice;

import java.util.Date;
import java.util.List;

public interface NoticeService {

    int addNotice(Notice notice);

    int deleteNotice(String title);

    List<Notice> findAllNotice();

    int updateNotice(Notice notice);

    List<Notice> findAllByntype(String ntype);

    List<Notice> findAllByntime(Date ntime);
}
