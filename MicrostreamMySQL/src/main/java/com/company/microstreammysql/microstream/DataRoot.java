
package com.company.microstreammysql.microstream;

import java.util.ArrayList;
import java.util.List;

import com.company.microstreammysql.entities.Customer;


/**
 * MicroStream data root. Create your data model from here.
 *
 * @see <a href="https://manual.docs.microstream.one/">Reference Manual</a>
 */
public class DataRoot
{
	private List<Customer> customers = new ArrayList<>();
	
	public DataRoot()
	{
		super();
	}

	public List<Customer> getCustomers()
	{
		return this.customers;
	}

	public void setCustomers(final List<Customer> customers)
	{
		this.customers = customers;
	}

}
