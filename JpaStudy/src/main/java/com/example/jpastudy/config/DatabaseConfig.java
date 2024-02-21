package com.example.jpastudy.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableTransactionManagement // 트랜잭션 처리 허용
@RequiredArgsConstructor
@EnableJpaRepositories(
        basePackages = "com.example.jpastudy.**.repository",
        entityManagerFactoryRef = "entityManagerFactory"
)
public class DatabaseConfig {

    @Bean(name = {"dataSource", "firstDataSource"})
    public DataSource firstDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setConnectionInitSql("select 1");
        hikariConfig.setConnectionTestQuery("select 1");
        hikariConfig.setConnectionTimeout(1000*5);
        hikariConfig.setDriverClassName("org.h2.Driver");
        hikariConfig.setIdleTimeout(1000*15);
        hikariConfig.setInitializationFailTimeout(1000*3);
        hikariConfig.setMaximumPoolSize(3);
        hikariConfig.setMaxLifetime(1000*60*3);
        hikariConfig.setPoolName("example-network");
        //hikariConfig.setSchema("schema");
        hikariConfig.setValidationTimeout(1000*2);

        hikariConfig.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
        hikariConfig.setUsername("sa");
        hikariConfig.setPassword("");

        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("firstDataSource")
            DataSource firstDataSource,
            ApplicationContext applicationContext) throws Exception {
        log.info("applicationContext: {}", applicationContext.toString());

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(firstDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.jpastudy.**.dto");

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = {"entityManagerFactory", "firstEntityManagerFactory"})
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("firstDataSource") DataSource firstDataSource) {
        return builder
                .dataSource(firstDataSource)
                .packages("com.example.jpastudy")
                .build();
    }

}
