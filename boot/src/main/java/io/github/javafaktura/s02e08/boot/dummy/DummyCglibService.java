package io.github.javafaktura.s02e08.boot.dummy;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class DummyCglibService {

    @SneakyThrows
    public void iWillDoThisAfterTheLastExam() {
        Thread.sleep(1000);
    }
}
