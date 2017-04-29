package br.com.zedrax.zedraxservices;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class Config
{
	public static void main( String[] args )
	{
		SpringApplication.run( Config.class, args );
	}
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName( "org.sqlite.JDBC" );
		dataSource.setUrl( "jdbc:sqlite:test.db" );
		dataSource.setUsername( "" );
		dataSource.setPassword( "" );
		
		return dataSource;
	}
}