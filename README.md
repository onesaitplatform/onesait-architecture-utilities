# Architecture Utilities

Library that implements a utility to time how long it takes to execute a method and displays it in the log.

## Usage

To use the library we must include within our `pom.xml`:

```xml
<dependency>
     <groupId>com.minsait.onesait.architecture</groupId>
     <artifactId>onesait-architecture-utilities</artifactId>
     <version>${onesait.utilities.version}</version>
</dependency>
```

### Cronometro por anotación

The `@Chronometed` annotation has been defined to be able to log the time it takes to execute a method. It can be seen in the `Chronometed.java` class.

```java
/**
 * Annotation used to log methods execution time
 * 
 * @author Architecture Team
 *
 */

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Chronometed {

    /**
     * (Optional) Selects the log level where the execution time will be displayed
     * @return log level where the execution time will be displayed
     */
    LogLevelEnum logLevel() default LogLevelEnum.DEBUG;
	
}
```

### Cronometro a través de un servicio

It is also possible to use the `ChronoService` service to define at a lower level where you want to control the execution time of a task.

```java
public interface ChronoService {

	/**
	 * Method to initialize the counter
	 * 
	 * @return Time in which the method was initialized
	 */
	public Long startTime();

	/**
	 * Method to end the counter
	 * 
	 * @param startTime - Time in which the method was initialized
	 * @return Time in which the method was finished
	 */
	public Long endTime(Long startTime);

	/**
	 * Method to end the counter
	 * 
	 * @param startTime - Time in which the method was initialized
	 * @param name      - name that want to put in trace
	 * @return Time in which the method was finished
	 */
	public Long endTime(Long startTime, String name);
}
```