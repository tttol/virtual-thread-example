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

    @GetMapping("sleep")
    public String sleep() {
        virtualThreadsService.sleep();
        return "sleep";
    }

    @GetMapping("async")
    public String async() {
        virtualThreadsService.sleepAsync();
        return "async";
    }

    @GetMapping("platform/task/{count}")
    public String task(@PathVariable int count) {
        virtualThreadsService.task(count);
        return "task";
    }

}
