package com.dinesh.org.PersonManagementApp.dao;

import java.util.List;

import com.dinesh.org.PersonManagementApp.model.Person;

public interface PersonDao
{
	public Boolean addPerson(Person person);

	public Boolean editPerson(Person person);

	public Boolean deletePerson(Long id);
	
	public int countNumberOfPersons();
	
	public List<Person> listAllRecords();

	public Person getPerson(Long id);

}
