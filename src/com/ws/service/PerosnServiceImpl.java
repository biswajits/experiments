package com.ws.service;

import com.ws.model.Person;

public class PerosnServiceImpl {
	
	public Person searchPerson(Person per){
		Person personOutput = new Person();
		personOutput.setName(per.getName());
		personOutput.setAddr(per.getAddr());
		
		System.out.println("############ WebService Invoked ############");
		System.out.println("Name : "+per.getName());
		System.out.println("Address : "+per.getAddr());
		
		return personOutput;
	}

}
