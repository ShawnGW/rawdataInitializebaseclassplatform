package com.vtest.it.ftplatform.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(value = "com.vtest.it.ftplatform.dao.vtftmt",sqlSessionTemplateRef = "FtSqlSessionTemplate")
public class VtftmtDataSourceConfiguration {
    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid.vtftmt")
    public DruidDataSource VtFtDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.setFilters("stat,log4j,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean("FtSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("VtFtDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/config/vtftmt/config.xml"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/vtftmt/mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("FtSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Autowired @Qualifier("FtSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean("FtDataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Autowired @Qualifier("VtFtDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
