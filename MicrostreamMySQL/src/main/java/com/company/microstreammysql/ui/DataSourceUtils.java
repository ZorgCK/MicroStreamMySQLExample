
package com.company.microstreammysql.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.company.microstreammysql.entities.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.rapidclipse.framework.server.resources.ApplicationResource;


public class DataSourceUtils
{
	public static MysqlDataSource getMySQLDataSource()
	{
		final MysqlDataSource ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/microstreamschema");
		ds.setUser("root");
		ds.setPassword("12345678");
		ds.setPort(3306);

		return ds;
	}

	public static List<Customer> loadCustomers()
		throws JsonSyntaxException, JsonIOException, IOException
	{
		final InputStream is =
			ApplicationResource.createInputStream(
				DataSourceUtils.class, "/mockup/MOCK_DATA.json");

		final BufferedReader streamReader = new BufferedReader(new InputStreamReader(is));
		final List<Customer> customers    = new Gson().fromJson(streamReader, new TypeToken<List<Customer>>()
											{}.getType());

		streamReader.close();

		return customers;
	}
}
