package com.tadigital.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class LoggingAspect implements MethodInterceptor {
	
	private final static Logger LOGGER = Logger.getLogger(LoggingAspect.class);
	
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		LOGGER.info(methodInvocation.getMethod().getName() + " execution started.");
		
		Object returnValue = methodInvocation.proceed();
		
		LOGGER.info(methodInvocation.getMethod().getName() + " execution finished.");
		
		LOGGER.info(methodInvocation.getMethod().getName() + " return value is " +returnValue);
		
		return returnValue;
	}
}
