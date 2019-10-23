package com.dinesh.org.PersonManagementApp.service;

import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.dinesh.org.PersonManagementApp.dao.PersonDao;
import com.dinesh.org.PersonManagementApp.dao.PersonDaoImpl;
import com.dinesh.org.PersonManagementApp.exception.DuplicateUserException;
import com.dinesh.org.PersonManagementApp.model.Person;

public class PersonServiceImpl implements PersonService
{
	private PersonDao personDao = new PersonDaoImpl();

	@Override
	public Boolean addPerson(Person person) throws DuplicateUserException
	{
		if(personDao.getPerson(person.getId()) != null ) {
			throw new DuplicateUserException("User with same Id already exists");
		}
		
		return personDao.addPerson(person);

	}

	@Override
	public Boolean editPerson(Person person)
	{
		return personDao.editPerson(person);
	}

	@Override
	public Boolean deletePerson(Long id)
	{
		return personDao.deletePerson(id);

	}

	@Override
	public void countNumberOfPersons()
	{
		System.out.println("Count : " + personDao.countNumberOfPersons());
		System.out.println();
	}

	@Override
	public void listAllRecords()
	{
		List<Person> persons = personDao.listAllRecords();
		System.out.println("List of Persons:");
		for (Person person : persons)
		{
			System.out.println(person);
		}

	}

	@Override
	public Boolean addPersonXMl(String personXMl)
	{

		Person person=null;
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(personXMl);

			person = (Person) unmarshaller.unmarshal(reader);
		} 
		catch (JAXBException e)
		{
			e.printStackTrace();
		}

		return personDao.addPerson(person);
	}

	@Override
	public Person getPerson(Long id)
	{
		return personDao.getPerson(id);
	}
}
