package io.github.javafaktura.s02e08.boot.dummy;

import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

//TODO Show annotations
//TODO is it good test or not?
//TODO Go into debug and try to not die there!
class DummyServiceTest {
    @Test
    public void manuallyAddProxyToTheClass() {
        DummyCglibService dummyService = new DummyCglibService();
        DummyAspect dummyAspect = new DummyAspect();
        AspectJProxyFactory factory = new AspectJProxyFactory(dummyService);
        factory.addAspect(dummyAspect);
        DummyCglibService proxy = factory.getProxy();
        proxy.iWillDoThisAfterTheLastExam();
    }

    @Test
    public void manuallyAddProxyToTheClass2() {
        Dummable dummyService = new DummyService(); // IoC is for dummies
        DummyAspect dummyAspect = new DummyAspect();
        AspectJProxyFactory factory = new AspectJProxyFactory(dummyService);
        factory.addAspect(dummyAspect);
        Dummable proxy = factory.getProxy();
        proxy.iWillDoThisAfterTheLastExam();
    }
}