package com.myexample.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@EnableJpaRepositories(basePackages = "com.myexample.demo.repository", transactionManagerRef = "jpaTransactionManager")
//@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class JpaConfig {

//	@Autowired
//	private Environment env;
	
	@Value("${spring.datasource.driver-class-name}")
	private String DRIVER_CLASS_NAME;
	
	@Value("${entitymanager.packagesToScan}")
	private String PACKAGES_TO_SCAN;
	
	@Value("${hibernate.dialect}")	
	private String DIALECT;
	
	@Value("${hibernate.show_sql}")
	private String SHOW_SQL;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;
	
	@Value("${spring.datasource.username}")
	private String USERNAME;
	
	@Value("${spring.datasource.password}")
	private String PASSWORD;
	
	@Value("${spring.datasource.url}")
	private String URI;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	/*
//
//	@Bean
//	public DataSource dataSource() {
//
//		String username = env.getProperty("spring.datasource.username");
//		String password = env.getProperty("spring.datasource.password");
//		String driverClass = env.getProperty("spring.datasource.driver-class-oracle.jdbc.driver.OracleDriver");
//		String url = env.getProperty("spring.datasource.url");
//
//		return DataSourceBuilder.create().username(username).password(password).url(url).driverClassName(driverClass)
//				.build();
//	}
	
	 //
//	@Bean
//	public JpaTransactionManager jpaTransactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//		return transactionManager;
//	}
//	
//    //adding for future use
//	private HibernateJpaVendorAdapter vendorAdaptor() {
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		return vendorAdapter;
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
//		entityManagerFactoryBean.setDataSource(dataSource());
//		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//		entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
//		entityManagerFactoryBean.setJpaProperties(addProperties());
//
//		return entityManagerFactoryBean;
//	}
//
//	private Properties addProperties() {
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
//		properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//		properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//		properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
//		// we can add 
//		return properties;
//	}
	 */
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Bean
	public DataSource dataSource() {
//		String username = env.getProperty("spring.datasource.username");
//		String password = env.getProperty("spring.datasource.password");
//		String driverClass = env.getProperty("spring.datasource.driver-class-name");
//		String url = env.getProperty("spring.datasource.url");
		
	    
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URI);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	} 

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", DIALECT);
		hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        return hibernateProperties;
    }
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
