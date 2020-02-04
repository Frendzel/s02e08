# Practical 🌈
*Resolve All Todos*
*Annotation example*
## Decorator
*Sandwich*
## Proxy
*HeavyImage*
## Dynamic Proxy
*https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html*
## cglib
*EnableAspectJAutoProxy*
*proxyTargetClass*
*DummyServiceTest*
## Exception Handling
*JokesRestControllerExceptionHandler*
## Aspect
## Advice
## Pointcut
*InvocationTimeAspect*

Method pattern: [Modifiers] ReturnType [ClassType] MethodName ([Arguments]) [throws ExceptionType]
## Joinpoint

## AspectJ
*ltw*
*ctw*
## ByteBuddy
## Annotations Processors

### Autovalue
*https://docs.google.com/presentation/d/14u_h-lMn7f1rXE1nDiLX0azS3IkgjGl5uxp5jGJ75RE/edit#slide=id.g2a5e9c4a8_0114*

*User writes only plain old Java code
*No runtime impact
*no dependency (@AutoValue has source retention)
*performs comparably to hand-written code
*No magical modifying of existing classes
*Still just a single javac pass to compile!

### Mapstruct
https://mapstruct.org/
### Lombok
*annotationProcessorPaths*
*Annotation Processors turn on*
*Lombok/Delombok*
*Target*

# QUIZ
https://play.kahoot.it/v2/?quizId=8b2ea781-4b9d-45b1-805b-f2679f1d9615
https://kahoot.it/

# Theory

**Decorator** (takes an instance of same abstract/interface type which adds additional behaviour)
* All subclasses of java.io.InputStream, OutputStream, Reader and Writer have a constructor taking an instance of same type.
* java.util.Collections, the checkedXXX(), synchronizedXXX() and unmodifiableXXX() methods.
* javax.servlet.http.HttpServletRequestWrapper and HttpServletResponseWrapper
* javax.swing.JScrollPane

**Proxy** (returns an implementation of given abstract/interface type which in turn delegates/uses a different implementation of given abstract/interface type)
* java.lang.reflect.Proxy
* java.rmi.*
* javax.ejb.EJB
* javax.inject.Inject
* javax.persistence.
