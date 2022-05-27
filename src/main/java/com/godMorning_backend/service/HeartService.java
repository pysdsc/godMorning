package com.godMorning_backend.service;

import com.godMorning_backend.domain.Heart;

import java.util.Map;

public interface HeartService {

    Heart findHeart(long post_no, long id);

    int insertHeart(Heart heart);

    int deleteHeart(Heart heart);

    Heart findHeart(Map<String, Long> number);
}
