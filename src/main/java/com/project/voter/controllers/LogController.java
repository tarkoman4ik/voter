package com.project.voter.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;

@Controller
@Slf4j
@RequestMapping("/api/logs")
public class LogController {
    
    @GetMapping("/")
    public String logs() {
        log.info("Some info");
        Runnable log1 = () -> {
            log.warn("Some warn");
        };
        Runnable log2 = () -> {
            log.error("Some error");
        };
        Thread th1 = new Thread(log1);
        Thread th2 = new Thread(log2);
        th1.start();
        th2.start();
        log.trace("Some trace");
        log.debug("For debug");
        return "That's test trace";
    }

    @GetMapping("/exception")
    public void exceptingLogs() {
        try {
            throw new ArithmeticException();
        }
        catch (Exception e){
            log.error("Caught exception "+e);
        }
    }
}
