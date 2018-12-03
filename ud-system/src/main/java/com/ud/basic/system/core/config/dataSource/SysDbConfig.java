package com.ud.basic.system.core.config.dataSource;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.SqlUtilConfig;

@Configuration
@MapperScan(value = {"com.ud.basic.system.persistence.sys.auto.mapper","com.ud.basic.system.persistence.sys.ext.mapper"}, sqlSessionFactoryRef = "sysSqlSessionFactory")
public class SysDbConfig {

	@Autowired
    @Qualifier("sysDB")
    private DataSource sys;

    @Bean
    public SqlSessionFactory sysSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(sys);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] baseRes = resolver.getResources("classpath:com/ud/basic/system/persistence/sys/**/*.xml");
        factoryBean.setMapperLocations(baseRes);
        
        //配置分页插件
        PageHelper pageHelper = new PageHelper();
        SqlUtilConfig sqlUtilConfig = new SqlUtilConfig();
        sqlUtilConfig.setDialect("mysql");
        sqlUtilConfig.setReasonable(false);
        sqlUtilConfig.setRowBoundsWithCount(true);
        sqlUtilConfig.setOffsetAsPageNum(true);

        pageHelper.setSqlUtilConfig(sqlUtilConfig);
        Interceptor[] plugins = new Interceptor[]{pageHelper };
        factoryBean.setPlugins(plugins);
        
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sysSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sysSqlSessionFactory());
        return template;
    }
}
