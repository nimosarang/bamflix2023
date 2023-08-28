package com.bamflix.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties") //	해당 클래스에서 참조할 properties의 경로를 선언
public class DatabaseConfig {

    @Autowired
    private ApplicationContext context; // 스프링 컨테이너(Spring Container) 중 하나, 스프링 컨테이너는 빈(Bean)의 생성과 사용, 관계, 생명 주기 등을 관리

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari") // @PropertySource에 선언된 파일(application.properties)에서 prefix에 해당하는 spring.datasource.hikari로 시작하는 설정을 모두 읽어 들여 해당 메서드에 매핑(바인딩)
    public HikariConfig hikariConfig() {
        // 커넥션 풀(Connection Pool) 라이브러리
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        // 커넥션 풀을 지원하기 위한 인터페이스
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception { //  SqlSessionFactory는 DB 커넥션과 SQL 실행에 대한 모든 것을 갖는 객체
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean(); //  FactoryBean 인터페이스의 구현 클래스로, 마이바티스(MyBatis)와 스프링의 연동 모듈로 사용
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:/mappers/**/*Mapper.xml")); // XML Mapper의 경로를 선언해 주어야 스프링이 XML Mapper를 인식
        factoryBean.setConfiguration(mybatisConfig()); // mybatisConfig( ) 빈(Bean)을 이용해서 MyBatis 옵션을 설정
        // factoryBean 객체는 데이터 소스를 참조하며, XML Mapper(SQL 쿼리 작성 파일)의 경로와 설정 파일 경로 등의 정보를 갖는 객체
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        // DB의 커밋, 롤백 등 SQL의 실행에 필요한 모든 메서드를 갖는 객체
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        // application.properties에서 mybatis.configuration으로 시작하는 모든 설정을 읽어 스프링 컨테이너에 빈(Bean)으로 등록
        return new org.apache.ibatis.session.Configuration();
    }

}