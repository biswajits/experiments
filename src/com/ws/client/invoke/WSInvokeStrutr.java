package com.ws.client.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WSInvokeStrutr {
	
	public Object invokeWS(String className, String operation, Class[] inputClass, Object[] input) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		
		Class<?> concreteClass = Class.forName(className);
		Method m = concreteClass.getDeclaredMethod(operation, inputClass);
		Object output = m.invoke(concreteClass.newInstance(), input);
		return output;
	}

}
