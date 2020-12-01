package com.example.welcome1.dao;

import com.example.welcome1.entity.Drom;

public interface DromDao {
    //按id查看宿舍所有信息
    Drom findByDid(String did);
    //
}
