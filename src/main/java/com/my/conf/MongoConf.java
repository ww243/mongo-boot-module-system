package com.my.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import javax.annotation.Resource;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/07 19:48
 */
@Configuration
public class MongoConf implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        MongoConverter converter = mongoTemplate.getConverter();
        if(converter.getTypeMapper().isTypeKey("_class")){
            ((MappingMongoConverter) converter).setTypeMapper(new DefaultMongoTypeMapper(null));
        }
    }
}
