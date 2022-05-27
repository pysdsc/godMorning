package com.godMorning_backend.service;

import com.godMorning_backend.domain.Heart;
import com.godMorning_backend.domain.Routine;
import com.godMorning_backend.repository.JDBCHeartRepository;

import java.util.HashMap;
import java.util.Map;

public class HeartServiceImpl implements HeartService {
    private HeartServiceImpl hs;
    private final JDBCHeartRepository jdbcHeartRepository;

    public HeartServiceImpl(JDBCHeartRepository jdbcHeartRepository) {
        this.jdbcHeartRepository = jdbcHeartRepository;
    }

    @Override
    public Heart findHeart(long post_no, long id) {
        Map<String, Long> number = new HashMap<String, Long>();
        number.put("post_no", post_no);
        number.put("id", id);
        return hs.findHeart(number);
    }

    @Override
    public int insertHeart(Heart heart) {
        return jdbcHeartRepository.insertHeart(heart);
    }

    public int deleteHeart(Heart heart) {
        return jdbcHeartRepository.deleteHeart(heart);
    }


    @Override
    public Heart findHeart(Map<String, Long> number) {
        return null;
    }


    public Routine detail(long post_no) {
        return null;
    }
}
