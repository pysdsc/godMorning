package com.godMorning_backend.repository;

import com.godMorning_backend.domain.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JDBCRoutineRepository implements RoutineRepository{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCRoutineRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public void saveRoutine(Routine routine) {
        String sql = "INSERT INTO Routine(id, title, timezone, create_time)";
        Object[] Params = {routine.getId(), routine.getTitle(), routine.getTimezone(), routine.getCreate_date()};
        jdbcTemplate.update(sql,Params);
    }

    @Override
    public List<Routine> findById(String userId) {
        return null;
    }

    private RowMapper<Routine> RoutineRowMapper() {
        return (rs, rowNum) -> {
            Routine routine = new Routine();
            routine.setId((rs.getLong("id")));
            routine.setTitle((rs.getString("title")));
            routine.setTimezone((rs.getString("timezone")));
            routine.setCreate_date((rs.getString("create_time")));

            return routine;
        };
    }
    public void updateRoutine(Routine routine) {
        String sql = "UPDATE Routine(post_no, title, timezone, create_date)";
        Object[] Params = {routine.getPost_no(), routine.getTitle(), routine.getTimezone(), routine.getCreate_date()};
        jdbcTemplate.update(sql,Params);
    }

    @Override
    public void deleteRoutine(Routine routine) {
       String sql = "DELETE from Routine(post_no,id, title, timezone, create_date)";
        Object[] Params = {routine.getPost_no(), routine.getTitle(), routine.getTimezone(), routine.getCreate_date()};
        jdbcTemplate.update(sql,Params);
    }


}
