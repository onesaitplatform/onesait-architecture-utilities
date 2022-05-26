package com.minsait.onesait.architecture.utilities.services.aop;

import org.aspectj.lang.Signature;

import com.minsait.onesait.architecture.utilities.services.aop.model.LogLevelEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ChronometedUtils {

	private ChronometedUtils() {
		throw new IllegalStateException("Utility class");
	}

	private static final String LOG_MESSAGE = "Class Name: {} Method Name: {} executed in {} ms";

	public static void writeLog(Signature signature, LogLevelEnum level, Long executionTime) {
		switch (level) {
		case DEBUG:
			log.debug(LOG_MESSAGE, signature.getDeclaringTypeName(), signature.getName(), executionTime);
			break;
		case INFO:
			log.info(LOG_MESSAGE, signature.getDeclaringTypeName(), signature.getName(), executionTime);
			break;
		case TRACE:
			log.trace(LOG_MESSAGE, signature.getDeclaringTypeName(), signature.getName(), executionTime);
			break;
		case WARN:
			log.warn(LOG_MESSAGE, signature.getDeclaringTypeName(), signature.getName(), executionTime);
			break;
		case ERROR:
			log.error(LOG_MESSAGE, signature.getDeclaringTypeName(), signature.getName(), executionTime);
			break;
		}
	}
	
	public static boolean checkLogLevel(LogLevelEnum level) {
		switch (level) {
		case DEBUG:
			return log.isDebugEnabled();
		case INFO:
			return log.isInfoEnabled();
		case TRACE:
			return log.isTraceEnabled();
		case WARN:
			return log.isWarnEnabled();
		case ERROR:
			return log.isErrorEnabled();
		}
		return false;
	}

}
