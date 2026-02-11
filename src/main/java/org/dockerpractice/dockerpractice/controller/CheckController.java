package org.dockerpractice.dockerpractice.controller;


import lombok.RequiredArgsConstructor;
import org.dockerpractice.dockerpractice.service.CheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckController {

    private final CheckService checkService;

    @GetMapping("/check")
    public String check() {
        checkService.checkSave();
        return "도커 컨테이너에서 Spring Boot(JDK 21)가 잘 돌아가고 있어요! 🚀";
    }
}
