package com.godMorning_backend.repository;

import com.godMorning_backend.domain.Heart;

import java.util.List;
import java.util.Map;

public interface HeartRepository {



    Heart findHeart(Map<String, Long> number);

    List<Heart> findHeart(Heart heart);

    int deleteHeart(Heart heart);

    int insertHeart(Heart heart);
}
