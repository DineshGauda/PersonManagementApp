package com.dinesh.org.PersonManagementApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dinesh.org.PersonManagementApp.model.Person;
import com.dinesh.org.PersonManagementApp.util.HibernateUtil;

public class PersonDaoImpl implements PersonDao
{

	@Override
	public Boolean addPerson(Person person)
	{
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			transaction = session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
		} catch (RuntimeException e)
		{
			if (transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally
		{
			session.close();
		}
		return true;
	}

	@Override
	public Boolean editPerson(Person person)
	{
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			session.update(person);
			session.getTransaction().commit();
		} catch (RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
			e.printStackTrace();
			return false;
		} finally
		{
			session.close();
		}
		return true;
	}

	@Override
	public Boolean deletePerson(Long id)
	{

		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			transaction = session.beginTransaction();
			Person person = getPerson(id);
			session.delete(person);
			session.getTransaction().commit();
		} catch (RuntimeException e)
		{
			if (transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally
		{
			session.close();
		}
		return true;

	}

	@Override
	public int countNumberOfPersons()
	{
		int count = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			count = ((Long) session.createQuery("select count(*) from Person").iterate().next() ).intValue();
		} catch (RuntimeException e)
		{
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return count;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listAllRecords()
	{
		List<Person> persons = new ArrayList<Person>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			session.beginTransaction();
			persons = session.createQuery("from Person").list();
		} catch (RuntimeException e)
		{
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return persons;
	}

	@Override
	public Person getPerson(Long id)
	{
		Person person = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			person = (Person) session.get(Person.class, id);

		} catch (RuntimeException e)
		{
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return person;
	}

}
