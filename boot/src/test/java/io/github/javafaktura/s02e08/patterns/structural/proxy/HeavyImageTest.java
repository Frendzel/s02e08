package io.github.javafaktura.s02e08.patterns.structural.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeavyImageTest {

    @Test
    void display() {
        Image hugeMap = new ProxyToImage("hugeMap");
        hugeMap.display();
        hugeMap.display();
    }
}