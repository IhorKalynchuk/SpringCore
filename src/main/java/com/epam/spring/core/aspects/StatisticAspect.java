package com.epam.spring.core.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StatisticAspect {

	/**
	 * Pointcut definition
	 *
	 * All methods logEvent()
	 */
	@Pointcut("execution(* *.logEvent(..))")
	private void allLogEventMethods() {
	}

	private Map<Class<?>, Integer> counter = new HashMap<Class<?>, Integer>();

	@AfterReturning("allLogEventMethods()")
	public void count(JoinPoint joinPoint) {
		Class<?> clazz = joinPoint.getTarget().getClass();
		if (!counter.containsKey(clazz)) {
			counter.put(clazz, 0);
		}
		counter.put(clazz, counter.get(clazz) + 1);
	}

	public void printStatistic() {
		System.out.println("===============		STATISTIC 	=========================");
		counter.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue());
		});
		System.out.println("=========================================================");
	}
}
