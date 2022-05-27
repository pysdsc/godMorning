package com.godMorning_backend.service;

import com.godMorning_backend.domain.Routine;

import java.util.List;

public interface RoutineService {
    int saveRoutine(Routine routine);

    void updateRoutine(Routine routine);

    void deleteRoutine(Routine routine);

    List<Routine> findById(String userId);
}
