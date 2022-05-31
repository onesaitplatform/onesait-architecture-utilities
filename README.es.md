# Architecture Utilities

Librería que implementa una utilidad para cronometrar el tiempo que tarda en ejecutarse un método y lo muestra en el log.

## Usage

Para usar la librería hay que incluirla dentro de nuestro `pom.xml`:

```xml
<dependency>
     <groupId>com.minsait.onesait.architecture</groupId>
     <artifactId>onesait-architecture-utilities</artifactId>
     <version>${onesait.utilities.version}</version>
</dependency>
```

### Cronometro por anotación

Se ha definido la anotación `@Chronometed` para poder enviar al log el tiempo que tarda en ejecutarse un método. Puede verse en la clase `Chronometed.java`.

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

También es posible usar el servicio `ChronoService` para definir a más bajo nivel donde se quiere controlar el tiempo de ejecución de una tarea.

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