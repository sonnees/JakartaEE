package vn.edu.iuh.fit.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.session.JdbcSessionProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(JdbcSessionProperties.class)
public class DataSourceConfig {

    @Bean
    @Primary
    @Qualifier("dataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource(@Qualifier("dataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    @Qualifier("tempDataSourceProperties")
    @ConfigurationProperties("temp.datasource")
    public DataSourceProperties tempDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("tempDataSource")
    @SpringSessionDataSource
    public DataSource sessionDataSource(@Qualifier("tempDataSourceProperties") DataSourceProperties tempDataSourceProperties){
        return tempDataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }
}
