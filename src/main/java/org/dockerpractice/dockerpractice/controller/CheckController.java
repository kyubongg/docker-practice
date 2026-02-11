package org.dockerpractice.dockerpractice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    @GetMapping("/check")
    public String check() {
        return "도커 컨테이너에서 Spring Boot(JDK 21)가 잘 돌아가고 있어요! 🚀";
    }
}
