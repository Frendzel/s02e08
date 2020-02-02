package io.github.javafaktura.s02e08.boot.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static java.lang.Thread.sleep;

//TASK 1 -> FIND Cross Cutting Concerns
//TASK 2 -> Separate them and move to separate advices
@Component
@Slf4j
public class LegacyService {

    private static final String CLASSNAME = LegacyService.class.getName();

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void doSomething() {
        final String METHODNAME = "doSomething";
        log.trace("entering " + CLASSNAME + "." + METHODNAME);
        TransactionStatus tx = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            businessLogic();
        } catch (RuntimeException | InterruptedException ex) {
            log.error("exception in " + CLASSNAME + "." + METHODNAME, ex);
            tx.setRollbackOnly();
        } finally {
            transactionManager.commit(tx);
            log.trace("exiting " + CLASSNAME + "." + METHODNAME);
        }
    }

    public void throwsRuntimeException() {
        throw new RuntimeException();
    }

    public String returnsStringAndThrowsRuntimeException() {
        throw new RuntimeException();
    }

    public void throwsException() throws Exception {
        throw new Exception();
    }

    private void businessLogic() throws InterruptedException {
        sleep(1000);
    }

}
