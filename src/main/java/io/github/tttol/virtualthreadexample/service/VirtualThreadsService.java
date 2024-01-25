package io.github.tttol.virtualthreadexample.service;

import java.util.stream.IntStream;

import org.springframework.stereotype.Service;


@Service
public class VirtualThreadsService {
    public void sleep() {
        try {
            Thread.sleep(2000);
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
        .forEach(e -> Thread.startVirtualThread(() -> sleep()));
    }
}
