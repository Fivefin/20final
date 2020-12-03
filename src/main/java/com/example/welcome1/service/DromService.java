package com.example.welcome1.service;

import com.example.welcome1.entity.Drom;

public interface DromService {
    Drom findByDid(String did);

    int updateDrom(Drom drom);

    int addDrom(Drom drom);
}
