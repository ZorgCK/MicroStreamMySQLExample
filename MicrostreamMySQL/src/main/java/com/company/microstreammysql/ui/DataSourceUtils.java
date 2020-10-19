
package com.company.microstreammysql.ui;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.company.microstreammysql.entities.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mysql.cj.jdbc.MysqlDataSource;


public class DataSourceUtils
{
	public static MysqlDataSource getMySQLDataSource()
	{
		final MysqlDataSource ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/microstreamschema");
		ds.setUser("root");
		ds.setPassword("1234");
		ds.setPort(3306);

		return ds;
	}

	public static List<Customer> loadCustomers()
		throws JsonSyntaxException, JsonIOException, IOException
	{

		final Reader         reader    = Files.newBufferedReader(Paths.get("c:/getmockupdata-export.json"));
		final List<Customer> customers = new Gson().fromJson(reader, new TypeToken<List<Customer>>()
										{}.getType());
		
		reader.close();

		return customers;
	}
}
