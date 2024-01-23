package io.github.tttol.virtualthreadexample.service;

import java.util.stream.IntStream; // Add this import statement

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

    public void execPlatformThread() {
        IntStream.range(0, 100)
        .forEach(e -> Thread.ofPlatform().start(() -> sleep()));
    }

    public void execVirtualThread() {
        IntStream.range(0, 100)
        .forEach(e -> Thread.startVirtualThread(() -> sleep()));
    }
}
