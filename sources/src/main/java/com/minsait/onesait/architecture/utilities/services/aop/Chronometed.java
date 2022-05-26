package com.minsait.onesait.architecture.utilities.services.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.minsait.onesait.architecture.utilities.services.aop.model.LogLevelEnum;

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
