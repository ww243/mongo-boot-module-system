package com.my;

import com.my.dao.UserDao;
import com.my.entity.User;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:ljn
 * @Description:
 * @Date:2020/12/07 19:52
 */
@SpringBootTest
public class MongoSpringbootApplicationTests {
    @Resource
    MongoTemplate mongoTemplate;
    @Resource
    UserDao userDao;


    /**
     *
     *@param:查询
    */
    @Test
    public void testfind(){
        //根据id查询文档
        User id = mongoTemplate.findById("23", User.class);
        System.out.println("根据id查询文档:"+id);
        //查询一个文档
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("小黄人"));
        User one = mongoTemplate.findOne(query, User.class);
        System.out.println("查询一个文档:"+one);
        //查询所有
        List<User> all = mongoTemplate.findAll(User.class);
        all.forEach(a-> System.out.println(a));
        //根据条件查询文档
        List<User> users = mongoTemplate.find(query, User.class);
        users.forEach(a1-> System.out.println(a1));
    }
    /**
     *
     *@param:添加
     */
    @Test
    public void add(){
        //单个添加
        User user = new User("2", "小楠", 16, new Date());
        mongoTemplate.insert(user);
        //数据库有，就新增， 没有，就修改
        mongoTemplate.save(user);
        //批量添加
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("3","xiaocao",19,new Date()));
        users.add(new User("4","xiaomeng",22,new Date()));
        users.add(new User("5","xiaoyi",21,new Date()));
        mongoTemplate.insertAll(users);
        List<User> all = mongoTemplate.findAll(User.class);
        all.forEach(a-> System.out.println(a));
    }

    /**
     *
     *@param:修改
     */
    @Test
    public void update(){
        //修改符合条件第一条记录
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("小楠"));
        //设置数据
        Update update = new Update();
        update.set("name","小姚");
        //修改
        mongoTemplate.updateFirst(query,update,User.class);
        System.out.println(mongoTemplate.findById("1", User.class));

    }

    /**
     *
     *@param:删除
    */
    @Test
    public void remove(){
        //判断
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is("2"));
        //根据id删除
        mongoTemplate.remove(query,User.class);
    }
}

