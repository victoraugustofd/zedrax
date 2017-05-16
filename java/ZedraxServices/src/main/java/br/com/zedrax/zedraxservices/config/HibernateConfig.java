package br.com.zedrax.zedraxservices.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableAutoConfiguration
@EntityScan( basePackages = "${hibernate.entity_scan}" )
@EnableJpaRepositories( basePackages = "${hibernate.repositories_scan}" )
public class HibernateConfig
{
	@Value( "${hibernate.dialect}" )
	private String hibernateDialect;
	
	@Value( "${hibernate.generate_ddl}" )
	private String hibernateGenerateDdl;
	
	@Value( "${hibernate.show_sql}" )
	private String hibernateShowSql;
	
	@Value( "${hibernate.jdbc.fetch_size}" )
	private String hibernateFetchSize;
	
	@Value( "${hibernate.hbm2ddl.auto}" )
	private String hibernateHbm2ddlAuto;
	
	@Value( "${hibernate.entity_scan}" )
	private String hibernateEntityScan;
	
	@Value( "${hibernate.persistence_unit}" )
	private String hibernatePersistenceUnit;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean( name = "jpaVendorAdapter" )
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl( Boolean.parseBoolean( hibernateGenerateDdl ) );
		jpaVendorAdapter.setShowSql( Boolean.parseBoolean( hibernateShowSql ) );
		jpaVendorAdapter.setDatabasePlatform( hibernateDialect );
		
		return jpaVendorAdapter;
	}
	
	@Bean( name = "entityManagerFactory" )
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource( dataSource );
		lef.setPackagesToScan( hibernateEntityScan );
		lef.setJpaVendorAdapter( jpaVendorAdapter() );
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty( "hibernate.jdbc.fetch_size", hibernateFetchSize );
		hibernateProperties.setProperty( "hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto );
		
		lef.setJpaProperties( hibernateProperties );
		return lef;
	}
}