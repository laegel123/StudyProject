package com.example.jpastudy.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuerydslConfiguration {
    @PersistenceContext(unitName = "firstEntityManagerFactory")
    private EntityManager firstEntityManager;

    @Bean
    public JPAQueryFactory selperJpaQueryFactory() {
        return new JPAQueryFactory(firstEntityManager);
    }

}
