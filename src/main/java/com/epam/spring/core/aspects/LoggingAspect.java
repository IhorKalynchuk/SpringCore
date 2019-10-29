package com.epam.spring.core.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	private final static Logger logger = Logger.getLogger(LoggingAspect.class);

	/**
	 * Pointcut definition
	 *
	 * All methods logEvent()
	 */
	@Pointcut("execution(* *.logEvent(..))")
	private void allLogEventMethods() {
	}

	/**
	 * Pointcut definition
	 *
	 * logEvent() methods inside classes FileEventLogger & CacheFileEventLogger
	 */
	@Pointcut("allLogEventMethods() && within (*.*File*Logger)")
	private void logEventInsideFileLoggers() {
	}

	/**
	 * Advice definition
	 *
	 * execute before pointcut allLogEventMethods()
	 */
	@Before("allLogEventMethods()")
	private void logBefore(JoinPoint joinPoint) {
		String targetName = joinPoint.getTarget().getClass().getSimpleName();
		System.out.println("BEFORE: TARGET_NAME IS [" + targetName + "],  SIGNATURE IS: " + joinPoint.getSignature());
	}

	/**
	 * Advice definition
	 *
	 * execute after returning pointcut logEventInsideFileLoggers()
	 */
	@AfterReturning("logEventInsideFileLoggers()")
	private void logAfterReturning(JoinPoint joinPoint) {
		String targetName = joinPoint.getTarget().getClass().getSimpleName();
		System.out.println(
				"AFTER RETURNING: TARGET_NAME IS [" + targetName + "],  SIGNATURE IS: " + joinPoint.getSignature());
	}

}
