package com.rak.config;

import java.util.Properties;

import org.hibernate.cfg.Environment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = "classpath:/com/rak/resources/db.properties", ignoreResourceNotFound = true)
@EnableTransactionManagement
@ComponentScan(basePackages = "com.rak")
public class SpringAppConfig {
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		Properties props = new Properties();

		props.put("DRIVER", env.getProperty("hibernate.connection.driver_class"));
		props.put("URL", env.getProperty("hibernate.connection.url"));
		props.put("USER", env.getProperty("hibernate.connection.username"));
		props.put("PASS", env.getProperty("hibernate.connection.password"));

		// Setting Hibernate properties
		props.put("DIALECT", env.getProperty("hibernate.dialect"));
		props.put("SHOW_SQL", env.getProperty("hibernate.show_sql"));
		props.put("HBM2DDL_AUTO", env.getProperty("hibernate.hbm2ddl.auto"));

		factoryBean.setHibernateProperties(props);
		factoryBean.setPackagesToScan("com.rak.model");

		return factoryBean;

	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
