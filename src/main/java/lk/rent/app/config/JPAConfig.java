package lk.rent.app.config;/*
author :Himal
version : 0.0.1
*/

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "lk.rent.app.repo")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class JPAConfig {
    @Autowired
    Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter va){
        LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        containerEntityManagerFactoryBean.setDataSource(ds);
        containerEntityManagerFactoryBean.setJpaVendorAdapter(va);
        containerEntityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("app.entity.packageName"));
        return containerEntityManagerFactoryBean;
    }

    @Bean
    public DataSource dataSource(){

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(env.getRequiredProperty("app.db.userName"));
        basicDataSource.setPassword(env.getRequiredProperty("app.db.password"));
        basicDataSource.setUrl(env.getRequiredProperty("app.db.url"));
        basicDataSource.setDriverClassName(env.getRequiredProperty("app.db.driverClass"));

        return  basicDataSource;

    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabasePlatform(env.getRequiredProperty("app.hibernate.platform"));
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        return hibernateJpaVendorAdapter;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
