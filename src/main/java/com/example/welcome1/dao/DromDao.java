package com.example.welcome1.dao;

import com.example.welcome1.entity.Drom;

import java.util.List;

public interface DromDao {
    //增加宿舍
    int addDrom(Drom drom);
    //更新宿舍信息
    int updateDrom(Drom drom);
    //按id查看宿舍详细信息
    Drom findByDid(String did);
    //按校区查找
    List<Drom> findDromsByCollege(String dcollege);
    //按宿舍区查找
    List<Drom> findDromsByDarea(String darea);
    //获取所有宿舍
    List<Drom> findAll();
}
