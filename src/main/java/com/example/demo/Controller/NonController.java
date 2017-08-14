package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chai on 17/8/3.
 */
@Controller
public class NonController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
