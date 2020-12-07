package com.my.dao;

import com.my.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/07 19:47
 */
public interface UserDao extends MongoRepository<User,String> {
}
