package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "com.hef.spittr", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = EnableWebMvc.class)})
@Import(value = {CachingConfig.class})
public class RootConfig {

    /**
     * 配置数据源， 使用连接池
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/Documents/opt/servers/h2databases/spittr");
        ds.setUsername("spittr");
        ds.setPassword("spittr");
        ds.setInitialSize(5);
        return ds;
    }


    /**
     * 使用Spring提供的jdbc模板
     *
     * @return
     */
    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}