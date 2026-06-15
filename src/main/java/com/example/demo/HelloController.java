package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }

    @ResponseBody
    @GetMapping("/introduce")
    public String introduce(@RequestParam(required = false) String name) {
        if (name == null) {
            return "Hello, my name is Sanghoon Kim.";
        }
        return "Hello, my name is " + name + ".";
    }

    @ResponseBody
    @GetMapping("/json")
    public Map<String, Object> json() {
        Map<String, Object> result = new HashMap<>();
        result.put("age", 26);
        result.put("name", "Hong Gil-dong");
        return result;
    }
}
