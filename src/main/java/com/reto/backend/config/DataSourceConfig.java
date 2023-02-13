package com.reto.backend.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "dsRetoBackend")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSourceOne(){ return DataSourceBuilder.create().build();}

    @Primary
    @Bean(name = "JdbcTemplateRetoBackend")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dsRetoBackend") DataSource ds){
        return new NamedParameterJdbcTemplate(ds);
    }

}
