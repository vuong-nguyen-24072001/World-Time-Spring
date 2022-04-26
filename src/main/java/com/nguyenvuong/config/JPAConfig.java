package com.nguyenvuong.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "com.nguyenvuong.repository" })
@EnableTransactionManagement
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		// persistence-data là file quy định để định nghĩa ra các entity nào cần map
		// tương ứng với tabel nào trong db
		em.setPersistenceUnitName("persistence-data");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	// bật tinh năng tự động transaction (bật object dể thao tác db, đóng object khi
	// thực hiện xong, commit, rollback, ... giống JDBC)
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://bfzw9fmmyj7bk7sqfi4t-mysql.services.clever-cloud.com:3306/bfzw9fmmyj7bk7sqfi4t");
		dataSource.setUsername("us1ktm1ee1wa5emv");
		dataSource.setPassword("r0uT5o6bxEICSo3BD6qA");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/worldtime");
//		dataSource.setUsername("root");
//		dataSource.setPassword("vuongnguyen04040707");
		return dataSource;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		// ở thời điểm ban đầu, phải dùng create-drop để generate từ entity thành 1 bảng
		// table trong db,
		// khi đã ổn định, db đã đầy đủ thì ta k cần create-drop nữa thì comment lại và
		// để lại là none
		//properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		 properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}

}
