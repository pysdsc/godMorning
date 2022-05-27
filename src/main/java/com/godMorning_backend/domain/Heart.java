package com.godMorning_backend.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Heart {
    // pk값으로 쓸 번호
    private long h_number;
    // 게시글 번호
    private long post_no;
    // 회원 번호
    private long id;

   // private int heart;
}
