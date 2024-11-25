package com.example.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to First Service!";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        // @RequestHeader -> 헤더에 들어있는 정보를 바로 꺼낼 수 있게 해줌.
        log.info(header);
        return "hello msg from First Service!";
    }

    @GetMapping("/check")
    public String check() {
        return "hello. this is first service check";
    }

}














