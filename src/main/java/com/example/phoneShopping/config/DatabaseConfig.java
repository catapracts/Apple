package com.example.phoneShopping.config;

// 자바의 로깅(Logging) 라이브러리 조합 = SLF4J+Logback
// slf4j(Simple Logging Facade for Java) = 로깅 Facade(퍼사드) = 로깅에 대한 추상 레이어를 제공하는 interface의 모음 / Logback를 사용하기 쉽게 포장하는 역할
// Logback = 실질적인 로깅 라이브러리 구현체
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Date;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig 
{
    private final Logger logger = LoggerFactory.getLogger(
            DatabaseConfig.class);

        @Bean
        @ConfigurationProperties(prefix = "spring.datasource.hikari")
        public HikariConfig hikariConfig() 
        {
            logger.info("DatabaseConfig dataSource(): {}", new Date());
            return new HikariConfig();
        }

        @Bean
        public DataSource dataSource() 
        {
            logger.info("DatabaseConfig dataSource(): {}", new Date());
            DataSource dataSource = new HikariDataSource(hikariConfig());
            logger.info("DatabaseConfig dataSource(): dataSource={}", dataSource);
            return dataSource;
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception 
        {
            logger.info("DatabaseConfig sqlSessionFactory(): {}", new Date());
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            Resource[] resources = new PathMatchingResourcePatternResolver()
                                    .getResources("classpath:sqls/*.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

            return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) 
        {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
}
