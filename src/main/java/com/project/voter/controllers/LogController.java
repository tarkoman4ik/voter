package com.project.voter.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/api/logs")
public class LogController {
    @GetMapping("/")
    public String logs(){
        log.info("Some info");
        log.warn("Some warn");
        log.trace("Some trace");
        log.debug("For debug");
        log.error("Some error");
        return "That's test trace";
    }
}
