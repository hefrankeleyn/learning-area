package config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 注解 EnableMongoRepositories 启用MongoDB的Repository功能
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.hef.order.db")
public class MongoConfig {

    @Bean
    public MongoClientFactoryBean mongoClient() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }

    @Bean
    public MongoOperations mongoOperations(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient,"OrdersDB");
    }


}
