package com.phoebusbank.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.phoebusbank.model.Account;
import com.phoebusbank.model.Customer;
import com.phoebusbank.model.CustomerAccount;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

 private static final String PROPERTY_NAME_DATABASE_DRIVER = "oracle.driver";
 private static final String PROPERTY_NAME_DATABASE_PASSWORD = "oracle.password";
 private static final String PROPERTY_NAME_DATABASE_URL = "oracle.jdbcUrl";
 private static final String PROPERTY_NAME_DATABASE_USERNAME = "oracle.username";

 @Resource
 private Environment env;
 
 @Bean
 public DataSource dataSource() {
 DriverManagerDataSource dataSource = new DriverManagerDataSource();
 dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
 dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
 dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
 dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
 
 return dataSource;
 }
 
 @Bean
 public SessionFactory sessionFactory() 
 {
 LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
 builder.scanPackages("com.phoebusbank.model").addProperties(getHibernateProperties());
 builder.addAnnotatedClasses(Account.class,Customer.class,CustomerAccount.class);
 
 return builder.buildSessionFactory();
 }
 
 private Properties getHibernateProperties() {
 Properties prop = new Properties();
 prop.put("hibernate.show_sql", "true");
 prop.put("hibernate.connection.pool_size", "5");
 prop.put("hibernate.hbm2ddl.auto", "update");
 return prop;
 }

 @Bean
 public HibernateTransactionManager transactionManager() {
 return new HibernateTransactionManager(sessionFactory());
 }
  
}