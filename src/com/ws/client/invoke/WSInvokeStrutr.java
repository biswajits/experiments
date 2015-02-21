package com.ws.client.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WSInvokeStrutr {
	
	public Object invokeWS(String className, String operation, Object[] input) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		
		Class<?> concreteClass = Class.forName(className);
		Class[] inputClass = new Class[input.length];
		for(int i=0;i<input.length;i++){
			inputClass[i] = input[i].getClass();
			System.out.println(inputClass[i]);
		}
		System.out.println("teset");
		Method m = concreteClass.getDeclaredMethod(operation, inputClass);
		Object output = m.invoke(concreteClass.newInstance(), input);
		return output;
	}

}
