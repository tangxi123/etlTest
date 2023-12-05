package testcase.base.config;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import testcase.base.tool.ReadProperties;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "testcase.base.mapper.ods",sqlSessionFactoryRef = "odsSqlSessionFactory")
public class OdsDatabaseConfig {
    @Autowired
    ReadProperties readProperties;


    @Bean("odsDataSource")
    public DataSource odsDataSource(){
       return DataSourceBuilder.create()
                .driverClassName(readProperties.getOdsDatasourceDriverClassName())
                .url(readProperties.getOdsDatasourceJdbcUrl())
                .username(readProperties.getOdsDatasourceUsername())
                .password(readProperties.getOdsDatasourcePassword())
                .build();
    }

    @Bean("odsSqlSessionFactory")
    public SqlSessionFactory odsSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(odsDataSource());
        return sqlSessionFactoryBean.getObject();

    }
}
