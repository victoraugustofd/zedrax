package br.com.zedrax.services.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration("hibernateConfig")
@EnableAutoConfiguration
@EntityScan(basePackages = "${hibernate.entity-scan}")
@EnableJpaRepositories(basePackages = "${hibernate.repositories-scan}")
public class HibernateConfig {
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.generate-ddl}")
	private String hibernateGenerateDdl;

	@Value("${hibernate.show-sql}")
	private String hibernateShowSql;

	@Value("${hibernate.jdbc.fetch-size}")
	private String hibernateFetchSize;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	@Value("${hibernate.entity-scan}")
	private String hibernateEntityScan;

	@Value("${hibernate.persistence-unit}")
	private String hibernatePersistenceUnit;

	@Autowired
	private DataSource dataSource;

	@Bean(name = "jpaVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean(hibernateGenerateDdl));
		jpaVendorAdapter.setShowSql(Boolean.parseBoolean(hibernateShowSql));
		jpaVendorAdapter.setDatabasePlatform(hibernateDialect);

		return jpaVendorAdapter;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setPackagesToScan(hibernateEntityScan);
		lef.setJpaVendorAdapter(jpaVendorAdapter());

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.jdbc.fetch-size", hibernateFetchSize);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);

		lef.setJpaProperties(hibernateProperties);
		return lef;
	}
}