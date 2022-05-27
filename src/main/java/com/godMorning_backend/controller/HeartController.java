package com.godMorning_backend.controller;

import com.godMorning_backend.domain.Heart;
import com.godMorning_backend.domain.Routine;
import com.godMorning_backend.service.HeartServiceImpl;
import com.godMorning_backend.service.RoutineServiceImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class HeartController {


    private JdbcTemplate jdbcTemplate;
    private HeartServiceImpl hs;
    private RoutineServiceImpl rs;
    private Routine rt;

    @RequestMapping(value="routine/detail",method= RequestMethod.GET)
    public String detail(@RequestParam("post_no") Long post_no, Model model,
                         @RequestParam(value="page", required=false, defaultValue="1") int page,
                         @RequestParam("id") Long id) {

        Routine routine = hs.detail(post_no);
        model.addAttribute("routine", routine);
        model.addAttribute("page", page);

        // 아래부터 좋아요 기능 시 추가되는 부분

        Heart heart = new Heart();
        // 좋아요가 되있는지 찾기위해 게시글번호와 회원번호를 보냄.Heart
        heart = hs.findHeart(post_no, id);
        // 찾은 정보를 heart로 담아서 보냄
        model.addAttribute("heart", heart);
        return "routine/detail";

    }

    @RequestMapping(value = "heart/insert", produces = "application/json; charset=UTF-8")
    public int insertHeart(Heart heart) {

        long id = 1L;
        long post_no= 1L;

        id=heart.getId();
        post_no=heart.getPost_no();

        heart.setId(id);
        heart.setPost_no(post_no);

        return hs.insertHeart(heart);
    }

    @RequestMapping(value = "heart/delete")
    public int deleteHeart(Heart heart, Model model) {
        long id = 1L;
        long post_no= 1L;
        model.addAttribute("id", id);
        model.addAttribute("post_no", post_no);


        return hs.deleteHeart(heart);
    }


    /*
    @RequestMapping(value="heart",method=RequestMethod.POST)
    public @ResponseBody int heart(@ModelAttribute Heart heart) {
        int result = hs.insertHeart(heart);
        return result;
    }
    */


    /*
    public Heart findHeart(long post_no, long id) {
        // 2개의 parameter를 보내기 위해 Map 선언 및 Map에 데이터 삽입
        Map<String, Long> number = new HashMap<String, Long>();
        number.put("post_no", post_no);
        number.put("id", id);
        return hs.findHeart(number);
    }*/







}
