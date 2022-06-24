package com.godMorning_backend.repository;

import com.godMorning_backend.domain.Heart;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class JDBCHeartRepository implements HeartRepository {

    private JdbcTemplate jdbcTemplate;
    public JDBCHeartRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Heart findHeart(Map<String, Long> number) {
        return null;
    }

    @Override
    public List<Heart> findHeart(Heart heart) {
        String sql= "select * from Heart";
        Object[] Params = {heart.getPost_no(),heart.getId()};
        return jdbcTemplate.query(sql, HeartRowMapper());
    }

    @Override
    public int deleteHeart(Heart heart) {
        String sql= "Delete from Heart(post_no, id)";
        Object[] Params = {heart.getPost_no(),heart.getId()};
        return jdbcTemplate.update(sql, Params);
    }

    public int insertHeart(Heart heart) {
        String sql= "INSERT INTO Heart(post_no, id)";
        Object[] Params = {heart.getPost_no(),heart.getId()};
        return jdbcTemplate.update(sql, Params);
    }

    private RowMapper<Heart> HeartRowMapper() {
        return (rs, rowNum) -> {
            Heart heart = new Heart();
            heart.setPost_no((rs.getLong("post_no")));
            heart.setId((rs.getLong("id")));

            return heart;
        };
    }


}
