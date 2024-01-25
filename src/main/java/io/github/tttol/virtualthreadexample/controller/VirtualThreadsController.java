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

    @GetMapping("/platform")
    public String doPlatform() {
        log.debug("start platform");
        virtualThreadsService.execPlatformThread(100);
        return "platform";
    }

    @GetMapping("/virtual")
    public String doVirtual() {
        log.debug("start virtual");
        virtualThreadsService.execVirtualThread(100);
        return "virtual";
    }
}
