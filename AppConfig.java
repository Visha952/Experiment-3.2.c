package com.example.bank.config;

import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.example.bank")
public class AppConfig {
 @Bean
 public DataSource dataSource(){
     DriverManagerDataSource ds = new DriverManagerDataSource();
     ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
     ds.setUrl("jdbc:mysql://localhost:3306/bankdb");
     ds.setUsername("root");
     ds.setPassword("root");
     return ds;
 }

 @Bean
 public LocalContainerEntityManagerFactoryBean emf(){
     LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
     em.setPackagesToScan("com.example.bank.entity");
     em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
     em.setDataSource(dataSource());
     return em;
 }

 @Bean
 public PlatformTransactionManager txManager(){
     return new JpaTransactionManager(emf().getObject());
 }
}
