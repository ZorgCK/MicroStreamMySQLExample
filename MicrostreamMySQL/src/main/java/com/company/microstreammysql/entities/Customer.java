
package com.company.microstreammysql.entities;

public class Customer
{
	private String name;
	private String company;
	private String mail;
	private String city;
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public String getCompany()
	{
		return this.company;
	}
	
	public void setCompany(final String company)
	{
		this.company = company;
	}
	
	public String getMail()
	{
		return this.mail;
	}
	
	public void setMail(final String mail)
	{
		this.mail = mail;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public void setCity(final String city)
	{
		this.city = city;
	}
	
}
