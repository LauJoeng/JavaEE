package com.example.spring.struts2.actions;

import com.example.spring.struts2.service.PersonService;

public class PersonAction {
	
	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public String execute() {
		System.out.println("execute...");
		personService.save();
		return "success";
	}
}
