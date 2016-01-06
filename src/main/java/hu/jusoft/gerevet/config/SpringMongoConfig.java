package hu.jusoft.gerevet.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

/**
 * Created by Regina Seres on 1/2/2016.
 */

@Configuration
   public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoUrl;

    @Value("${spring.data.mongodb.username}")
    private String  userName;

    @Value("${spring.data.mongodb.password}")
    private String  password;

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return "gerevet";
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception
    {
        final UserCredentials userCredentials = new UserCredentials(this.userName, this.password);

        final MongoTemplate mongoTemplate = new MongoTemplate(mongo(), getDatabaseName(), userCredentials);
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);

        return mongoTemplate;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoUrl);
    }
}


