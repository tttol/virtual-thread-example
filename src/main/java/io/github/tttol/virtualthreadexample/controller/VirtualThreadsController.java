package io.github.tttol.virtualthreadexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/pp")
    public String doPurePlatform() {
        log.debug("start platform");
        virtualThreadsService.execPlatformThread();
        return "platform";
    }

    @GetMapping("/pv")
    public String doPrureVirtual() {
        log.debug("start virtual");
        virtualThreadsService.execVirtualThread();
        return "virtual";
    }
}
