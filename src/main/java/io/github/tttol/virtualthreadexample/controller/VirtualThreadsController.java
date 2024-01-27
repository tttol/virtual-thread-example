package io.github.tttol.virtualthreadexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.tttol.virtualthreadexample.service.VirtualThreadsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping
public class VirtualThreadsController {
    private final VirtualThreadsService virtualThreadsService;

    @GetMapping("/platform/{count}")
    public String doPlatform(@PathVariable int count) {
        log.info("start platform. count={}", count);
        virtualThreadsService.execPlatformThread(count);
        return "platform";
    }

    @GetMapping("/virtual/{count}")
    public String doVirtual(@PathVariable int count) {
        log.info("start virtual. count={}", count);
        virtualThreadsService.execVirtualThread(count);
        return "virtual";
    }

    @GetMapping("/platform")
    public String doSinglePlatform() {
        log.info("start single platform.");
        virtualThreadsService.execSinglePlatformThread();
        return "single platform";
    }

    @GetMapping("/virtual")
    public String doSingleVirtual() {
        log.info("start single virtual.");
        virtualThreadsService.execSingleVirtualThread();
        return "single virtual";
    }
}
