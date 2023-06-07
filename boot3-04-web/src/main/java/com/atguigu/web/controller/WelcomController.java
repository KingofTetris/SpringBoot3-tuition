package com.atguigu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by KingOfTetris
 * @date 2023/6/5
 */
@Controller
public class WelcomController {
    @GetMapping("/welcome")
    public String index(@RequestParam("name") String name, Model model){
        String span = "<span style='color:red'>" + name + "</span>";
        model.addAttribute("msg",span);
        return "index";
    }
}
