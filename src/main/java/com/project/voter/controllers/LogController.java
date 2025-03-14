package com.project.voter.controllers;

import io.micrometer.context.ContextSnapshot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@Slf4j
@RequestMapping("/api/logs")
public class LogController {

    @GetMapping("/")
    public String logs() {
        log.info("Some info");
        ContextSnapshot snapshot = ContextSnapshot.captureAll();
        Runnable log1 = () -> {
            ContextSnapshot.Scope scope = snapshot.setThreadLocals();
            log.warn("Some warn");
        };
        Runnable log2 = () -> {
            ContextSnapshot.Scope scope = snapshot.setThreadLocals();
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
        } catch (Exception e) {
            log.error("Caught exception " + e);
        }
    }
}
