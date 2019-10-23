package com.dinesh.org.PersonManagementApp;

import java.util.Scanner;

import com.dinesh.org.PersonManagementApp.exception.DuplicateUserException;
import com.dinesh.org.PersonManagementApp.model.Person;
import com.dinesh.org.PersonManagementApp.service.PersonService;
import com.dinesh.org.PersonManagementApp.service.PersonServiceImpl;

public class App
{
	private PersonService personService = new PersonServiceImpl();

	public static void main(String[] args)
	{
		App app = new App();
		app.initiatCommandLineDisplay();
	}

	public void initiatCommandLineDisplay() {
		Scanner scanner = new Scanner(System.in);
		
		int option = 1;

		while (option != 0)
		{
			showOptions();
			option = scanner.nextInt();

			switch (option)
			{
			case 1:
				System.out.println("Add Person Option Selected");
				System.out.println("Enter Id:");
				Long id = scanner.nextLong();
				// Skip the newline
				scanner.nextLine();
				System.out.println("Enter First Name:");
				String firstName = scanner.nextLine();
				System.out.println("Enter Surname:");
				String surName = scanner.nextLine();

				Person person = new Person(id, firstName, surName);

				try
				{
					if(personService.addPerson(person))
						System.out.println("Person added successfully" + "\n");
				} catch (DuplicateUserException e)
				{
					System.out.println("User already exists with same id." + "\n");
				}
				catch (Exception e) {
					System.out.println("Problem while adding new person" + "\n");
				}
				break;
			case 2:
				System.out.println("Edit Person Option Selected" + "\n");
				
				System.out.println("Enter Id of the person you want to edit" + "\n");
				Long editId = scanner.nextLong();
				// Skip the newline
				scanner.nextLine();
				System.out.println("Enter First Name:");
				String firstNameEdit = scanner.nextLine();
				System.out.println("Enter Surname:");
				String surNameEdit = scanner.nextLine();

				Person updatedPerson = personService.getPerson(editId);
				updatedPerson.setFirstName(firstNameEdit);
				updatedPerson.setSurName(surNameEdit);

				
				if(!personService.editPerson(updatedPerson))
					System.out.println("Problem while updating person" + "\n");
				break;
			case 3:
				System.out.println("Delete Person Option Selected" + "\n");
				System.out.println("Enter Id of the person you want to delete");
				long deleteId = scanner.nextLong();
				if(!personService.deletePerson(deleteId))
					System.out.println("Problem while delete person" + "\n");
				else
					System.out.println("Delete Success" + "\n");
				break;
			case 4:
				System.out.println("Count Number of Persons Option Selected" + "\n");
					personService.countNumberOfPersons();
				break;
			case 5:
				System.out.println("List Person Option Selected" + "\n");
				personService.listAllRecords();
				break;
			case 6:
				System.out.println("Add Person Option using XML Selected" + "\n");
				// Skip the newline
				scanner.nextLine();
				System.out.println("Enter the details of person you want to add in xml format");

				String personXMl = scanner.nextLine();
				if(!personService.addPersonXMl(personXMl))
					System.out.println("Problem while adding new person" + "\n");
				else
					System.out.println("Person added successfully" + "\n");
				break;
			case 0:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("List Person" + "\n");
				personService.listAllRecords();
				break;
			}
		}
		
		if(scanner!=null)
			scanner.close();
	}
	public static void showOptions()
	{
		System.out.println("Enter an option: ");
		System.out.println("1) Add Person.");
		System.out.println("2) Edit Person.");
		System.out.println("3) Delete Person.");
		System.out.println("4) Count Number of Person.");
		System.out.println("5) List Person.");
		System.out.println("6) Add Person using XML.");
		System.out.println("0) To Exit.");
	}
}
