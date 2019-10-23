package com.dinesh.org.PersonManagementApp.service;

import com.dinesh.org.PersonManagementApp.exception.DuplicateUserException;
import com.dinesh.org.PersonManagementApp.model.Person;

public interface PersonService
{
	public Boolean addPerson(Person person) throws DuplicateUserException;

	public Boolean editPerson(Person person);

	public Boolean deletePerson(Long id);
	
	public void countNumberOfPersons();
	
	public void listAllRecords();

	public Person getPerson(Long id);
	
	public Boolean addPersonXMl(String personXMl);
	
}
