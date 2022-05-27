package com.godMorning_backend.service;

import com.godMorning_backend.domain.Routine;
import com.godMorning_backend.repository.JDBCRoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineServiceImpl implements RoutineService{

    private final JDBCRoutineRepository jdbcRoutineRepository;

    public RoutineServiceImpl(JDBCRoutineRepository jdbcRoutineRepository) {
        this.jdbcRoutineRepository = jdbcRoutineRepository;
    }


    @Override
    public int saveRoutine(Routine routine) {
        jdbcRoutineRepository.saveRoutine(routine);
        return 1;
    }

    @Override //수정
    public void updateRoutine(Routine routine) {
        jdbcRoutineRepository.updateRoutine(routine);
    }

    @Override
    public void deleteRoutine(Routine routine) {
        jdbcRoutineRepository.deleteRoutine(routine);
    }



    @Override
    public List<Routine> findById(String userId) {
        return null;
    }


    public Routine detail(int post_no) {
        return null;
    }
}
