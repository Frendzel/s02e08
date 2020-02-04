package io.github.javafaktura.s02e08.patterns.structural.proxy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyToImage implements Image {
    private HeavyImage heavyImage;
    private String fileName;

    public ProxyToImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (heavyImage == null) {
            log.debug("Creating a new object");
            heavyImage = new HeavyImage(fileName);
        }
        heavyImage.display();
    }
}
