package config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 注解 EnableNeo4jRepositories, 能够让Spring Data Neo4J 自动生成Neo4j Repository实现
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.hef.store.db")
@EnableTransactionManagement
public class Neo4jConfig {
    private static final String uri ="bolt://localhost:7687";
    private static final String username ="neo4j";
    private static final String password ="world";

    @Bean
    public SessionFactory sessionFactory(){
        // with domain entity base package
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
                .uri(uri)
                .credentials(username, password)
                .build();
        return new SessionFactory(configuration,"com.hef.store.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager(){
        return new Neo4jTransactionManager(sessionFactory());
    }


}
