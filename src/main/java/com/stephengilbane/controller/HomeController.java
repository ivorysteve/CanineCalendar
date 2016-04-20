package com.stephengilbane.controller;

/**
 * Stolen from demo:
 * https://github.com/springfox/springfox-demos/blob/master/boot-swagger/*.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
    @RequestMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
