package config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.hef.order.db")
public class MongoConfig2 extends AbstractMongoConfiguration {
    /**
     * 创建MongoClient客户端
     * @return
     */
    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    /**
     * 指定数据库名称
     * @return
     */
    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }
}
