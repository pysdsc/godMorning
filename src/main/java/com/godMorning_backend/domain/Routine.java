package com.godMorning_backend.domain;

import lombok.Getter;
import lombok.Setter;
// import com.nimbusds.oauth2.sdk.util.date.SimpleDate;
//import java.text.SimpleDateFormat;

@Getter
@Setter
public class Routine {
    private Long id;
    private String title;
    private String timezone;
    private String create_time;

    public String post_no;


}
