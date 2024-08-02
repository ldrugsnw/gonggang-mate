package com.o_a_jeong.gonggang_mate.configuration;

//primary

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.o_a_jeong.gonggang_mate.entities.userdb.repository",
    entityManagerFactoryRef = "userEntityManager",
    transactionManagerRef = "userTransactionManager"
)

public class UserConfiguration {

    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(userEntityManager().getObject());

        return transactionManager;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(userDataSource());
        em.setPackagesToScan(new String[]{"com.o_a_jeong.gonggang_mate.entities.userdb.entity"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return em;
    }
    @Primary
    @Bean
    public DataSource userDataSource(){

        return DataSourceBuilder.create()
                .driverClassName("") // ...?
                .url("")
                .username("")
                .password("")
                .build();
    }
}
