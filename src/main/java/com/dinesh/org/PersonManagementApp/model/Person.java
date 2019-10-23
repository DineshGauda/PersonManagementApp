package com.dinesh.org.PersonManagementApp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "person")
@XmlRootElement(name="Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@XmlElement(name = "id")
	private Long id;
	
	@XmlElement(name = "firstName")
	private String firstName;
	
	@XmlElement(name = "surName")
	private String surName;
	
	
	public Person() 
	{
		
	}
	
	public Person(Long id, String firstName, String surName)
	{
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getSurName()
	{
		return surName;
	}
	public void setSurName(String surName)
	{
		this.surName = surName;
	}

	@Override
	public String toString()
	{
		return "Id : " + id + "\n" + "First Name: " + firstName + "\n" + "Surname: " + surName + "\n";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

		
}
