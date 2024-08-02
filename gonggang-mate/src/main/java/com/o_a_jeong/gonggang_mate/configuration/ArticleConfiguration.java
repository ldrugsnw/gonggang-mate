package com.o_a_jeong.gonggang_mate.configuration;

//Second

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.o_a_jeong.gonggang_mate.entities.articledb.repository",
        entityManagerFactoryRef = "articleEntityManager",
        transactionManagerRef = "articleTransactionManager"
)

public class ArticleConfiguration {

    @Bean
    public PlatformTransactionManager articleTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(articleEntityManager().getObject());

        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean articleEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(articleDataSource());
        em.setPackagesToScan(new String[]{"com.o_a_jeong.gonggang_mate.entities.articledb.entity"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return em;
    }
    @Bean
    public DataSource articleDataSource(){

        return DataSourceBuilder.create()
                .driverClassName("") // ...?
                .url("")
                .username("")
                .password("")
                .build();
    }
}
