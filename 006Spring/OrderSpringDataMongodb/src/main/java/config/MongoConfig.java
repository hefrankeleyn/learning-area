package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 注解 EnableMongoRepositories 启用MongoDB的Repository功能
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.hef.order.db")
public class MongoConfig {
}
