package com.company;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String TASK_SELECT_QUERY = "select * from tasks";

    public List<Task> getTasks() {
        return jdbcTemplate.query(TASK_SELECT_QUERY, BeanPropertyRowMapper.newInstance(Task.class));
    }
}
