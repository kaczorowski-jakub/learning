package com.os.udemy.jpa.multipledb.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.os.udemy.jpa.multipledb.coupon.Coupon;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "couponEntityManagerFactory", transactionManagerRef = "couponTransactionManager", basePackages = {
        "com.os.udemy.jpa.multipledb.coupon" })
public class CouponDataSourceConfig {

    @Primary
    @Bean(name = "couponDataSourceProperties")
    @ConfigurationProperties("spring.datasource-coupon")
    public DataSourceProperties couponDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "couponDataSource")
    public DataSource couponDataSource() {
        return couponDataSourceProperties().initializeDataSourceBuilder().type(PGSimpleDataSource.class).build();
    }

    @Primary
    @Bean(name = "couponEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean couponEntityManagerFactory(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        return entityManagerFactoryBuilder.dataSource(couponDataSource()).packages(Coupon.class).build();
    }

    @Primary
    @Bean(name = "couponTransactionManager")
    public PlatformTransactionManager couponTransactionManager(
            @Qualifier("couponEntityManagerFactory") EntityManagerFactory couponEntityManagerFactory) {
        return new JpaTransactionManager(couponEntityManagerFactory);
    }

}
