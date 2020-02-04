package io.github.javafaktura.s02e08.patterns.structural.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeavyImage implements Image {
    private String fileName;

    public HeavyImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        log.info("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        log.info("Loading " + fileName);
    }
}
