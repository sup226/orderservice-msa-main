package com.example.secondservice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@RequiredArgsConstructor
@Slf4j
public class SecondServiceController {

//    @Value("server.port")
//    private String port;

    private final Environment env;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Second Service!";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header) {
        // @RequestHeader -> 헤더에 들어있는 정보를 바로 꺼낼 수 있게 해줌.
        log.info(header);
        return "hello msg from Second Service!";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port: {}", request.getServerPort());

        return "hello. the server port number is " + env.getProperty("server.port");
    }

}













