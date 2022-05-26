package com.minsait.onesait.architecture.utilities.services.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ChronometedAspect {

	@SuppressWarnings("unchecked")
	@Around("@within(Chronometed) || @annotation(Chronometed)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Chronometed a = signature.getMethod().getAnnotation(Chronometed.class);
		
		if(a == null) {
			a = (Chronometed) signature.getDeclaringType().getAnnotation(Chronometed.class);
		}

		if (a != null && ChronometedUtils.checkLogLevel(a.logLevel())) {
			long startTime = System.currentTimeMillis();
			Object proceed = joinPoint.proceed();
			long executionTime = System.currentTimeMillis() - startTime;

			ChronometedUtils.writeLog(signature, a.logLevel(), executionTime);

			return proceed;
		} else {
			return joinPoint.proceed();
		}
	}

}
