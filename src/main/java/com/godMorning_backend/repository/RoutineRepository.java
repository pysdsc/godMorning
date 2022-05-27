package com.godMorning_backend.repository;

import com.godMorning_backend.domain.Routine;
import com.godMorning_backend.domain.Test;

import java.util.List;

public interface RoutineRepository {
    // 문제 저장
    void saveRoutine(Routine routine);
    // 수정
    void updateRoutine(Routine routine);
    //삭제
    void deleteRoutine(Routine routine);

    // 회원아이디로 조회
    List<Routine> findById(String userId);


}
