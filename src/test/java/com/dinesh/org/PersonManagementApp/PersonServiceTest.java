package com.dinesh.org.PersonManagementApp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dinesh.org.PersonManagementApp.exception.DuplicateUserException;
import com.dinesh.org.PersonManagementApp.model.Person;
import com.dinesh.org.PersonManagementApp.service.PersonService;
import com.dinesh.org.PersonManagementApp.service.PersonServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonServiceTest
{

	private PersonService personService = new PersonServiceImpl();
	
	@Before
	public void setUp() throws Exception
	{
		System.out.println("setup");
		
	}

	@After
	public void clean()
	{
		System.out.println("clean after");
	}

	@Test
	public void testAddPerson()
	{
		Person person = new Person(11L, "Test1", "Test2");
		try
		{
			assertTrue(personService.addPerson(person));
		} catch (DuplicateUserException e)
		{
			e.printStackTrace();
			fail("error in running junit testcase : testAddPerson");
		}
	}

	@Test
	public void testDeletePerson()
	{
		assertTrue(personService.deletePerson(11L));	
	}
	
	@Test
	public void testDuplicatePerson()
	{
		Person person = new Person(11L, "Test1", "Test2");
		try
		{
			assertTrue(personService.addPerson(person));
			assertFalse(personService.addPerson(person));
		} catch (DuplicateUserException e)
		{
			e.printStackTrace();
			assertTrue("Testing in duplicate person junit testcase", true);
		}
		personService.deletePerson(11L);
	}
	
}
