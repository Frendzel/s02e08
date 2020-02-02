# Practical
## Decorator
## Proxy
## cglib
*EnableAspectJAutoProxy*
*proxyTargetClass*
*DummyServiceTest*
## Dynamic Proxy
## Exception Handling
*JokesRestControllerExceptionHandler*

## AspectJ
#### Advanced pointcut examples
## Pointcuts
*InvocationTimeAspect*
## Spring AOP
## ByteBuddy
## Annotations Processors
### Mapstruct
### Lombok
#### annotationProcessorPaths
#### Annotation Processors turn on
#### Lombok/Delombok
#### Target




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
