package io.github.tttol.virtualthreadexample.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("index")
public class VirtualThreadsController {
    // add methods here
    public String index() {
        log.info("index() called");
        return "index";
    }   
}
