package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }

    @GetMapping("/introduce")
    public String introduce(){ return "안녕하세요 제 이름은 김남홍입니다!";}

    @GetMapping("/introduce")
    public String introducename(@RequestParam String name){
        return "안녕하세요 제 이름은 " + name + "입니다!";
    }

    @GetMapping("/json")
    public Map<String, Object> json() {
        Map<String, Object> result = new HashMap<>();
        result.put("age", 26);
        result.put("name", "허준기");
        return result;
    }
}
