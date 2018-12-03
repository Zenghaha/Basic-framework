package com.ud.basic.system.core.config.dataSource;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class SysDataSourceConfig {
  
	@Bean(name = "sysDB")  
    @ConfigurationProperties(prefix = "spring.datasource.sys")
    public DataSource sysDataSource() {  
        DruidDataSource dataSource = new DruidDataSource();  
        return dataSource;  
    }  
	
	@Bean
    public PlatformTransactionManager sysTransactionManager() {
        return new DataSourceTransactionManager(sysDataSource());
    }
}
