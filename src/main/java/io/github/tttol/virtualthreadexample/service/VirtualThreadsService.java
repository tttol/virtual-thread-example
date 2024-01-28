package io.github.tttol.virtualthreadexample.service;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class VirtualThreadsService {
    public void sleep() {
        try {
            log.info("sleeping......");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");//適当
        }
    }

    public void execPlatformThread(int count) {
        IntStream.range(0, count)
        .forEach(e -> Thread.ofPlatform().start(() -> sleep()));
    }

    public void execVirtualThread(int count) {
        IntStream.range(0, count)
        .forEach(e -> Thread.ofVirtual().start(() -> sleep()));
    }

    public void execSinglePlatformThread() {
        Thread.ofPlatform().start(() -> sleep());
    }

    public void execSingleVirtualThread() {
        Thread.ofVirtual().start(() -> sleep());
    }
}