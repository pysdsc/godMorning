package com.godMorning_backend.controller;

import com.godMorning_backend.config.auth.dto.SessionUser;
import com.godMorning_backend.domain.Routine;
import com.godMorning_backend.domain.ToDo;
import com.godMorning_backend.repository.JDBCRoutineRepository;
import com.godMorning_backend.service.RoutineServiceImpl;
import com.godMorning_backend.service.ToDoServiceImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RoutineController {
    private JdbcTemplate jdbcTemplate;
    private RoutineServiceImpl routineServiceImpl;


    private Routine routine;
    private JDBCRoutineRepository jdbcRoutineRepository;
    private HttpSession httpSession;

    private ToDoServiceImpl toDoServiceImpl;
    private SessionUser sessionUser;



    public RoutineController(JdbcTemplate jdbcTemplate, ToDoServiceImpl toDoServiceImpl,  RoutineServiceImpl routineServiceImpl,
                             JDBCRoutineRepository jdbcRoutineRepository, HttpSession httpSession  ) {
        this.jdbcTemplate = jdbcTemplate;
        this.routineServiceImpl = routineServiceImpl;
        this.jdbcRoutineRepository = jdbcRoutineRepository;
       // this.routine = routine;
        this.toDoServiceImpl = toDoServiceImpl;
        this.httpSession = httpSession;
    }
    @PostMapping(value = "todo/create", produces = "application/json; charset_UTF-8")
    public ToDo save(@RequestBody ToDo todo){
        SessionUser user = (SessionUser) httpSession.getAttribute("google_user");
        //투두

        int post_no = 0;
        String content = "";
        int check_do = 0;

        post_no = todo.getPost_no();
        content = todo.getContent();
        check_do = todo.getCheck_do();

        todo.setPost_no(post_no);
        todo.setContent(content);
        todo.setCheck_do(0);

        toDoServiceImpl.saveToDo(todo);

        return todo;
    }


    @PostMapping(value = "routine/create",   produces = "application/json; charset=UTF-8")
    public Routine save(@RequestBody Routine routine, Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("google_user");

        Long id = 1L;
        String title = "";
        String timezone = "";
        String creat_time= "";

        id = user.getId();
        title = routine.getTitle();
        timezone = routine.getTimezone();
        creat_time= routine.getCreate_time();

        routine.setId(id);
        routine.setTitle(title);
        routine.setTimezone(timezone);
        routine.setCreate_time(creat_time);

        routineServiceImpl.saveRoutine(routine);

        return routine;
    }

/*
    @PostMapping(value = "routine/update",   produces = "application/json; charset=UTF-8")
    public Routine update(@RequestBody Routine routine, HttpServletResponse response) {

        routineServiceImpl.updateRoutine(routine);
        return routine;
    }

    @PostMapping(value = "routine/delete",   produces = "application/json; charset=UTF-8")
    public Routine delete(@RequestBody Routine routine, HttpServletResponse response) {

        routineServiceImpl.deleteRoutine(routine);
        return routine;
    }
*/
}
