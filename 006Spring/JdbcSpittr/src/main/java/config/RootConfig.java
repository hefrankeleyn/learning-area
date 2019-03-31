package config;

import com.hef.spittr.dao.TemplateSpitterDao;
import com.hef.spittr.dao.impl.TemplateSpitterDaoImpl;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.hef.spittr"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = EnableWebMvc.class)})
@ImportResource(value = {"classpath:/spring/db-config.xml"})
public class RootConfig {

    /**
     * 使用 Spring 提供的 Jdbc模板
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public TemplateSpitterDao templateSpitterDao(JdbcTemplate jdbcTemplate){
        return new TemplateSpitterDaoImpl(jdbcTemplate);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
