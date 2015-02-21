package com.ws.client.main;

import java.lang.reflect.InvocationTargetException;

import com.ws.client.invoke.WSInvokeStrutr;
import com.ws.model.Employee;
import com.ws.model.Person;

public class WSClientMain {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		WSInvokeStrutr invoke = new WSInvokeStrutr();
		Person person = new Person();
		Employee emp = new Employee();
		person.setName("biswa");
		person.setAddr("hindmotor");
		String className = "com.ws.service.PerosnServiceImplProxy";
		String operationName = "searchPerson";
		Person personOutput = (Person)invoke.invokeWS(className, operationName, new Object[]{person});

		System.out.println(person.getName());
	}

}