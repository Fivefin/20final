package com.example.welcome1.service.impl;

import com.example.welcome1.dao.NoticeDao;
import com.example.welcome1.entity.Notice;
import com.example.welcome1.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

    @Resource
    private NoticeDao noticeDao;


    @Override
    public int addNotice(Notice notice) {
        Notice notice1 = noticeDao.findByTitle(notice.getTitle());
        if(null==notice1){
            int addnum = noticeDao.addNotice(notice);
            return addnum;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteNotice(String title) {
        Notice notice1 = noticeDao.findByTitle(title);
        if(null==notice1){
            return 0;

        }else{
            int deletenum = noticeDao.deleteNotice(title);
            return deletenum;
        }
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeDao.updateNotice(notice);
    }



    @Override
    public List<Notice> findAllNotice() {
        List<Notice> notices = noticeDao.findAllNotice();
        return notices;
    }

    @Override
    public List<Notice> findAllByntype(String ntype) {
        List<Notice> notices = noticeDao.findAllByntype(ntype);
        return notices;
    }


    @Override
    public List<Notice> findAllByntime(Date ntime) {
        List<Notice> notices = noticeDao.findAllByntime(ntime);
        return notices;
    }

}
